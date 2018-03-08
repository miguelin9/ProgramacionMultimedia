package es.miguel.dibujo02;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by miguel on 8/03/18.
 */

class Grafico extends View {

    int colorrrr = 0;
    float ancho = 0f, alto = 0f;
    Paint pincel;

    AttributeSet attrs;

    public Grafico(Context context, AttributeSet attrs) {
        super(context, attrs);
        pincel = new Paint();
        pincel.setStyle(Paint.Style.FILL);
        pincel.setAntiAlias(true);
        pincel.setColor(colorrrr);

//        TypedArray colore = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0);
//        colorrrr = colore.getInteger(R.styleable.CustomView_viewColor, 0);
    }

    public int getColor() {
        invalidate();
        return colorrrr;
    }

    public void setColor(int color) {
        this.colorrrr = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(this.colorrrr == 0){
            Random rnd = new Random();
            this.colorrrr = Color.argb(255, (int) rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }
//            alto = 100;
//            ancho = 100;
        pincel.setColor(colorrrr);
        canvas.drawRect(0, 0, ancho, alto, pincel);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ancho = w;
        alto = h;
    }
}
