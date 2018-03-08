package es.vcarmen.surface03;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by miguel on 8/03/18.
 */

public class Vista extends View {

    private Bitmap bitmap;

    public Vista(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mirilla);
        int anc_ima = bitmap.getWidth();
        int alt_ima = bitmap.getHeight();
        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();
        int pini = (ancho - anc_ima) / 2;
        int pins = (alto - alt_ima) / 2;
        canvas.drawBitmap(bitmap, pini, pins, null);
    }
}
