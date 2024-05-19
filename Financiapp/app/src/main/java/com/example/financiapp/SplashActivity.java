package com.example.financiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ocultamos la barra de título
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Arrancamos la siguiente actividad
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                // Cerramos esta actividad para que el usuario no pueda volver a ella mediante botón de volver
                finish();
            }
        }, 4000); //Tiempo de espera del temporizador en milisegundos
    }
}