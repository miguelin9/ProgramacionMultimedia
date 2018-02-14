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

public class Segundo extends Fragment {

    public Segundo() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.segundo, container, false);
        WebView navegador = vista.findViewById(R.id.wvSegundo);
        navegador.loadUrl("https://www.youtube.com/");
        navegador.setWebViewClient(new WebViewClient());
        navegador.getSettings().setJavaScriptEnabled(true);

        return vista;
    }

}
