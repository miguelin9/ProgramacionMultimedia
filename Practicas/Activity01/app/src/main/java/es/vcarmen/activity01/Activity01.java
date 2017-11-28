package es.vcarmen.activity01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);
    }

    @Override
    public void onPause() {
        super.onPause();
        finish();
    }

    public void boton1(View view) {
        Intent intent = new Intent(this, Activity02.class);
        startActivity(intent);
    }

    public void boton3(View view) {
        Intent intent = new Intent(this, Ejercicio_01A.class);
        startActivity(intent);
    }
}
