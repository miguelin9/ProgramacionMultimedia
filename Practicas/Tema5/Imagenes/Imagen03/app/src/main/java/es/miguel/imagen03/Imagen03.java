package es.miguel.imagen03;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Imagen03 extends AppCompatActivity implements View.OnClickListener {

    Button iniciar, detener;
    ImageView imagen;

    Resources resources;
    Drawable imagen1, imagen2, imagen3, imagen4, imagen5, imagen6, imagen7;

    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen03);

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_iniciar:
                animationDrawable.start();
                break;
            case R.id.btn_detener:
                animationDrawable.stop();
                break;
        }
    }
}
// Finalizada