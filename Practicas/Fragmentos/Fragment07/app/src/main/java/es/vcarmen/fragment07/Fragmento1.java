package es.vcarmen.fragment07;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Miguel on 25/10/2017.
 */

public class Fragmento1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento1, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btn1 = (Button) getActivity().findViewById(R.id.importarTexto1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.texto3);
                Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        Button btn2 = (Button) getActivity().findViewById(R.id.exportarTexto1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView texto = (TextView) getActivity().findViewById(R.id.texto4);
                texto.setText("TOCADO FRAG1");
            }
        });
    }
}
