package es.vcarmen.notificaciones01;

import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Notificaciones01 extends AppCompatActivity {

    private NotificationManager notificador;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones01);

        notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification(1,
                        android.R.drawable.stat_sys_warning,
                        "Notificación",
                        "Ejemplo de Notificación");
            }
        });
    }

    private void notification(int id, int iconId, String titulo, String contenido) {

        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(iconId)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentTitle(titulo)
                        .setContentText(contenido)
                        .setColor(getResources().getColor(R.color.colorAccent))
                        .setVibrate(new long[] {1000,1000,1000,1000,1000});

        notificador .notify(id, builder.build());

    }
}
//Finalizada (solo vibra dos veces)