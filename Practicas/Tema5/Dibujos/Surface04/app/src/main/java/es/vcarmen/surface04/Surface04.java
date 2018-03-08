package es.vcarmen.surface04;

import android.content.pm.ActivityInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Surface04 extends AppCompatActivity {

    RelativeLayout rl;
    SurfaceView sv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface04);

        rl = (RelativeLayout) findViewById(R.id.rl);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Preview mPreview = new Preview(this);
        DrawOnTop mDraw = new DrawOnTop(this);
        sv = new Preview(Surface04.this);
        rl.addView(mPreview);
        rl.addView(mDraw);
    }

    public void foto(View v) {
        Preview fotografia = new Preview(this);
        fotografia.fotografia();
    }
}

class DrawOnTop extends View {
    private Bitmap bmp;
    private Bitmap bmp2;

    public DrawOnTop(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.mirilla);
        int anc_ima = bmp.getWidth();
        int alt_ima = bmp.getHeight();
        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();
        int pini = (ancho - anc_ima) / 2;
        int pins = (alto - alt_ima) / 2;
        super.onDraw(canvas);
        Paint pincel = new Paint();
        pincel.setAntiAlias(true);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawBitmap(bmp, pini, pins, null);
    }
}

class Preview extends SurfaceView implements SurfaceHolder.Callback {
    public SurfaceHolder mHolder;
    public static Camera.PictureCallback jpegCallback;
    public static Camera mCamera;

    Preview(Context context) {
        super(context);
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        jpegCallback = new Camera.PictureCallback() {
            public void onPictureTaken(byte[] data, Camera mCamera) {
                FileOutputStream outStream = null;
                try {
                    outStream = new
                            FileOutputStream(String.format("/sdcard/%d.jpg",
                            System.currentTimeMillis()));
                    outStream.write(data);
                    outStream.close();
                    Log.d("Log", "onPictureTaken - wrote bytes: " +
                            data.length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
                Toast.makeText(getContext(), "FOTOGRAFIA GUARDADA",
                        Toast.LENGTH_LONG).show();
                refreshCamera();
            }
        };
    }

    public void surfaceCreated(SurfaceHolder holder) {
        mCamera = Camera.open();
        mCamera.setDisplayOrientation(90);
        try {
            mCamera.setPreviewDisplay(holder);
            mCamera.startPreview();
        } catch (Exception e) {
            System.err.println(e);
            return;
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.stopPreview();
        mCamera = null;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int
            w, int h) {
    }

    public static void fotografia() {
        mCamera.takePicture(null, null, jpegCallback);
    }

    @Override
    public boolean onTouchEvent(MotionEvent evento) {
        if (evento.getAction() == MotionEvent.ACTION_DOWN) {
            mCamera.takePicture(null, null, jpegCallback);
        }
        return true;
    }

    public void refreshCamera() {
        if (mHolder.getSurface() == null) {
            return;
        }
        try {
            mCamera.stopPreview();
        } catch (Exception e) {
        }
        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();
        } catch (Exception e) {
        }
    }
}
// Finalizada pero guarda la foto sola sin la mirilla