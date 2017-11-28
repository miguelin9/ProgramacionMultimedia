package es.vcarmen.fragment08;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by matinal on 25/10/17.
 */

public class Cabecera extends ListFragment {

    CabeceraListener mCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Elementos.cabeceras));

    }

    public interface CabeceraListener {

        public void tocado(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mCallback = (CabeceraListener) context;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        mCallback.tocado(position);
    }
}


