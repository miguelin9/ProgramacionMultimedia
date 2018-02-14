package es.vcarmen.activity02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Activity02d extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity02d);
        Log.v("Momento", "Estoy en onCreate4");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Momento", "Estoy en onStart4");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Momento", "Estoy en onPause4");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Momento", "Estoy en onResume4");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Momento", "Estoy en onStop4");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Momento", "Estoy en onDestroy4");
    }

    public void boton1(View view){
        Intent intent = new Intent(this, Activity02a.class);
        startActivity(intent);
    }

    public void boton2(View view) {
        finish();
    }
}
