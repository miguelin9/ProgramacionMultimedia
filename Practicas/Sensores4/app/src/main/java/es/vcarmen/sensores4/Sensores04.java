package es.vcarmen.sensores4;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores04 extends AppCompatActivity implements SensorEventListener {

    int contador;
    double x, y, z, a, amax;
    double campoTierraMax, campoTierraMin;
    TextView tvax, tvay, tvaz, tva, tvaMax, tvG, cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores04);

        contador = 0;
        x = 0;
        y = 0;
        z = 0;
        a = 0;
        amax = 0;
        campoTierraMax = SensorManager.MAGNETIC_FIELD_EARTH_MAX;
        campoTierraMin = SensorManager.MAGNETIC_FIELD_EARTH_MIN;
        tvax = (TextView) findViewById(R.id.tvX);
        tvay = (TextView) findViewById(R.id.tvY);
        tvaz = (TextView) findViewById(R.id.tvZ);
        tva = (TextView) findViewById(R.id.tvBmodulo);
        tvaMax = (TextView) findViewById(R.id.tvCampoMaximo);
        tvG = (TextView) findViewById(R.id.tvCampoTierra);
        cont = (TextView) findViewById(R.id.tvContador);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor  campo = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        sensorManager.registerListener(this, campo, SensorManager.SENSOR_DELAY_NORMAL);

        new MiAsyncTask().execute();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        a = Math.sqrt(x * x + y * y + z *z);
        if (a > amax){
            amax = a;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    class MiAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            while(true){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
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
            tva.setText("" + a);
            tvaMax.setText("" + amax);
            tvG.setText("" + campoTierraMin + " - " + campoTierraMax);
            cont.setText("" + contador);

        }
    }

}
//Finalizada