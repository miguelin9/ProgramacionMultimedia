package es.vcarmen.sensores7;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores07 extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    Sensor sensorLuz;
    int contador;
    double luz;
    String luminosidad;
    TextView tvLuz, tvLuminosidad, tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores07);

        contador = 0;
        luz = 0;
        luminosidad = "NORMAL";
        tvLuz = (TextView) findViewById(R.id.tvLux);
        tvLuminosidad = (TextView) findViewById(R.id.tvIluminacion);
        tvContador = (TextView) findViewById(R.id.tvLecturas);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        luz = event.values[0];
        contador++;
        if (luz < 100) luminosidad = "OSCURO";
        else if (luz < 2000) luminosidad = "LUZ NORMAL";
        else if (luz < 6000) luminosidad = "BRILLANTE";
        else luminosidad = "MUCHA LUZ";

        runOnUiThread(new CambiaTexto());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    class CambiaTexto implements Runnable{

        @Override
        public void run() {
            tvLuz.setText("" + luz);
            tvLuminosidad.setText("" + luminosidad);
            tvContador.setText("" + contador);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorLuz, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
//Finalizada