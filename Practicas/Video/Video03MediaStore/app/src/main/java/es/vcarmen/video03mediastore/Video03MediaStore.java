package es.vcarmen.video03mediastore;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Video03MediaStore extends AppCompatActivity implements SurfaceHolder.Callback, View.OnClickListener{

    // Para el callback de pedir permiso
    private final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private TextView titulo;
    private Button reproducir, pausar;
    private Spinner spinner;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer mediaPlayer;
    private Uri pelicula;
    private boolean pausa = false;
    final Uri mediaSrc = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video03_media_store);

        // Pedir permiso escribir en storage
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // Se tiene permiso
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }else{
            // No se necesita requerir permiso OS menos a 6.0.
        }

        titulo = (TextView) findViewById(R.id.video);
        reproducir = (Button) findViewById(R.id.reproduce);
        reproducir.setOnClickListener(this);
        pausar = (Button) findViewById(R.id.pausa);
        pausar.setOnClickListener(this);
        spinner = (Spinner) findViewById(R.id.spinner);
        surfaceView = (SurfaceView) findViewById(R.id.surface);
        Cursor cursor = managedQuery(mediaSrc, null, null, null, MediaStore.Video.Media.TITLE);
        String[] nombre = {MediaStore.MediaColumns.TITLE};
        int[] ids = {android.R.id.text1};
        final SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, nombre, ids);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = adaptador.getCursor();
                cursor.moveToPosition(position);
                String indice = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                pelicula = Uri.withAppendedPath(mediaSrc, indice);
                titulo.setText(pelicula.toString());
                Toast.makeText(getApplicationContext(), titulo.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setFixedSize(176,144);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        mediaPlayer = new MediaPlayer();

    }

    // Respuesta de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONS:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // El usuario acepta los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_LONG).show();
                }else{
                    // Permiso denegado.
                    Toast.makeText(this, "No se aceptó permisos", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reproduce:
                this.pausa = false;
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.reset();
                }
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDisplay(surfaceHolder);
                try {
                    mediaPlayer.setDataSource(getApplicationContext(), pelicula);
                    mediaPlayer.prepare();
                } catch (IOException | IllegalStateException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                break;
            case R.id.pausa:
                if (pausa) {
                    this.pausa = false;
                    mediaPlayer.start();
                } else {
                    this.pausa = true;
                    mediaPlayer.pause();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
// Finalizada