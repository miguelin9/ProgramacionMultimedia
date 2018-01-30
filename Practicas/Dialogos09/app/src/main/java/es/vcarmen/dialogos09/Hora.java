package es.vcarmen.dialogos09;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

import java.util.Calendar;

/**
 * Created by matinal on 12/01/18.
 */

public class Hora extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return dialogo();
    }
    public TimePickerDialog dialogo() {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(
                getActivity(),
                (TimePickerDialog.OnTimeSetListener) getActivity(),
                hour,
                minute,
                DateFormat.is24HourFormat(getActivity()));
    }
}