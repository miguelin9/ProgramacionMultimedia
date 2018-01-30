package es.vcarmen.dialogos01;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dialogos01 extends AppCompatActivity {

    Button boton, boton1, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos01);

        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });

        boton1 = (Button) findViewById(R.id.boton2);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1);
            }
        });

        boton2 = (Button) findViewById(R.id.boton3);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(2);
            }
        });

    }

    protected Dialog onCreateDialog(int id){
        Dialog dialogo = null;
        if (id==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("EJEMPLO DE DIÁLOGO 1");
            dialogo = builder.create();
        }
        if (id==1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("EJEMPLO DE DIÁLOGO 2");
            dialogo = builder.create();
        }
        if (id==2){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("EJEMPLO DE DIÁLOGO 3");
            dialogo = builder.create();
        }
        return dialogo;
    }

}
//Finalizada