package es.vcarmen.material11;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by matinal on 14/12/17.
 */

public class Fragmentos extends Fragment {

    public static final String ARG_SECTION_TITLE = "opcion";
    // para gestionar los argumentos crearemos una instancia interna
    public static Fragmentos newInstance(String sectionTitle){
        Fragmentos fragmento = new Fragmentos();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TITLE, sectionTitle);
        fragmento.setArguments(args);

        return fragmento;
    }

    public Fragmentos() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmentos,container,false);
        String title = getArguments().getString(ARG_SECTION_TITLE);
        TextView titulo = (TextView) view.findViewById(R.id.tituloFrag);
        titulo.setText(title);

        return view;
    }
}
