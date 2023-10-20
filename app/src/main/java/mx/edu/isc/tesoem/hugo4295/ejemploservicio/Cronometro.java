package mx.edu.isc.tesoem.hugo4295.ejemploservicio;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends Service {
    private Context ctx=null;
    TextView texto;
    Timer temporizador = new Timer();
    private static final long INTERVALO_ACTUALIZACION=100;
    private double  cronometro =0.0;

    public Cronometro() {
    }

    public Cronometro(Context c){
        super();
        this.ctx=c;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void nuevo(){
        new CountDownTimer(30000,100){
            @Override
            public void onTick(long l) {
             /*   Toast.makeText(ctx, "resta " + l/1000, Toast.LENGTH_SHORT).show();*/
                Log.i("contador", "onTick: " + l/1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(ctx, "se acabo", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

private void IniciarCronometro(){
        temporizador.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cronometro+=0.01;
                texto.setText(String.valueOf(cronometro));
            }
        },0,INTERVALO_ACTUALIZACION);
}

    public void setView(TextView v){
        texto=v;
        texto.setText("mi texto pasando por un servicio");
        IniciarCronometro();
    }

    @Override
    public void onDestroy() {
        if (temporizador != null) {
            temporizador.cancel();
        }
        super.onDestroy();
    }
}