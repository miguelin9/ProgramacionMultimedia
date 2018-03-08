package es.vcarmen.imagen05;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Imagen05 extends AppCompatActivity implements View.OnClickListener {

    private TextView subtitulo;
    private Button boton, botonVolver;
    private ImageView imagenView;

    private static int escala = 350;
    private Bitmap imagen, bm;
    private float factorEscala;

    private long tiempoInicio, tiempoFinal, tiempoTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen05);

        subtitulo = (TextView) findViewById(R.id.tv_tiempo_procesado);
        imagenView = (ImageView) findViewById(R.id.iv_imagen);
        boton = (Button) findViewById(R.id.btn_boton);
        boton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_boton:
                tiempoInicio = System.currentTimeMillis();

                // Obtener la imagen
                imagen = BitmapFactory.decodeResource(getResources(), R.drawable.leonardo);

                // Creamos un float con el valor resultante de dividir la escala por el alto de la imagen
                factorEscala = escala / (float) imagen.getHeight();

                int imageWidth = (int) ((Integer) imagen.getWidth() * factorEscala);
                int imageHeigth = (int) ((Integer) imagen.getHeight() * factorEscala);

                bm = Bitmap.createScaledBitmap(imagen, imageWidth, imageHeigth, false);

                imagenView.setImageBitmap(bm);

                Matrix matrix = new Matrix();
                matrix.postRotate(90);
                Bitmap bitmap = Bitmap.createBitmap(bm, 0, 0, imageWidth, imageHeigth, matrix, true);
                imagenView.setImageBitmap(bitmap);

                tiempoFinal = System.currentTimeMillis();

                tiempoTotal = tiempoInicio - tiempoFinal;

                subtitulo.setText("PROCESADO " + String.valueOf(Math.abs(tiempoTotal)) + " (MILISEGUNDOS)");
                break;
        }
    }
}
// Finalizada