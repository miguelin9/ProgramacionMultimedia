package es.vcarmen.examenclaseenero;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Para el callback de pedir permiso
    private final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    // Para Activity for Result
    private static final int REQUEST_CODE = 10;

    Button boton, boton4, boton5, boton6, boton7, boton8, boton9, boton10;
    Button botonImplicito, botonImplicito2, botonImplicito3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para realizar llamadas telefónicas.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para realizar llamadas!");
        }

        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar fecha = Calendar.getInstance();
                int year = fecha.get(Calendar.YEAR);
                Intent intent = new Intent(getApplicationContext(), Resultado.class);
                intent.putExtra("nombre", "Miguel");
                intent.putExtra("year", year);
                intent.putExtra("jaen", "Jaén");
                intent.putExtra("cadiz", "Cádiz");
                intent.putExtra("almeria", "Almería");
                startActivity(intent);
            }
        });

        botonImplicito = (Button) findViewById(R.id.botonImplicito);
        botonImplicito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicito = new Intent(Intent.ACTION_VIEW);
                implicito.setData(Uri.parse("http:www.iesvirgendelcarmen.com"));
                getApplication().startActivity(implicito);
            }
        });

        botonImplicito2 = (Button) findViewById(R.id.botonImplicito2);
        botonImplicito2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicito2 = new Intent(Intent.ACTION_WEB_SEARCH);
                implicito2.putExtra(SearchManager.QUERY, "Jaén");
                getApplication().startActivity(implicito2);
            }
        });

        botonImplicito3 = (Button) findViewById(R.id.botonImplicito3);
        botonImplicito3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicito2 = new Intent(Intent.ACTION_DIAL);
                implicito2.setData(Uri.parse("tel:1234567890"));
                getApplication().startActivity(implicito2);
            }
        });

        boton4 = (Button) findViewById(R.id.boton4);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicito2 = new Intent(Intent.ACTION_CALL);
                implicito2.setData(Uri.parse("tel:1234567890"));
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                            // Se tiene permiso
                        }else{
                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                            return;
                        }
                    }else{
                        // No se necesita requerir permiso OS menos a 6.0.
                    }
                getApplication().startActivity(implicito2);
            }
        });

        boton5 = (Button) findViewById(R.id.boton5);
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicito2 = new Intent(Intent.ACTION_VIEW);
                implicito2.setData(Uri.parse("geo:37.7829118,-3.792248,14?z=40&q=cafeteria"));
                getApplication().startActivity(implicito2);
            }
        });

        boton6 = (Button) findViewById(R.id.boton6);
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicito2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                getApplication().startActivity(implicito2);
            }
        });

        boton7 = (Button) findViewById(R.id.boton7);
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicito2 = new Intent(Intent.ACTION_VIEW);
                implicito2.setData(Uri.parse("content://contacts/people/"));
                getApplication().startActivity(implicito2);
            }
        });

        boton8 = (Button) findViewById(R.id.boton8);
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ejemplo = new Intent(getApplicationContext(), ActividadDos.class);
                startActivityForResult(ejemplo, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("RETORNO")) {
                Toast.makeText(this, data.getStringExtra("RETORNO"), Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Para pedir permisos de llamada
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSIONS:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // El usuario acepto los permisos.
                    Toast.makeText(this, "Gracias, aceptaste los permisos requeridos para el correcto funcionamiento de esta aplicación.", Toast.LENGTH_SHORT).show();
                }else{
                    // Permiso denegado.
                    Toast.makeText(this, "No se aceptó permisos", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
// Finalizada