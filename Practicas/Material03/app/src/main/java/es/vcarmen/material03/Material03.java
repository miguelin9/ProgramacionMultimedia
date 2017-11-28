package es.vcarmen.material03;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

public class Material03 extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab1, fab2, fab3;
    Animation abrir, cerrar, derecha, izquierda;
    boolean abierto = false;

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab3:
                if (abierto){
                    fab1.startAnimation(cerrar);
                    fab2.startAnimation(cerrar);
                    fab3.startAnimation(izquierda);
                    fab2.setClickable(false);
                    fab1.setClickable(false);
                    abierto = false;
                }else{
                    fab1.startAnimation(abrir);
                    fab2.startAnimation(abrir);
                    fab3.startAnimation(derecha);
                    fab2.setClickable(true);
                    fab1.setClickable(true);
                    abierto = true;
                }
                break;
            case R.id.fab2:
                Toast.makeText(getApplicationContext(), "HAS PULSADO FAB2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab1:
                Toast.makeText(getApplicationContext(), "HAS PULSADO FAB1", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
}
// Falta parte 6 practicando lo aprendido