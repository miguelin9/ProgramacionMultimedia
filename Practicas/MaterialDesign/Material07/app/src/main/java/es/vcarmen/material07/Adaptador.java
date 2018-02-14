package es.vcarmen.material07;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.webkit.WebView;

import java.io.Console;

/**
 * Created by matinal on 23/11/17.
 */

public class Adaptador extends FragmentStatePagerAdapter {

    int numTab;

    public Adaptador(FragmentManager fm, int numTab) {
        super(fm);
        this.numTab = numTab;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                Primero primero = new Primero();
                return primero;
            case 1:
                Segundo segundo = new Segundo();
                return segundo;
            case 2:
                Tercero tercero = new Tercero();
                return tercero;
            default:
                //("Adaptador::Switch::default");
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numTab;
    }
}
