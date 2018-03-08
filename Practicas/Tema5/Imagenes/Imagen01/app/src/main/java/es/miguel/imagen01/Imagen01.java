package es.miguel.imagen01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class Imagen01 extends AppCompatActivity {

    TextView texto1, texto2, texto3, texto4, texto5;

    Display pantalla;
    int ancho, alto, dpi;
    float densidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen01);

        texto1 = (TextView) findViewById(R.id.tv1);
        texto2 = (TextView) findViewById(R.id.tv2);
        texto3 = (TextView) findViewById(R.id.tv3);
        texto4 = (TextView) findViewById(R.id.tv4);
        texto5 = (TextView) findViewById(R.id.tv5);

        pantalla = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        ancho = pantalla.getWidth();
        alto = pantalla.getHeight();
        texto1.setText("Ancho: " + ancho);
        texto2.setText("Alto: " + alto);

        dpi = getResources().getDisplayMetrics().densityDpi;
        texto3.setText("Densidad(dpi): " + dpi);

        densidad = getResources().getDisplayMetrics().density;
        texto4.setText("Escala: " + densidad);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        switch (metrics.densityDpi) {
            case DisplayMetrics.DENSITY_XXHIGH:
                texto5.setText("Extra alta densidad");
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                texto5.setText("Muy alta densidad");
                break;
            case DisplayMetrics.DENSITY_HIGH:
                texto5.setText("Alta densidad");
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                texto5.setText("Media densidad");
                break;
            case DisplayMetrics.DENSITY_LOW:
                texto5.setText("Baja densidad");
                break;
        }


    }
}
// Finalizada