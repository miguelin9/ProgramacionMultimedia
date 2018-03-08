package es.miguel.dibujo04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Dibujo04 extends AppCompatActivity {

    private class Grafico extends View {

        private float x = 50, y = 50;
        private String dedo = "posicion";
        Paint pincel;

        Path path;

        public Grafico(Context context) {
            super(context);

            pincel = new Paint();
            pincel.setColor(Color.RED);
            pincel.setStyle(Paint.Style.STROKE);
            pincel.setStrokeWidth(5);
            pincel.setAntiAlias(true);

            path = new Path();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawCircle(x, y, 5, pincel);

            if (dedo == "abajo") {path.moveTo(x, y);}
            if (dedo == "movido") {path.lineTo(x, y);}
            canvas.drawPath(path, pincel);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX();
            y = event.getY();

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                dedo = "abajo";
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                dedo = "movido";
            }

            invalidate();
            return true;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Grafico(this));
    }
}
// Finalizada