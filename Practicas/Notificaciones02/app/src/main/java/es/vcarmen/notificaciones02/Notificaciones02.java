package es.vcarmen.notificaciones02;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Notificaciones02 extends AppCompatActivity {

    private NotificationManager notificador;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones02);

        notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification(1,
                        android.R.drawable.stat_sys_warning,
                        "NOTIFICACIÓN",
                        "PULSA LA NOTIFICACIÓN");
            }
        });

    }

    public void notification(int i, int iconId, String titulo, String contenido){

        //Constructor de la notificación.
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(iconId)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentTitle(titulo)
                .setContentText(contenido)
                .setColor(getResources().getColor(R.color.colorAccent));

        // Se crea intent y enlaza con actividad.class
        Intent intent = new Intent(this, Toast01.class);

        // Se crea la pila
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Se añade actividad padre
        stackBuilder.addParentStack(Toast01.class);

        // Se referencia el itent para notificaciones
        stackBuilder.addNextIntent(intent);

        // Se obtiene el pendiente intent de la pila
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // Asignación del pending intent  a la notificación
        builder.setContentIntent(resultPendingIntent);

        // Se auto elimina la notificación
        builder.setAutoCancel(true);

        // Se construye y lanza la aplicación
        notificador.notify(i, builder.build());

    }

}
//Finalizada