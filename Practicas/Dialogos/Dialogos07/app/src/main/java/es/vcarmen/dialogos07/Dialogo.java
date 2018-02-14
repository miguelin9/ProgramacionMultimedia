package es.vcarmen.dialogos07;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

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

    public TimePickerDialog dialogo(){
        final Calendar c = Calendar.getInstance();

        return new TimePickerDialog(
                getActivity(),
                (TimePickerDialog.OnTimeSetListener) getActivity(),
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(getActivity())
                );
    }

}
