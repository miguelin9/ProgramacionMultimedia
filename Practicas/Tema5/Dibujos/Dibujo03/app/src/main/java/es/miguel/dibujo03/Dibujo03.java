package es.miguel.dibujo03;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dibujo03 extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    Sensor sensor;
    Grafico vista;

    @Override
    public void onSensorChanged(SensorEvent event) {
        vista.onSensorEvent(event);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }



    private class Grafico extends View {

        private Paint pincel;
        private int x = 25, y = 25;
        private static final int radio = 25;
        private int ancho, alto;

        public Grafico(Context context) {
            super(context);
            pincel = new Paint();
            pincel.setColor(Color.BLUE);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            ancho = w;
            alto = h;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawCircle(x, y, radio, pincel);
            invalidate();
        }
        public void onSensorEvent (SensorEvent event) {
            x = x - (int) event.values[0];
            y = y + (int) event.values[1];
            if (x <= 0 + radio) {x = 0 + radio;}
            if (y <= 0 + radio) {y = 0 + radio;}
            if (x >=  1080 - radio) {x = 1080 - radio;}
            if (y >= 1680 - radio) {y = 1680 - radio;}
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vista = new Grafico(this);
        setContentView(vista);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }
}
// Finalizada