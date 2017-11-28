package es.vcarmen.fragment09;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class Fragment09 extends FragmentActivity {

    Adaptador paginador;
    ViewPager visor;
    ArrayList<Fragment> listaFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment09);

        listaFragmentos = new ArrayList<Fragment>();
        //Añade fragmentos a la lista
        listaFragmentos.add(new Fragmento3());
        listaFragmentos.add(new Fragmento1());
        listaFragmentos.add(new Fragmento3());
        listaFragmentos.add(new Fragmento2());
        listaFragmentos.add(new Fragmento3());
        //Añadimos al paginador un adaptador con la lista de fragmentos
        paginador = new Adaptador(getSupportFragmentManager(),listaFragmentos);
        //Enlazaremos el visor con el ViewPager del layout principal
        visor = (ViewPager) findViewById(R.id.viewPager);
        //Seteamos el paginador como adaptador del visor
        visor.setAdapter(paginador);

    }
}
//Finalizada