package es.vcarmen.fragment10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by matinal on 26/10/17.
 */

public class Fragmento3 extends Fragment {

    public static final String ARG_ID_ENTRADA_SELECCIONADA = "item_id";
    private Contenido.Lista_entrada miItem;

    public Fragmento3() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ID_ENTRADA_SELECCIONADA)) {
            miItem = Contenido.ENT_LISTA_HASHMAP.get(getArguments().getString(ARG_ID_ENTRADA_SELECCIONADA));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout_detalle, container, false);
        if (miItem != null) {
            ((TextView) rootView.findViewById(R.id.textotitulo)).setText(miItem.textoEncima);
            //((TextView) rootView.findViewById(R.id.textocontenido)).setText(miItem.textoDebajo);
            ((ImageView) rootView.findViewById(R.id.imagen)).setImageResource(miItem.idImagen);

            // cogemos el webView
            WebView navegador = (WebView) rootView.findViewById(R.id.internet);
            // adjuntamos la URL a la que queremos navegar
            navegador.loadUrl(miItem.url);
            // Enable javascript
            WebSettings webSettings = navegador.getSettings();
            webSettings.setJavaScriptEnabled(true);
            //Con esta linea añadimos un cliente y asi no se abre en una pantalla nueva aparte.
            navegador.setWebViewClient(new WebViewClient());
        }

        return rootView;
    }
}
