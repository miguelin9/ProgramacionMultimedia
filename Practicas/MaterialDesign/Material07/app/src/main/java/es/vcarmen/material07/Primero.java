package es.vcarmen.material07;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * Created by matinal on 17/11/17.
 */

public class Primero extends Fragment {

    public Primero() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.primero, container, false);
        WebView navegador = vista.findViewById(R.id.wvPrimero);
        navegador.loadUrl("http://www.google.es");
        navegador.setWebViewClient(new WebViewClient());

        return vista;
    }

}
