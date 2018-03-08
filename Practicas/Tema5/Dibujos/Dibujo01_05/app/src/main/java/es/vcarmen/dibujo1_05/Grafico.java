package es.vcarmen.dibujo1_05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;

/**
 * Created by matinal on 22/02/18.
 */

public class Grafico extends View {

    public Grafico(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();

        canvas.drawColor(Color.WHITE);
        Paint pincel = new Paint();
        pincel.setColor(Color.BLACK);
        pincel.setTextSize(5);
        canvas.drawLine(ancho/2,0,ancho/2,alto,pincel);
        pincel.setTextAlign(Paint.Align.LEFT);
        pincel.setTextSize(30);
        canvas.drawText("ALINEAMIENTO IZQUIERDA",ancho/2, 50 ,pincel);
        pincel.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("ALINEAMIENTO CENTRADO",ancho/2, 100 ,pincel);
        pincel.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("ALINEAMIENTO DERECHA",ancho/2, 150 ,pincel);

        pincel.setTextAlign(Paint.Align.LEFT);
        pincel.setColor(Color.RED);
        pincel.setTextSkewX(0.2f);
        canvas.drawText("SKWE X 0.2", 10, 300, pincel);
        pincel.setTextSkewX(-0.2f);
        canvas.drawText("SKWE X -0.2", ancho/2, 300, pincel);

        pincel.setColor(Color.BLUE);
        pincel.setTextSkewX(0f);
        pincel.setTextScaleX(2f);
        canvas.drawText("ESCALA 2", 10, 400, pincel);
        pincel.setTextScaleX(-2f);
        canvas.drawText("ESCALA -2", ancho-10, 450, pincel);
        pincel.setTextScaleX(0.5f);

        canvas.drawText("ESCALA 0.5", ancho/2, 550, pincel);

        pincel.setColor(Color.BLACK);
        pincel.setTextScaleX(1.5f);
        pincel.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("SANS SERIF", 10, 500, pincel);
        pincel.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText("DEFAULT BOLD", 10, 550, pincel);
        pincel.setTypeface(Typeface.MONOSPACE);
        canvas.drawText("MONOSPACE", 10, 600, pincel);
        pincel.setTypeface(Typeface.SERIF);
        canvas.drawText("SERIF", 10, 650, pincel);

        pincel.setColor(Color.GREEN);
        pincel.setTextScaleX(1.8f);
        pincel.setTextSize(50);
        pincel.setAntiAlias(false);
        canvas.drawText("SIN ANTIALIAS", 10, 950, pincel);
        pincel.setAntiAlias(true);
        canvas.drawText("CON ANTIALIAS", 10, 1150, pincel);
    }
}
// Finalizada