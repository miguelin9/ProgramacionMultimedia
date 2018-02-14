package es.vcarmen.activity01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Ejercicio_01B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio_01b);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    public void boton5(View view) {
        Intent intent = new Intent(this, Ejercicio_01E.class);
        startActivity(intent);
    }

    public void boton6(View view) {
        Intent intent = new Intent(this, Ejercicio_01F.class);
        startActivity(intent);
    }


}

