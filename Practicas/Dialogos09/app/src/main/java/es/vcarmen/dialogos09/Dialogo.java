package es.vcarmen.dialogos09;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dialogo extends DialogFragment {
    private TextView textFecha;
    private TextView textTiempo;
    public Dialogo() {
//REQUERIDO CONSTRUCTOR VACIO
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        ActionBar actionBar = ((AppCompatActivity) getActivity())
                .getSupportActionBar();if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalle, container, false);
        iniciarHora(view);// PONER HORA INICIAL
        iniciarFecha(view);// PONER FECHA INICIAL
        return view;
    }
    private void iniciarHora(View view) {
        textTiempo = (TextView) view.findViewById(R.id.hora_text);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
        textTiempo.setText(format.format(c.getTime()));
        textTiempo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Hora().show(getFragmentManager(), "TIEMPO");
                    }
                }
        );
    }
    private void iniciarFecha(View view) {
        textFecha = (TextView) view.findViewById(R.id.fecha_text);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("E MMM d yyyy");
        textFecha.setText(format.format(c.getTime()));
        textFecha.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Fecha().show(getFragmentManager(), "FECHA");
                    }
                }
        );
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.completa, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                break;
            case R.id.action_save:break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void setDateView(int year, int monthOfYear, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(year, monthOfYear, dayOfMonth);
        SimpleDateFormat format = new SimpleDateFormat("E MMM d yyyy");
        textFecha.setText(format.format(c.getTime()));
    }
    public void setTimeView(int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
        textTiempo.setText(format.format(c.getTime()));
    }
}