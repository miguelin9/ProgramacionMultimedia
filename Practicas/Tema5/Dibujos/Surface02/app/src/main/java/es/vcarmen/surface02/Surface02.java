package es.vcarmen.surface02;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Surface02 extends AppCompatActivity {

    RelativeLayout rl;
    SurfaceView sv;
    TextView texto;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface02);

        rl = (RelativeLayout) findViewById(R.id.contenedor);
        sv = new SurfaceView(this);
        rl.addView(sv);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 40;
        sv.setLayoutParams(params);
        sv.setBackgroundColor(Color.argb(255,30,144,255));

        texto = new TextView(this);
        texto.setTextColor(Color.WHITE);
        texto.setTypeface(Typeface.DEFAULT_BOLD);
        texto.setTextSize(18);
        texto.setText("CREADO EN JAVA");
        rl.addView(texto);

        boton = new Button(this);
        boton.setText("PULSA PARA MENSAJE");
        rl.addView(boton);

        RelativeLayout.LayoutParams paramsTexto = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsTexto.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = -100;
        texto.setLayoutParams(paramsTexto);

        RelativeLayout.LayoutParams paramsBoton = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT, (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        paramsBoton.addRule(RelativeLayout.CENTER_IN_PARENT);
        boton.setLayoutParams(paramsBoton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pulsado", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
// Finalizado