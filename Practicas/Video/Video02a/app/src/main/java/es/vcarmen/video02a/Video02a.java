package es.vcarmen.video02a;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Video02a extends AppCompatActivity implements SurfaceHolder.Callback {

    // Para el callback de pedir permiso
    private final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    Uri pelicula;
    public TextView titulo;
    MediaPlayer reproductor;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean pausa = false;
//Uri video=Uri.parse("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");

//Uri video = Uri.parse("android.resource://" + getPackageName() + "/"+ R.raw.video);
//Uri video=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/video.mp4");
// Uri video = Uri.parse(""/storage/emulated/0/DCIM/Camera/VID_20170814_035429.mp4"");
//String video = "/storage/emulated/0/DCIM/Camera/VID_20170814_035429.mp4";
    String video = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/VID_20170814_035429.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video02a);

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

        Button botonPlay = (Button) findViewById(R.id.reproduce);
        Button botonPausa = (Button) findViewById(R.id.pausa);
        titulo = (TextView) findViewById(R.id.video);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        surfaceView = (SurfaceView) findViewById(R.id.surface);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(176, 144);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        reproductor = new MediaPlayer();botonPlay.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                pausa = false;
                if (reproductor.isPlaying()) {
                    reproductor.reset();
                }
                reproductor.setAudioStreamType(AudioManager.STREAM_MUSIC);
                reproductor.setDisplay(surfaceHolder);
                try {
                    reproductor.setDataSource(video);
//reproductor.setDataSource(getApplication(),video);
                    reproductor.prepare();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                reproductor.start();
            }
        });
        botonPausa.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (pausa) {
                    pausa = false;
                    reproductor.start();
                } else {
                    pausa = true;
                    reproductor.pause();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        reproductor.release();
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

    // Respuesta de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONS:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // El usuario acepta los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_SHORT).show();
                }else{
                    // Permiso denegado.
                    Toast.makeText(this, "No se aceptó permisos", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
// Finalizada