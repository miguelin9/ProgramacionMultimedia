package es.vcarmen.fragment10;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Fragment10 extends FragmentActivity implements Fragmento1.Callbacks {

    private boolean dosFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment10);

        // buscamos si existe frame layout de layout large si es asi estamos en tablet y pondremos el boolean a true
        if (findViewById(R.id.frame_contenedor)!=null){
            dosFragmentos = true;
        }
    }

    @Override
    public void onEntradaSeleccionada(String id) {
        Toast.makeText(getBaseContext(), "TOCADO EL " + id, Toast.LENGTH_SHORT).show();

        if (dosFragmentos){
            Bundle arguments = new Bundle();
            arguments.putString(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
            Fragmento3 fragment = new Fragmento3();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_contenedor, fragment).commit();
        }else {
            Intent detalleIntent = new Intent(this, Fragmento2.class);
            detalleIntent.putExtra(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
            startActivity(detalleIntent);
        }

    }
}
