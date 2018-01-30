package es.vcarmen.sensores01;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Sensores01 extends AppCompatActivity {

    TextView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores01);

        listado = (TextView) findViewById(R.id.listado);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : listaSensores){
            listado.append("Nombre:" + sensor.getName() + "\n");
            listado.append("Tipo:" + sensor.getStringType() + "\n");
            listado.append("\n");
        }

    }
}
//Finalizada