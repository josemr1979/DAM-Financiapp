package com.example.financiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivitySIM extends AppCompatActivity {

    TextInputEditText importe;
    TextInputEditText plazo;
    TextInputEditText interes;
    TextInputEditText comisiones;
    TextView tVcuotaMensual;
    Button buttonCalculoCuota;
    Button borrar;
    Button reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sim);

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        importe = (TextInputEditText) findViewById(R.id.tInputImporte);
        plazo = (TextInputEditText) findViewById(R.id.tInputPlazo);
        interes = (TextInputEditText) findViewById(R.id.tInputInteres);
        tVcuotaMensual = (TextView) findViewById(R.id.tVcuotaMensual);
        buttonCalculoCuota = (Button) findViewById(R.id.buttonCalculoCuota);
        borrar = (Button) findViewById(R.id.buttonBorrar);
        Button buttonAmortizacion = findViewById(R.id.buttonAmortizacion);
        reg = (Button) findViewById(R.id.buttonReg);

        borrar.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.personalizado)));
        buttonCalculoCuota.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.personalizado)));
        buttonAmortizacion.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.personalizado)));



        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(importe.getText()) || TextUtils.isEmpty(plazo.getText()) || TextUtils.isEmpty(interes.getText())) {

                    Toast.makeText(getBaseContext(), "Para borrar introduce primero todos los valores", Toast.LENGTH_SHORT).show();
                    return;
                }

                    importe.setText("");
                    plazo.setText("");
                    interes.setText("");
                    tVcuotaMensual.setText("");

            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitySIM.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        buttonAmortizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(importe.getText()) || TextUtils.isEmpty(plazo.getText()) || TextUtils.isEmpty(interes.getText())) {

                    Toast.makeText(getBaseContext(), "Para poder generar el cuadro, introduce todos los valores", Toast.LENGTH_SHORT).show();
                    return;
                }
                String importeString = importe.getText().toString();
                String plazoString = plazo.getText().toString();
                String interesString = interes.getText().toString();
                // Convertir los valores a los tipos adecuados (double e int en este caso)
                double importe = Double.parseDouble(importeString);
                int plazo = Integer.parseInt(plazoString);
                double interes = Double.parseDouble(interesString);
                // Crear el Intent para iniciar AmortizacionActivity
                Intent intent = new Intent(MainActivitySIM.this, AmortizacionActivity.class);
                // Pasar los datos a través de los Extras del Intent
                intent.putExtra("importe", importe);
                intent.putExtra("plazo", plazo);
                intent.putExtra("interes", interes);
                // Iniciar AmortizacionActivity
                startActivity(intent);
            }
        });

        buttonCalculoCuota.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(importe.getText()) || TextUtils.isEmpty(plazo.getText()) || TextUtils.isEmpty(interes.getText())) {

                    Toast.makeText(getBaseContext(), "Introduce todos los valores", Toast.LENGTH_SHORT).show();
                    return;
                }

                double num1, num3;
                int num2;

                try {

                    num1 = Double.parseDouble(importe.getText().toString());
                    if (num1 < 1) {
                        Toast.makeText(getBaseContext(), "Introduce un importe superior a 1€ en importe a financiar", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(getBaseContext(), "El importe introducido no es válido", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {

                    num2 = Integer.parseInt(plazo.getText().toString());
                    if (num2 < 1 || num2 > 480) {
                        Toast.makeText(getBaseContext(), "Introduce un plazo superior a 1 mes e inferior a 480 meses", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(getBaseContext(), "El plazo introducido no es válido", Toast.LENGTH_SHORT).show();
                    return;
                }
                try{

                num3 = Double.parseDouble(interes.getText().toString());

                } catch (NumberFormatException e) {
                    Toast.makeText(getBaseContext(), "El interés introducido no es válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                double tasaInteres = num3/100;


                double cuotaMensual = calcularCuotaMensual(num1, tasaInteres, num2);
                String formatResulta = String.format("%.2f", cuotaMensual);
                tVcuotaMensual.setText( formatResulta + "€/mes");
            }

                public double calcularCuotaMensual ( double importe, double tasaInteresAnual, int plazoMeses){
                    double tasaInteresMensual = tasaInteresAnual / 12;
                    //double numerador = importe * tasaInteresMensual * Math.pow(1 + tasaInteresMensual, plazoMeses);
                    //double denominador = Math.pow(1 + tasaInteresMensual, plazoMeses) - 1;
                    double factor = Math.pow(1 + tasaInteresMensual, -plazoMeses);
                    double cuotaMensual = importe * tasaInteresMensual / (1 - factor);
                    return cuotaMensual;
                }




        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }



}