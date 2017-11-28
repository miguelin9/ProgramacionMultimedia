package es.vcarmen.material07;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Material07 extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager paginador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material07);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        paginador = (ViewPager) findViewById(R.id.contenedor2);

        TabLayout.Tab primerTab = tabLayout.newTab();
        primerTab.setText("PRIMERO");
        primerTab.setIcon(android.R.drawable.ic_media_previous);
        tabLayout.addTab(primerTab);

        TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("SEGUNDO");
        segundoTab.setIcon(android.R.drawable.ic_media_play);
        tabLayout.addTab(segundoTab);

        TabLayout.Tab tercerTab = tabLayout.newTab();
        tercerTab.setText("TERCERO");
        tercerTab.setIcon(android.R.drawable.ic_media_ff);
        tabLayout.addTab(tercerTab);

        // Escuchador del TabLayout
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {
                    case 0:
                        paginador.setCurrentItem(0);
                        break;
                    case 1:
                        paginador.setCurrentItem(1);
                        break;
                    case 2:
                        paginador.setCurrentItem(2);
                        break;
                    default:
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

        Adaptador adaptador = new Adaptador(getSupportFragmentManager(), tabLayout.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}
// Falta el Practicando lo aprendido