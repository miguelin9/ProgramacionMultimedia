package es.vcarmen.sensores02;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores02 extends AppCompatActivity implements SensorEventListener{

    int contador;
    double x = 0, y = 0, z = 0, a = 0, amax = 0;
    double gravedad = SensorManager.STANDARD_GRAVITY;
    TextView tvax, tvay, tvaz, tva, tvaMax, tvG, tvC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores02);

        tvax = (TextView) findViewById(R.id.tvax);
        tvay = (TextView) findViewById(R.id.tvay);
        tvaz = (TextView) findViewById(R.id.tvaz);
        tva = (TextView) findViewById(R.id.tva);
        tvaMax = (TextView) findViewById(R.id.tvaMax);
        tvG = (TextView) findViewById(R.id.tvG);
        tvC = (TextView) findViewById(R.id.tvC);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, acelerometro,SensorManager.SENSOR_DELAY_FASTEST);

        new MiAsyncTask().execute();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        a = Math.sqrt(x*x + y*y + z*z);
        if (a > amax){
            amax = a;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    class MiAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... arg0) {
            while(true){
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                contador++;
                publishProgress();
            }
        }

        @Override
        protected void onProgressUpdate(Void... progress) {
            super.onProgressUpdate(progress);

            tvax.setText("" + x);
            tvay.setText("" + y);
            tvaz.setText("" + z);
            tva.setText("" + a);
            tvaMax.setText("" + amax);
            tvG.setText("" + gravedad);
            tvC.setText("" + contador);

        }
    }

}
//Finalizada