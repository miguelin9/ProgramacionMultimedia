package es.vcarmen.audio01;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Audio01 extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    Button btn_laser, btn_bomba, btn_disparo, btn_maullido;
    SeekBar sb_volumen, sb_balance, sb_frecuencia;
    GestorSonido snd;
    int laser, explosion, disparo, gato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio01);

        snd = new GestorSonido(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        laser = snd.carga(R.raw.laser);
        explosion = snd.carga(R.raw.explosion);
        disparo = snd.carga(R.raw.disparo);
        gato = snd.carga(R.raw.gato);

        sb_volumen = (SeekBar) findViewById(R.id.sb_volumen);
        sb_balance = (SeekBar) findViewById(R.id.sb_balance);
        sb_frecuencia = (SeekBar) findViewById(R.id.sb_frecuencia);
        sb_volumen.setOnSeekBarChangeListener(this);
        sb_balance.setOnSeekBarChangeListener(this);
        sb_frecuencia.setOnSeekBarChangeListener(this);
        btn_laser = (Button) findViewById(R.id.btn_laser);
        btn_bomba = (Button) findViewById(R.id.btn_bomba);
        btn_disparo = (Button) findViewById(R.id.btn_disparo);
        btn_maullido = (Button) findViewById(R.id.btn_maullido);
        btn_laser.setOnClickListener(this);
        btn_bomba.setOnClickListener(this);
        btn_disparo.setOnClickListener(this);
        btn_maullido.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_laser:
                snd.suena(laser);
                break;
            case R.id.btn_bomba:
                snd.suena(explosion);
                break;
            case R.id.btn_disparo:
                snd.suena(disparo);
                break;
            case R.id.btn_maullido:
                snd.suena(gato);
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_volumen:
                snd.ajustaVolumen((float) progress/100.0f);
                break;
            case R.id.sb_balance:
                snd.ajustaBalance((float) progress/100.0f);
                break;
            case R.id.sb_frecuencia:
                snd.ajustarFrecuencia((float) progress/100.0f);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
// Finalizada