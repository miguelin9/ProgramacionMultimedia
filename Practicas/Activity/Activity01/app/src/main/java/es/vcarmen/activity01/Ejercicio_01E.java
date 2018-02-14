package es.vcarmen.activity01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Ejercicio_01E extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio_01e);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    public void boton2(View view) {
        Intent intent = new Intent(this, Ejercicio_01B.class);
        startActivity(intent);
    }

    public void boton4(View view) {
        Intent intent = new Intent(this, Ejercicio_01D.class);
        startActivity(intent);
    }


}

