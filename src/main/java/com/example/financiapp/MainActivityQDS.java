package com.example.financiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityQDS extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_qds);

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Pedir financiación es un paso importante que requiere una cuidadosa atención y planificación. " +
                "\nCon esta app se intenta explicar algunas cosas que deberías saber antes de solicitarla:" +"\n\n1.- Analiza" +
                " tu situación financiera: Te doy la herramienta para ver tu capacidad de endeudamiento. \n2.- Tipo de " +
                "financiación: ¿Qué es lo que realmente necesitas: un préstamo personal, una hipoteca, una línea de crédito " +
                "o algún otro tipo de financiación?." + "\n3.- Intereses y condiciones: Comprende los términos y condiciones" +
                " del préstamo. Compara ofertas para obtener las mejores condiciones posibles." + "\n4.- Tu historial " +
                "crediticio juega un papel importante en la decisión de la entidad bancaria de otorgarte financiación. \n5.- " +
                "Documentación requerida: Te detallo la necesaria. \n\nA continuación te especifico conceptos que te servirán" +
                " de ayuda.");

        Button btSiguiente = findViewById(R.id.button2);
        btSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivityQDS.this, MainActivityQDS3.class);
                startActivity(intent);
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