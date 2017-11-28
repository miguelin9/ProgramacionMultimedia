package es.vcarmen.material06;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Material06 extends AppCompatActivity{

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material06);

        // Asignamos el TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        // Se crea un tab (pestaña)
        TabLayout.Tab primerTab = tabLayout.newTab();
        // Seteamos el texto que mostrara
        primerTab.setText("TAB01");
        // Pondremos un icono
        primerTab.setIcon(R.mipmap.ic_launcher);
        // Por ultimo lo añadimos al TabLayout
        tabLayout.addTab(primerTab);

        // creando el segundo tab
        TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("TAB02");
        segundoTab.setIcon(R.drawable.icono1);
        tabLayout.addTab(segundoTab);

        // creando el tercer tab
        TabLayout.Tab tercerTab = tabLayout.newTab();
        tercerTab.setText("TAB03");
        tercerTab.setIcon(R.drawable.icono2);
        tabLayout.addTab(tercerTab, 1, true);
        // estas dos lineas es lo mismo que la de arriba.
        //tabLayout.addTab(tercerTab, 1);
        //tabLayout.addTab(tercerTab, true);

        // Modificadores del aspecto de las tab
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER); // las centra
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL); // hace que ocupe todo el ancho
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        // Para cambiar el color del texto
        //tabLayout.setTabTextColors(Color.RED, Color.WHITE);
        //tabLayout.setTabTextColors(Color.argb(255,50,50,50), Color.argb(255,0,200,200));
        tabLayout.setTabTextColors(Color.rgb(50,50,50), Color.rgb(0,200,200));

        // Para cambiar el color de la linea de abajo del tab
        tabLayout.setSelectedTabIndicatorColor(Color.GREEN);
        // Para la altura de este indicador
        tabLayout.setSelectedTabIndicatorHeight(12);

        // Crearemos un escuchador para detectar las pulsaciones de los tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int elegida = tabLayout.getSelectedTabPosition();
                switch (elegida){
                    case 0:
                        Toast.makeText(getApplication(), "Pulsado TAB01", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplication(), "Pulsado TAB03", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplication(), "Pulsado TAB02", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplication(), "Default del Switch", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Otra forma de crear Tab
        tabLayout.addTab(tabLayout.newTab().setText("TAB04").setIcon(R.drawable.icono2));
        // Para borrar Tabs
        tabLayout.removeTab(tabLayout.getTabAt(3));
        // Para saber los Tabs que tenemos implementados
        final int tabCount = tabLayout.getTabCount();

        // Escuchadores para los botones
        Button btnAñadir = (Button) findViewById(R.id.btnAñadirTab);
        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tabLayout.getTabCount() < 6){
                tabLayout.addTab(tabLayout.newTab().setText("TAB"));
                } else {
                    Toast.makeText(getApplication(), "Has llegado al máximo de Tabs", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnEliminar = (Button) findViewById(R.id.btnEliminarTab);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tabLayout.getTabCount() > 2) {
                    tabLayout.removeTab(tabLayout.getTabAt(tabLayout.getTabCount()-1));
                } else {
                    Toast.makeText(getApplication(), "No puedes borrar más Tabs", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
// Finalizado