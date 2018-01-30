package es.vcarmen.dialogos07;

import android.app.TimePickerDialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class Dialogos07 extends FragmentActivity implements TimePickerDialog.OnTimeSetListener{

    Button boton;
    FragmentManager FM = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos07);

        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialogo fragment = new Dialogo();
                fragment.show(FM, "DialogHora");
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        Toast.makeText(this,
                "Hora: " + hour + ":" + minute,
                Toast.LENGTH_LONG).show();
    }
}
//Finalizada