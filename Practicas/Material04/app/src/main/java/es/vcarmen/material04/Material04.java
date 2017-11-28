package es.vcarmen.material04;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Material04 extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    FloatingActionButton fab;
    Button btnSimple, btnInteractivo, btnPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material04);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        btnSimple = (Button) findViewById(R.id.btnSimple);
        btnInteractivo = (Button) findViewById(R.id.btnInteractivo);
        btnPersonalizado = (Button) findViewById(R.id.btnPersonalizado);

        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "EJEMPLO DE SNACKBAR", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        btnInteractivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "MENSAJE BORRADO", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "MENSAJE RESTAURADO", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
                snackbar.show();
            }
        });

        btnPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "NO ENCUENTRO LA RED", Snackbar.LENGTH_LONG).setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplication(), "Pulsado RETRY", Toast.LENGTH_SHORT).show();
                    }
                });
                // para cambiar el color del boton del snackbar
                snackbar.setActionTextColor(Color.CYAN);
                // para cambiar el color del texto del snackbar hace falta obtener la vista y buscar el textView
                View view = snackbar.getView();
                TextView texto = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
                texto.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        });

    }
}
// Falta la parte 7 Practicando lo aprendido