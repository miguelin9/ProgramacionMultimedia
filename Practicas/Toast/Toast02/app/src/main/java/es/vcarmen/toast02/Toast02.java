package es.vcarmen.toast02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Toast02 extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast02);

        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast2,(ViewGroup) findViewById(R.id.layout));
                toast.setView(layout);
                toast.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                toast.setDuration(Toast.LENGTH_SHORT);
                TextView mensaje = (TextView) layout.findViewById(R.id.texto);
                mensaje.setText("Texto Cambiado en el onClick");
                toast.show();
            }
        });

    }
}
//finalizada