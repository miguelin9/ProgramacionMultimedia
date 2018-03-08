package es.vcarmen.surface01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Surface01 extends AppCompatActivity {

    SurfaceView surfaceView;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface01);

        surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Botón pulsado", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
// Finalizada