package es.vcarmen.dialogos02;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dialogos02 extends AppCompatActivity {

    Button boton, botonDialogo;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos02);

        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });

    }

    protected Dialog onCreateDialog(int id){
        Dialog dialogo = new Dialog(this);
        if (id==0){
            Window w = dialogo.getWindow();
            int flag = WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
            w.setFlags(flag, flag);
            dialogo.setTitle("DIÁLOGO PERSONAL");
            dialogo.setContentView(R.layout.dialogo);
            user = (EditText) dialogo.findViewById(R.id.etUser);
            pass = (EditText) dialogo.findViewById(R.id.etPass);
            botonDialogo = (Button) dialogo.findViewById(R.id.botonDialogo);
            botonDialogo.setOnClickListener(new Dialogos02.Aceptar());
        }

        return dialogo;
    }

    class Aceptar implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String usuario = user.getText().toString().trim();
            String password = pass.getText().toString().trim();

            if (usuario.matches("Leonardo") && password.matches("Davinci")){
                dismissDialog(0);
            }else{
                Toast.makeText(Dialogos02.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
//Finalizada pero falta el titulo del diálogo (dice Jacinto que es por la versión de android)