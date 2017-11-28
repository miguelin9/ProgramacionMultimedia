package es.vcarmen.material01;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Material01 extends AppCompatActivity {

    private TextInputLayout controlNombre;
    private EditText campoNombre;
    private TextInputLayout controlCorreo;
    private EditText campoCorreo;
    private TextInputLayout controlTelefono;
    private EditText campoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material01);

        controlNombre = (TextInputLayout) findViewById(R.id.control_nombre);
        campoNombre = (EditText) findViewById(R.id.campo_nombre);
        campoNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                controlNombre.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        controlCorreo = (TextInputLayout) findViewById(R.id.control_correo);
        campoCorreo = (EditText) findViewById(R.id.campo_correo);
        campoCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                esCorreoValido(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        controlTelefono = (TextInputLayout) findViewById(R.id.control_telefono);
        campoTelefono = (EditText) findViewById(R.id.campo_telefono);
        campoTelefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                controlTelefono.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button aceptar = (Button) findViewById(R.id.boton_aceptar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos();
            }
        });
    }

    private boolean esNombreValido(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombre).matches() || nombre.length() > 30){
            controlNombre.setError("ERROR EN NOMBRE");
            return false;
        }else{
            controlNombre.setError(null);
        }
        return true;
    }

    private boolean esCorreoValido(String correo){
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches() || correo.length() > 30){
            controlCorreo.setError("ERROR EN CORREO");
            return false;
        }else{
            controlCorreo.setError(null);
        }
        return true;
    }

    private boolean esTelefonoValido(String telefono) {
        if (!Patterns.PHONE.matcher(telefono).matches() || telefono.length() > 30){
            controlTelefono.setError("ERROR EN TELÉFONO");
            return false;
        } else {
            controlTelefono.setError(null);
        }
        return true;
    }

    private void validarDatos(){
        String nombre = controlNombre.getEditText().getText().toString();
        boolean a = esNombreValido(nombre);
        String correo = controlCorreo.getEditText().getText().toString();
        boolean b = esCorreoValido(correo);
        String telefono = controlTelefono.getEditText().getText().toString();
        boolean c = esTelefonoValido(telefono);

        if (a && b && c){
            Toast.makeText(this, "REGISTRO CORRECTO", Toast.LENGTH_SHORT).show();
        }
    }
}
// Finalizado