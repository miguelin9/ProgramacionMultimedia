package es.vcarmen.fragment02;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Fragment02 extends AppCompatActivity {

    private boolean cambio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment02);

        //creando los dos fragmentos
        final Fragmento1 fragmento1 = new Fragmento1();
        final Fragmento2 fragmento2 = new Fragmento2();

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        //para este caso necesitamos el gestor de ventanas para saber si esta en vertical o horinzontal
        WindowManager WM = getWindowManager();
        //asignamos la pantalla por defecto
        Display DP = WM.getDefaultDisplay();
        //ahora la condición
        if (DP.getRotation()== Surface.ROTATION_90){
            FT.replace(android.R.id.content,fragmento1).commit();
        }else{
            FT.replace(android.R.id.content,fragmento2).commit();
        }



        /*
        Parte 2 de la practica
        //asociando el boton
        Button boton = (Button) findViewById(R.id.boton);
        //creamos un listener para el boton y una variable booleana para controlar (linea 12)
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
                if (cambio){
                    FT.replace(R.id.contenedor,fragmento1);
                }else{
                    FT.replace(R.id.contenedor,fragmento2);
                }
                FT.addToBackStack(null); //para que al pulsar atras vaya al estado anterior y no cierre la app
                FT.commit();
                cambio = !cambio;
            }
        });
        */
    }

/*
Parte 1 de la practica
pasamos este metodo al escuchador de más arriba en el evento onClick
    public void boton1(View view) {
        //ahora crearemos el fragmentmanager que da soporte al fragmento
        FragmentManager FM = getSupportFragmentManager();
        //Crearemos el gestor de transacciones e iniciamos la transacción
        FragmentTransaction FT = FM.beginTransaction();
        //Crearemos un fragmento heredado de fragmento1
        Fragmento1 fragment = new Fragmento1();
        //Lo añadimos al contenedor del XML y ejecutamos la transaccion
        FT.add(R.id.contenedor, fragment);
        FT.commit();
    }
*/



}
