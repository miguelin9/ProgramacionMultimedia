package es.vcarmen.material09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Material09 extends AppCompatActivity {

    Toolbar toolbar;
    ImageView icono;
    boolean giro;

    private final static int DURACION = 250;

    LinearLayout detalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material09);

        giro = false;

        detalle = (LinearLayout) findViewById(R.id.linear3);

        toolbar = (Toolbar) findViewById(R.id.barra1);
        toolbar.setTitle("EL RAPTO DE LAS SABINAS");
        toolbar.setSubtitle("Jacques Louis David");
        // Añadimos el menu al toolbar
        toolbar.inflateMenu(R.menu.menu);
        // Escuchador para el menu
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.opcion1:
                        Toast.makeText(getApplication(), "PULSADA OPCIÓN1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.opcion2:
                        Toast.makeText(getApplication(), "PULSADA OPCIÓN2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.opcion3:
                        Toast.makeText(getApplication(), "PULSADA OPCIÓN3", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        icono = (ImageView) findViewById(R.id.imagen2);

    }

    private void rotado(float angulo){
        Animation animacion = new RotateAnimation(0.0f, angulo, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animacion.setFillAfter(true);
        animacion.setDuration(DURACION);
        icono.startAnimation(animacion);
    }

    public void tocado(View view){
        if (giro){
            icono.setImageResource(R.mipmap.menos);
            rotado(-180.0f);
            giro = false;
            Dinamizador.contrae(detalle,DURACION);
        }else{
            icono.setImageResource(R.mipmap.mas);
            rotado(180.0f);
            giro = true;
            Dinamizador.expande(detalle,DURACION);
        }
    }

}
//Finalizada