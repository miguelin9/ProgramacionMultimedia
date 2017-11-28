package es.vcarmen.fragment06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragment06 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment06);

        // boton mostrar navegador
        Button boton = (Button) findViewById(R.id.bMostrar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creamos la transacción para el fragmento
                android.app.FragmentManager FM = getFragmentManager();
                android.app.FragmentTransaction FT = FM.beginTransaction();
                // creamos el fragmento
                Fragmento1 fragmento = new Fragmento1();
                FT.replace(R.id.fragmento1, fragmento);
                FT.commit();
            }
        });
    }
}
//Finalizada