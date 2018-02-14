package es.vcarmen.sonido03;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by matinal on 31/01/18.
 */

public class Servicio extends Service {

    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        player = MediaPlayer.create(this, R.raw.codigo_davinci);
        player.setLooping(true);// cada vez que termina la canción vuelve a empezar si es true
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Toast.makeText(this, "Servicio parado", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        player.start();
        Toast.makeText(this, "Servicio creado", Toast.LENGTH_SHORT).show();
    }

}
