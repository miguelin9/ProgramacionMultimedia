package es.vcarmen.audio01;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by matinal on 26/01/18.
 */

public class GestorSonido {

    private SoundPool sndPool;
    private Context context;
    private float rate = 1.0f;
    private float balance = 0.5f, volumen = 0.5f;
    private float derecho = 1.0f, izquierdo = 1.0f;

    public GestorSonido(Context appContext) {
        this.sndPool = new SoundPool(16, AudioManager.STREAM_MUSIC, 100);
        this.context = appContext;
    }

    public int carga(int sound_id) {
        return sndPool.load(context, sound_id, 1);
    }

    public void suena(int sound_id) {
        sndPool.play(sound_id, izquierdo, derecho, 1, 0, rate);
    }

    public void ajustarFrecuencia(float speed) {
        this.rate = speed;
        if (rate < 0.01f) this.rate = 0.01f;
        if (rate > 2.0f) this.rate = 2.0f;
    }

    public void ajustaBalance(float balVal) {
        this.balance = balVal;
        ajustaVolumen(volumen);
    }

    public void ajustaVolumen(float vol) {
        this.volumen = vol;
        if (balance < 1.0f) {
            izquierdo = volumen;
            derecho = volumen * balance;
        } else {
            derecho = volumen;
            izquierdo = volumen * (2.0f - balance);
        }
    }

    public void unloadAll() {
        sndPool.release();
    }

}
