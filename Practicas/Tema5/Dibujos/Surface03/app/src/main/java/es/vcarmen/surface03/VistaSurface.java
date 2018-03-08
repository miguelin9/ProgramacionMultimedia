package es.vcarmen.surface03;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by miguel on 8/03/18.
 */

public class VistaSurface extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder contenedor;
    private Camera miCamara;

    private Camera.PictureCallback fotografia;

    public VistaSurface(Context context) {
        super(context);

        contenedor = getHolder();
        contenedor.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        contenedor.addCallback(this);

        fotografia = new Camera.PictureCallback() {
            public void onPictureTaken(byte[] data, Camera mCamera) {
                FileOutputStream outStream = null;
                try {
                    outStream = new
                            FileOutputStream(String.format("/sdcard/%d.jpg",
                            System.currentTimeMillis()));
                    outStream.write(data);
                    outStream.close();
                    Log.d("Log", "ERROR EN GUARDADO: " + data.length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
                Toast.makeText(getContext(), "FOTOGRAFIA GUARDADA",
                        Toast.LENGTH_LONG).show();
                refrescaCamera();
            }
        };
    }

    public void refrescaCamera() {
        if (contenedor.getSurface() == null) {
            return;
        }
        try {
            miCamara.stopPreview();
        } catch (Exception e) {
        }
        try {
            miCamara.setPreviewDisplay(contenedor);
            miCamara.startPreview();
        } catch (Exception e) {
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()== MotionEvent.ACTION_DOWN) {
            miCamara.takePicture(null, null, fotografia);
        }
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        miCamara = Camera.open();
        miCamara.setDisplayOrientation(90);
        try {
            miCamara.setPreviewDisplay(contenedor);
            miCamara.startPreview();
        } catch (Exception e) {
            System.err.println(e);
            return;
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        miCamara.stopPreview();
        miCamara = null;
    }
}
