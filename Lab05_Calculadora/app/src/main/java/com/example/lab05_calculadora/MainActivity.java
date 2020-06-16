package com.example.lab05_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSuma, btnResta, btnDivision, btnMultiplicacion;
    EditText enumero1,enumero2,eresultado;
    String operacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enumero1 = (EditText)findViewById(R.id.edt_numero1);
        enumero2 = (EditText)findViewById(R.id.edt_numero2);
        eresultado = (EditText)findViewById(R.id.edt_resultado);
        operacion = "x";

        btnSuma = (Button)findViewById(R.id.btn_suma);
        btnResta = (Button)findViewById(R.id.btn_resta);
        btnDivision = (Button)findViewById(R.id.btn_division);
        btnMultiplicacion = (Button)findViewById(R.id.btn_multiplicacion);


        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rpta = String.valueOf(Realizar_Operacion(1));
                eresultado.setText(rpta);
            }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rpta = String.valueOf(Realizar_Operacion(2));
                eresultado.setText(rpta);
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rpta = String.valueOf(Realizar_Operacion(3));
                eresultado.setText(rpta);
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rpta = String.valueOf(Realizar_Operacion(4));
                eresultado.setText(rpta);
            }
        });
    }

    public double Realizar_Operacion(int Operacion){
        double num1 = Double.parseDouble(enumero1.getText().toString());
        double num2 = Double.parseDouble(enumero2.getText().toString());
        double resultado = 0.00;

        //USANDO SERVICIO
        Intent intent = new Intent(this, ServicioCalculadora.class);
        intent.putExtra("num1",num1);
        intent.putExtra("num2",num2);
        intent.putExtra("Operacion",Operacion);
        startService(intent);

        if (enumero1.getText().toString() == "" || enumero2.getText().toString() == ""){
            Toast.makeText(getApplicationContext(),"Ingrese ambos numero", Toast.LENGTH_SHORT).show();
        }else{
            if (Operacion == 3){
                resultado = num1 * num2;
            }
            if (Operacion == 4){
                resultado = num1 / num2;
            }
            if (Operacion == 1){
                resultado = num1+ num2;
            }
            if (Operacion == 2){
                resultado = num1 - num2;
            }
        }


        return resultado;
    }
}
