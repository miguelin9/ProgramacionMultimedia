package es.vcarmen.sonido03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sonido03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido03);
    }

    void click(View view) {
        switch (view.getId()) {
            case R.id.bt_start:
                startService(new Intent(this, Servicio.class));
                break;
            case R.id.bt_stop:
                stopService(new Intent(this, Servicio.class));;
                break;
        }
    }

}
// Finalizada