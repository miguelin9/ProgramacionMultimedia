package es.vcarmen.sensores3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores03 extends AppCompatActivity implements SensorEventListener {

    int contador;
    double x, y, z;
    TextView tvax, tvay, tvaz, cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores03);

        contador = 0;
        x = 0.0d;
        y = 0.0d;
        z = 0.0d;
        tvax = (TextView) findViewById(R.id.tvEjeX);
        tvay = (TextView) findViewById(R.id.tvEjeY);
        tvaz = (TextView) findViewById(R.id.tvEjeZ);
        cont = (TextView) findViewById(R.id.tvContador);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_FASTEST);

        new MiAsyncTask().execute();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    class MiAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                contador++;
                publishProgress();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

            tvax.setText("" + x);
            tvay.setText("" + y);
            tvaz.setText("" + z);
            cont.setText("" + contador);
        }

    }

}
//Finalizada