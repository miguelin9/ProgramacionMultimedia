package es.vcarmen.dialogos08;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by matinal on 11/01/18.
 */

public class Dialogo extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return dialogo();
    }

    public DatePickerDialog dialogo(){
        final Calendar c = Calendar.getInstance();

        return new DatePickerDialog(
                getActivity(),
                (DatePickerDialog.OnDateSetListener) getActivity(),
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
                );
    }

}
