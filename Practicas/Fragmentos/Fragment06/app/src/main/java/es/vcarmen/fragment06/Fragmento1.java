package es.vcarmen.fragment06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;


/**
 * Created by Miguel on 25/10/2017.
 */

public class Fragmento1 extends WebViewFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // creamos la vista
        View view = super.onCreateView(inflater, container, savedInstanceState);
        // Creamos el navegador
        WebView navegador = getWebView();
        // haremos al navegador cliente y le permitiremos interactuar
        navegador.setWebViewClient(new WebViewClient());
        // adjuntamos la URL a la que queremos navegar
        navegador.loadUrl("http://www.iesvirgendelcarmen.com");
        // adjuntamos algunos parametros al navegador como que acepte javascript y hacer zoom
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.getSettings().setBuiltInZoomControls(true);

        //para poder navegar hay que dar permiso en el manifest
        // y para terminar devolvemos la vista
        return view;
    }
}
