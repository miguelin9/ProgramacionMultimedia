package es.vcarmen.activity02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Activity02b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity02b);
        Log.v("Momento", "Estoy en onCreate1");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Momento", "Estoy en onStart2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Momento", "Estoy en onPause2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Momento", "Estoy en onResume2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Momento", "Estoy en onStop2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Momento", "Estoy en onDestroy2");
    }

    public void boton1(View view) {
        Intent intent = new Intent(this, Activity02c.class);
        startActivity(intent);
    }

    public void boton2(View view) {
        finish();
    }
}
