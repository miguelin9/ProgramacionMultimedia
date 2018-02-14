package es.vcarmen.examenclaseenero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by matinal on 19/01/18.
 */

public class ActividadDos extends AppCompatActivity {

    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_dos);

        resultado = (TextView) findViewById(R.id.tvActividadDos);

    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("RETORNO", "Esto es un string de retorno desde el finish de ActividadDos");
        setResult(RESULT_OK, data);
        super.finish();
    }
}
