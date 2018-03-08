package es.vcarmen.dibujo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Dibujo01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Vista grafico = new Vista(this);
        setContentView(grafico);

    }
}
// Finalizada