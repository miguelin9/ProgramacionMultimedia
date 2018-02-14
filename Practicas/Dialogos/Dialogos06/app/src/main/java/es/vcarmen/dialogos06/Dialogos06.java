package es.vcarmen.dialogos06;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dialogos06 extends AppCompatActivity {

    TextView texto;
    Button boton;
    ProgressDialog progressDialog;
    int progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos06);

        texto = (TextView) findViewById(R.id.texto);
        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
                new MiAsyncTask().execute();
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("Progreso...");

        return progressDialog;
    }

    class MiAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 100; i++){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                }
                progreso = i + 1;
                publishProgress();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            progressDialog.setProgress(progreso);
            if (progreso == 100){
                texto.setText("PROGRESO TERMINADO");
                progressDialog.dismiss();
            }
        }
    }

}
//Finalizado