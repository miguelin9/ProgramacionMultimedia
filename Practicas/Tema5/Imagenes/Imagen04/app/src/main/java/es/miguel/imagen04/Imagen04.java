package es.miguel.imagen04;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Imagen04 extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    Button iniciar, detener;
    ImageView imagen;

    Resources resources;
    Drawable imagen1, imagen2, imagen3, imagen4, imagen5, imagen6, imagen7;

    AnimationDrawable animationDrawable;

    int ancho1, ancho2, ancho3, alto1, alto2, alto3;
    float ratio1, ratio3, padding3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen04);

        texto = (TextView) findViewById(R.id.tv_titulo);
        iniciar = (Button) findViewById(R.id.btn_iniciar);
        iniciar.setOnClickListener(this);
        detener = (Button) findViewById(R.id.btn_detener);
        detener.setOnClickListener(this);
        imagen = (ImageView) findViewById(R.id.iv_imagen);

        resources = getResources();
        imagen1 = resources.getDrawable(R.drawable.boccaccino);
        imagen2 = resources.getDrawable(R.drawable.boticelli);
        imagen3 = resources.getDrawable(R.drawable.durero);
        imagen4 = resources.getDrawable(R.drawable.leonardo);
        imagen5 = resources.getDrawable(R.drawable.miguelangel);
        imagen6 = resources.getDrawable(R.drawable.rafael);
        imagen7 = resources.getDrawable(R.drawable.tintoreto);

        imagen.setVisibility(View.VISIBLE);
        imagen.setBackgroundResource(R.drawable.transicion);
        animationDrawable = (AnimationDrawable) imagen.getBackground();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(imagen1, 2000);
        animationDrawable.addFrame(imagen2, 2000);
        animationDrawable.addFrame(imagen3, 2000);
        animationDrawable.addFrame(imagen4, 2000);
        animationDrawable.addFrame(imagen5, 2000);
        animationDrawable.addFrame(imagen6, 2000);
        animationDrawable.addFrame(imagen7, 2000);
        imagen.setBackgroundDrawable(animationDrawable);

        ancho1 = imagen.getBackground().getIntrinsicWidth();
        alto1 = imagen.getBackground().getIntrinsicHeight();
        ratio1 = alto1/ancho1;
        texto.append("\nAncho: " + ancho1);
        texto.append(" Alto: " + alto1);
        texto.append(" Ratio: " + ratio1);

        ancho2 = imagen.getMeasuredWidth();
        alto2 = imagen.getMeasuredHeight();
        texto.append("\nImagen ");
        texto.append(" Ancho: " + ancho2);
        texto.append(" Alto: " + alto2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_iniciar:
                animationDrawable.start();

                ancho3 = imagen.getMeasuredWidth();
                alto3 = imagen.getMeasuredHeight();
                ratio3 = alto3/ancho3;
                padding3 = (alto3-ratio3)/2;
                texto.append("\nNuevo ");
                texto.append(" Alto: " + alto3);
                texto.append(" Padding: " + padding3);
                break;
            case R.id.btn_detener:
                animationDrawable.stop();
                break;
        }
    }
}
// Finalizada