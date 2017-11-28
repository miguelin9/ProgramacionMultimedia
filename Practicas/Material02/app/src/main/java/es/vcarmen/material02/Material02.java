package es.vcarmen.material02;

import android.animation.Animator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class Material02 extends AppCompatActivity {

    boolean tocado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material02);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        // definimos las escalas iniciales del fab
        fab.setScaleX(0);
        fab.setScaleY(0);
        // creamos un interpolador
        final android.view.animation.Interpolator interpolator = AnimationUtils.loadInterpolator(getBaseContext(), android.R.interpolator.fast_out_slow_in);
        // animaremos el fab
        // a la animación hay que ponerle un escuchador y unos parámetros
        fab.animate()   .scaleX(1)
                        .scaleY(1)
                        .setInterpolator(interpolator)
                        .setDuration(600)
                        .setStartDelay(1000)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                fab.animate()   .scaleX(1)
                                                .scaleY(1)
                                                .setInterpolator(interpolator)
                                                .setDuration(600)
                                                .start();
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "FAB TOCADO", Toast.LENGTH_SHORT).show();
                fab.animate()   .scaleY(0)
                                .scaleX(0)
                                .setInterpolator(interpolator)
                                .setDuration(600)
                                .start();
                tocado = !tocado;
                v.animate() .rotation(tocado ? 45f : 0)
                            .setInterpolator(interpolator)
                            .start();
            }
        });


    }
}
// Finalizado