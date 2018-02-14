package es.vcarmen.examenclaseenero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by matinal on 19/01/18.
 */

public class Resultado extends AppCompatActivity {

    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        resultado = (TextView) findViewById(R.id.tvResultado);
        
        Intent intent = getIntent();
        resultado.setText(intent.getStringExtra("nombre"));
        int year = intent.getIntExtra("year", 0000);
        resultado.append("\n" + String.valueOf(year));
        resultado.append("\n" + intent.getStringExtra("jaen"));
        resultado.append("\n" + intent.getStringExtra("cadiz"));
        resultado.append("\n" + intent.getStringExtra("almeria"));

    }
}
