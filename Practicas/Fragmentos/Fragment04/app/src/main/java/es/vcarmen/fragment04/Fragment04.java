package es.vcarmen.fragment04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Fragment04 extends AppCompatActivity {

    private Button btnMostrarDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment04);

        btnMostrarDialogo = (Button) findViewById(R.id.boton);
        btnMostrarDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragmento1 fragmentoDialogo = Fragmento1.nuevaInstancia("DIALOGO FRAGMENT");
                fragmentoDialogo.show(getSupportFragmentManager(),"diálogo");
            }
        });
    }

    public void positivo(){
        Toast.makeText(this, "OK PULSADO", Toast.LENGTH_SHORT).show();
    }

    public void negativo(){
        Toast.makeText(this, "CANCELAR PULSADO", Toast.LENGTH_SHORT).show();
    }
}

//Finalizada