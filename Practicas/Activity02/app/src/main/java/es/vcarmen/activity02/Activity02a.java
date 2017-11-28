package es.vcarmen.activity02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class Activity02a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity02a);
        Log.v("Momento", "Estoy en onCreate1");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Momento", "Estoy en onStart1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Momento", "Estoy en onPause1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Momento", "Estoy en onResume1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Momento", "Estoy en onStop1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Momento", "Estoy en onDestroy1");
    }

    public void boton1(View view){
        Intent intent = new Intent(this,Activity02b.class);
        startActivity(intent);
    }

    public void boton2(View view) {
        finish();
    }
}
