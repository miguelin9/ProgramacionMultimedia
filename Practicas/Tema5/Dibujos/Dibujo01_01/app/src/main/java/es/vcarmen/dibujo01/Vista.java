package es.vcarmen.dibujo01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by matinal on 16/02/18.
 */

public class Vista extends View {

    public Vista(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pincel = new Paint();
        pincel.setColor(Color.CYAN);
        canvas.drawPaint(pincel);

        pincel.setColor(Color.BLACK);
        pincel.setTextSize(30);
        pincel.setAntiAlias(true);
        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();
        canvas.drawText("ANCHO= " + ancho + ", ALTO= " + alto, 40, 40, pincel);

        pincel.setColor(Color.rgb(100, 20, 0));
        pincel.setStrokeWidth(10);
        canvas.drawLine(500, 600, 700, 600, pincel);
        canvas.drawLine(500, 700, 700, 700, pincel);
        canvas.drawLine(500, 600, 500, 1000, pincel);
        

    }
}
