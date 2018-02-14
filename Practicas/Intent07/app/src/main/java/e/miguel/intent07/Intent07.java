package e.miguel.intent07;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Intent07 extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent07);

        Button btnTime = (Button) findViewById(R.id.btnTime);
        Button btnDate = (Button) findViewById(R.id.btnDate);
        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnTime:
                intent = new Intent("es.vcarmen.intent.action.showtime");
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent("es.vcarmen.intent.action.showdate");
                startActivity(intent);
                break;
        }
    }
}
// Finalizada