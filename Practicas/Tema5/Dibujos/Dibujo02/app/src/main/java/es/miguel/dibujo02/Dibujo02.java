package es.miguel.dibujo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Dibujo02 extends AppCompatActivity {

//    Grafico vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        vista = new Grafico(this);
//        vista.setColor(0xFF00aaaa);
        setContentView(R.layout.activity_dibujo02);
    }


}
// Finalizada pero no mandamos el color desde el layout.xml