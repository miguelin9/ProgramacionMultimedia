package es.vcarmen.fragment05;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by matinal on 19/10/17.
 */

public class Fragmento1 extends PreferenceFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addPreferencesFromResource(R.xml.preferencias);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
