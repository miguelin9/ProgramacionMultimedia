package es.vcarmen.video02;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Video02 extends AppCompatActivity {

    // Para el callback de pedir permiso
    private final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private VideoView video;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video02);

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

        mediaController = new MediaController(this, true);
        video = (VideoView) findViewById(R.id.vv_video);
        video.setVideoPath("/storage/emulated/0/DCIM/Camera/VID_20170814_035429.mp4");
        //video.setVideoURI(Uri.parse("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp"));
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);
        video.start();
        video.requestFocus();

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