package e.miguel.intent07;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Fecha extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fecha);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(new Date(System.currentTimeMillis()));
        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        tvDate.setText(date);
    }
}