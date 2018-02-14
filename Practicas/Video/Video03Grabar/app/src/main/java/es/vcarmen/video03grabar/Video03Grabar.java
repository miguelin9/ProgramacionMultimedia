package es.vcarmen.video03grabar;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Video03Grabar extends AppCompatActivity implements SurfaceHolder.Callback, View.OnClickListener {

    // Para el callback de pedir permiso
    private final int STORAGE = 1;
    private final int CAMARA = 2;
    private final int AUDIO = 3;

    private TextView destino;
    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;
    private Button play, pause, grabar;
    private MediaRecorder grabador;
    private MediaPlayer reproductor;
    private String ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video03_grabar);

        Log.e("Miguel", "inicio onCreate");
        // Pedir permiso escribir en STORAGE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // Se tiene permiso
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE);
                return;
            }
        } else {
            // No se necesita requerir permiso OS menos a 6.0.
        }

        // Pedir permiso escribir en CAMARA
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                // Se tiene permiso
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMARA);
                return;
            }
        } else {
            // No se necesita requerir permiso OS menos a 6.0.
        }

        // Pedir permiso escribir RECORD AUDIO
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                // Se tiene permiso
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, AUDIO);
                return;
            }
        } else {
            // No se necesita requerir permiso OS menos a 6.0.
        }

        Log.e("Miguel", "fin de pedido de permisos");

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pausa);
        grabar = (Button) findViewById(R.id.grabar);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        grabar.setOnClickListener(this);

        surfaceView = (SurfaceView) findViewById(R.id.surface);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


            reproductor = new MediaPlayer();




            grabador = new MediaRecorder();



        ruta = Environment.getExternalStorageDirectory() + "/mivideo.mp4";
        Log.e("Miguel", "fin del onCreate");

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
    protected void onDestroy() {
        super.onDestroy();
        grabador.release();
        reproductor.release();
    }

    @Override
    public void onClick(View v) throws IllegalStateException {
        switch (v.getId()) {
            case R.id.grabar:
                grabador.setPreviewDisplay(surfaceHolder.getSurface());

                grabar.setEnabled(false);
                pause.setEnabled(true);
                play.setEnabled(false);

                grabador.setAudioSource(MediaRecorder.AudioSource.MIC);
                grabador.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                grabador.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                grabador.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                grabador.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
                grabador.setOutputFile(ruta);
                Log.e("Miguel", "Antes del try");
                try {
                    grabador.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                grabador.start();
                Log.e("Miguel","Grabador lanzado.");
                break;
            case R.id.pausa:
                break;
            case R.id.play:
                reproductor.setDisplay(surfaceHolder);
                break;
        }
    }

    // Respuesta de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // El usuario acepta los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_LONG).show();
                } else {
                    // Permiso denegado.
                    Toast.makeText(this, "No se aceptó permisos STORAGE", Toast.LENGTH_SHORT).show();
                }
                return;
            case AUDIO:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // El usuario acepta los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_LONG).show();
                } else {
                    // Permiso denegado.
                    Toast.makeText(this, "No se aceptó permisos AUDIO", Toast.LENGTH_SHORT).show();
                }
                return;
            case CAMARA:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // El usuario acepta los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_LONG).show();
                } else {
                    // Permiso denegado.
                    Toast.makeText(this, "No se aceptó permisos CAMARA", Toast.LENGTH_SHORT).show();
                }
                return;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
