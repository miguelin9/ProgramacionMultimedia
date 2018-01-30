package es.vcarmen.dialogos08;

import android.app.DatePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Dialogos08 extends FragmentActivity implements DatePickerDialog.OnDateSetListener{

    Button boton;
    FragmentManager FM = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos08);

        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogo fragment = new Dialogo();
                fragment.show(FM, "DialogCalendar");
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Toast.makeText(this,
                "Fecha elegida: " + day + "/" + (month+1) + "/" + year,
                Toast.LENGTH_LONG).show();
    }
}
//Finalizada