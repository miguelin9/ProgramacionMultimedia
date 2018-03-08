package es.vcarmen.sonidos04;

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
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class Sonidos04 extends AppCompatActivity {

    // Para el callback de pedir permiso
    private final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private ImageButton grabar, pause, play;
    private MediaRecorder miGrabadora;
    private String salida = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos04);

        // Pedir permiso grabar sonido
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                // Se tiene permiso
            }else{
                ActivityCompat.requestPermissions(Sonidos04.this,new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }else{
            // No se necesita requerir permiso OS menos a 6.0.
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // Se tiene permiso
            }else{
                ActivityCompat.requestPermissions(Sonidos04.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }else{
            // No se necesita requerir permiso OS menos a 6.0.
        }

        grabar = (ImageButton) findViewById(R.id.ib_grabar);
        pause = (ImageButton) findViewById(R.id.ib_pause);
        play = (ImageButton) findViewById(R.id.ib_play);
        grabar.setEnabled(true);
        pause.setEnabled(false);
        play.setEnabled(false);

        // Pedir permiso escribir en storage
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // Se tiene permiso
            }else{
                ActivityCompat.requestPermissions(Sonidos04.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }else{
            // No se necesita requerir permiso OS menos a 6.0.
        }

        salida = Environment.getExternalStorageDirectory().getAbsolutePath() + "/grabado.3gp";
        miGrabadora = new MediaRecorder();
        miGrabadora.setAudioSource(MediaRecorder.AudioSource.MIC);
        miGrabadora.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        miGrabadora.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        miGrabadora.setOutputFile(salida);

    }

    // Respuesta de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONS:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // El usuario acepto los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_SHORT).show();
                }else{
                    // Permiso denegado.
                    Toast.makeText(this, "No se aceptó permisos", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    void click(View v) {
        switch (v.getId()) {
            case R.id.ib_grabar:
                try {
                    miGrabadora.prepare();
                    miGrabadora.start();
                    Toast.makeText(this, "Grabando...", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                grabar.setEnabled(false);
                pause.setEnabled(true);
                break;
            case R.id.ib_pause:
                miGrabadora.stop();
                miGrabadora.release();
                Toast.makeText(this, "Grabación finalizada.", Toast.LENGTH_SHORT).show();
                miGrabadora = null;
                play.setEnabled(true);
                pause.setEnabled(false);
                break;
            case R.id.ib_play:
                MediaPlayer repro = new MediaPlayer();
                try {
                    repro.setDataSource(salida);
                    repro.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                repro.start();
                Toast.makeText(this, "Reproduciendo...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
// Falta preguntar permisos que hay que abrir la app 2 veces para aceptar los 2
