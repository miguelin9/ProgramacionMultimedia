package es.vcarmen.sonido02;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class Sonido02 extends AppCompatActivity {

    TextView tvTitulo, tvDuracion;
    SeekBar sbProceso;
    MediaPlayer mediaPlayer;
    double tiempoFinal, tiempoPasado;
    int avance;
    private Handler controladorTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido02);

        tvTitulo = (TextView) findViewById(R.id.tv_titulo);
        tvDuracion = (TextView) findViewById(R.id.tv_duracion);
        sbProceso = (SeekBar) findViewById(R.id.sb_progreso);
        sbProceso.setClickable(false);
        avance = 2000;

        mediaPlayer = MediaPlayer.create(this, R.raw.codigo_davinci);
        tiempoFinal = mediaPlayer.getDuration();
        sbProceso.setMax((int)tiempoFinal);
        tvTitulo.setText("codigo_davinci.mp3");

        controladorTiempo = new Handler();

    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.ib_adelante:
                if ((tiempoPasado + avance) <= tiempoFinal) {
                    tiempoPasado = tiempoPasado + avance;
                    mediaPlayer.seekTo((int)tiempoPasado);
                }
                break;
            case R.id.ib_atras:
                if ((tiempoPasado - avance) > 0) {
                    tiempoPasado = tiempoPasado - avance;
                    mediaPlayer.seekTo((int)tiempoPasado);
                }
                break;
            case R.id.ib_pause:
                mediaPlayer.pause();
                break;
            case R.id.ib_play:
                mediaPlayer.start();
                tiempoPasado = mediaPlayer.getCurrentPosition();
                sbProceso.setProgress((int)tiempoPasado);
                actualizarBarra.run();
                break;
        }
    }

    private Runnable actualizarBarra = new Runnable() {
        @Override
        public void run() {
            tiempoPasado = mediaPlayer.getCurrentPosition();
            sbProceso.setProgress((int)tiempoPasado);
            double tiempoRestante = tiempoFinal - tiempoPasado;
            tvDuracion.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long)tiempoRestante),
                    TimeUnit.MILLISECONDS.toSeconds((long)tiempoRestante) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)tiempoRestante))
            ));

            controladorTiempo.postDelayed(this, 100);
        }
    };

}
// Finalizada