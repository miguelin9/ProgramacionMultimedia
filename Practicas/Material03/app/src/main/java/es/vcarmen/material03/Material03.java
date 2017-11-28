package es.vcarmen.material03;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class Material03 extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab1, fab2, fab3;
    Animation abrir, cerrar, derecha, izquierda;
    boolean abierto = false;
    FloatingActionButton fab4, fab5, fab6, fab7;
    boolean bandera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material02);

        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        abrir = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abrir);
        cerrar = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.cerrar);
        derecha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.derecha);
        izquierda = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.izquierda);

        // seteamos el escuchador que implementa esta clase a los fab
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);

        // apliando lo aprendido
        fab4 = (FloatingActionButton) findViewById(R.id.fab4);
        fab5 = (FloatingActionButton) findViewById(R.id.fab5);
        fab6 = (FloatingActionButton) findViewById(R.id.fab6);
        fab7 = (FloatingActionButton) findViewById(R.id.fab7);
        fab4.setOnClickListener(this);
        fab5.setOnClickListener(this);
        fab6.setOnClickListener(this);
        fab7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab3:
                if (abierto){
                    fab1.startAnimation(cerrar);
                    fab2.startAnimation(cerrar);
                    fab4.startAnimation(cerrar);
                    fab3.startAnimation(izquierda);
                    fab2.setClickable(false);
                    fab1.setClickable(false);
                    fab4.setClickable(false);
                    abierto = false;
                }else{
                    fab1.startAnimation(abrir);
                    fab2.startAnimation(abrir);
                    fab4.startAnimation(abrir);
                    fab3.startAnimation(derecha);
                    fab2.setClickable(true);
                    fab1.setClickable(true);
                    fab4.setClickable(true);
                    abierto = true;
                }
                break;
            case R.id.fab2:
                Toast.makeText(getApplicationContext(), "HAS PULSADO FAB2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab1:
                Toast.makeText(getApplicationContext(), "HAS PULSADO FAB1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab4:
                if (bandera){
                    fab5.startAnimation(cerrar);
                    fab6.startAnimation(cerrar);
                    fab7.startAnimation(cerrar);
                    fab4.startAnimation(izquierda);
                    fab5.setClickable(false);
                    fab6.setClickable(false);
                    fab7.setClickable(false);
                    bandera = false;
                }else{
                    fab5.startAnimation(abrir);
                    fab6.startAnimation(abrir);
                    fab7.startAnimation(abrir);
                    fab4.startAnimation(derecha);
                    fab5.setClickable(true);
                    fab6.setClickable(true);
                    fab7.setClickable(true);
                    bandera = true;
                }
                break;
            case R.id.fab5:
                Toast.makeText(getApplicationContext(), "HAS PULSADO FAB5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab6:
                Toast.makeText(getApplicationContext(), "HAS PULSADO FAB6", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab7:
                Toast.makeText(getApplicationContext(), "HAS PULSADO FAB7", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
}
// Finalizado