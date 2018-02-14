package es.vcarmen.fragment09;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Miguel on 27/11/2017.
 */

public class Fragmento3 extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento3, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int tipoLista = (int) (Math.random()*3);
        switch (tipoLista){
            case 0:
                setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Contenido.pintores));
                break;
            case 1:
                setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Contenido.arquitectos));
                break;
            case 2:
                setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Contenido.escultores));
                break;
            default:
                break;
        }

    }
}
