package es.miguel.imagen02;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Imagen02 extends AppCompatActivity implements View.OnClickListener{

    Button iniciar, detener;
    ImageView imagen;

    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen02);

        iniciar = (Button) findViewById(R.id.btn_iniciar);
        iniciar.setOnClickListener(this);
        detener = (Button) findViewById(R.id.btn_detener);
        detener.setOnClickListener(this);
        imagen = (ImageView) findViewById(R.id.iv_imagen);

        imagen.setVisibility(View.VISIBLE);
        imagen.setBackgroundResource(R.drawable.transicion);
        animationDrawable = (AnimationDrawable) imagen.getBackground();

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