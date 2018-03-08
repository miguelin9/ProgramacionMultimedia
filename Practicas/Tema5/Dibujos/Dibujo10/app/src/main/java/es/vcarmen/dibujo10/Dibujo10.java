package es.vcarmen.dibujo10;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dibujo10 extends AppCompatActivity {

    boolean continuar = true;
    float velocidad = 0.5f;
    float aceleracion = 0.01f;
    float energia;
    int dt = 1;
    int tiempo = 0;
    Thread hilo = null;
    GraficoView dinamica;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dinamica = new GraficoView(this);
        setContentView(dinamica);
        hilo = new Thread(dinamica);
        hilo.start();
    }

    class GraficoView extends View implements Runnable {
        int x, y, ymax;
        Paint paintFondo, paintParticula, paint;

        public GraficoView(Context context) {
            super(context);
            paintFondo = new Paint();
            paintParticula = new Paint();
            paint = new Paint();
            paintFondo.setColor(Color.WHITE);
            paintParticula.setColor(Color.RED);
            paint.setColor(Color.BLACK);
            paint.setTextSize(30);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            x = w / 2;
            y = 0;
            ymax = h;
            energia = 0.5f * velocidad * velocidad - aceleracion * y;
        }

        @Override
        public void run() {
            while (continuar) {
                cambiaPosicion();
                postInvalidate();
                try {
                    Thread.sleep(dt);
                } catch (InterruptedException e) {
                    ;
                }
            }
        }

        public void cambiaPosicion() {
            tiempo = tiempo + dt;
            velocidad = velocidad + aceleracion * dt;
            float cinetica = velocidad * velocidad / 2;
            y = (int) ((cinetica - energia) / aceleracion);
            if (y > ymax) velocidad = -Math.abs(velocidad);
            if (y < 0) velocidad = Math.abs(velocidad);
        }

        public void cambiaPosicion2() {
            tiempo = tiempo + dt;
            y = y + (int) (velocidad * dt);
            velocidad = velocidad + aceleracion * dt;
            if (y > ymax) velocidad = -velocidad;
            if (y < 0) velocidad = -velocidad;
        }

        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawPaint(paintFondo);
            canvas.drawCircle(x + 150, y, 30, paintParticula);
            canvas.drawText("ALTURA=" + y, 50, 50, paint);
            canvas.drawText("TIEMPO=" + tiempo, 50, 90, paint);
            canvas.drawText("VELOCI=" + velocidad, 50, 130, paint);
        }
    }
}
// Finalizada