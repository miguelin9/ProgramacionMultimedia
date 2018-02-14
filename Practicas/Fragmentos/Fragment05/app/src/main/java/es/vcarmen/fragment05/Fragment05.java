package es.vcarmen.fragment05;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragment05 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment05);


        // boton mostrar preferencias
        Button boton = (Button) findViewById(R.id.btnMostrarPreferencias);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creando el gestor de fragmentos y el de transación
                FragmentManager FM = getFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();
                Fragmento1 preferencias = new Fragmento1();
                FT.replace(R.id.contenedor, preferencias);
                FT.commit();
            }
        });

    }
}
//Finalizada