package com.example.lab05_calculadora;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.app.Service;
import androidx.annotation.Nullable;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;


public class ServicioCalculadora extends Service {
    private static final String TAG = "MyService";
    @Override
    public IBinder onBind(Intent i) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void onCreate(){
        //Toast.makeText(getApplicationContext(),"Servicio Creado",Toast.LENGTH_SHORT).show();

    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        double num1,num2,resultado;
        int Operacion;

        num1 = intent.getExtras().getDouble("num1",100.00);
        num2 = intent.getExtras().getDouble("num2",100.00);
        Operacion = intent.getExtras().getInt("Operacion",1);


        if (Operacion == 3){

            resultado = num1 * num2;
            Toast.makeText(this,"El resultado desde el servicio es : "+String.valueOf(resultado) ,Toast.LENGTH_SHORT).show();
        }
        if (Operacion == 4){
            resultado = num1 / num2;
            Toast.makeText(this,"El resultado desde el servicio es : "+String.valueOf(resultado) ,Toast.LENGTH_SHORT).show();
        }
        if (Operacion == 1){
            resultado = num1+ num2;
            Toast.makeText(this,"El resultado desde el servicio es : "+String.valueOf(resultado) ,Toast.LENGTH_SHORT).show();
        }
        if (Operacion == 2){
            resultado = num1 - num2;
            Toast.makeText(this,"El resultado desde el servicio es : "+String.valueOf(resultado) ,Toast.LENGTH_SHORT).show();
        }

        Log.d(TAG, "FirstService started");

        this.stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "FirstService destroyed");
    }

}
