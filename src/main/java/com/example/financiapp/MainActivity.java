package com.example.financiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));

        WebView webView = findViewById(R.id.webViewEuribor);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setWebViewClient(new WebViewClient());

        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);

        // Configura un WebViewClient para que las nuevas URL se carguen en el mismo WebView en lugar de en el navegador externo
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // Devuelve 'false' para que las nuevas URL se carguen en el WebView actual
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // Una vez que la página haya terminado de cargar, ejecuta un script JavaScript para ocultar el desplazamiento
                view.loadUrl("javascript:(function() { " +
                        "document.getElementsByTagName('body')[0].style.overflow = 'hidden'; " +
                        "})()");
            }

        });

        webView.loadUrl("https://www.euribor.com.es");

        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Devuelve 'true' para indicar que has manejado el evento de desplazamiento y no quieres que el WebView lo procese
                return true;
            }
        });

        ImageView buttoniVei = findViewById(R.id.iVei);
        buttoniVei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Enlaces de Interés",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityEI.class);
                startActivity(intent);
            }
        });

        TextView tVei = findViewById(R.id.tVei);
        tVei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Enlaces de Interés",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityEI.class);
                startActivity(intent);
            }
        });

        ImageView buttoniVdoc = findViewById(R.id.iVdoc);
        buttoniVdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Documentación a Presentar",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityDOC.class);
                startActivity(intent);
            }
        });

        TextView tVdp = findViewById(R.id.tVdp);
        tVdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Documentación a Presentar",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityDOC.class);
                startActivity(intent);
            }
        });

        ImageView buttoniVsim = findViewById(R.id.iVsim);
        buttoniVsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Simulador",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivitySIM.class);
                startActivity(intent);
            }
        });

        TextView tVs = findViewById(R.id.tVs);
        tVs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Simulador",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivitySIM.class);
                startActivity(intent);
            }
        });

        ImageView buttoniVce = findViewById(R.id.iVce);
        buttoniVce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Cálculo Endeudamiento",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityCE.class);
                startActivity(intent);
            }
        });

        TextView tVce = findViewById(R.id.tVce);
        tVce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Cálculo Endeudamiento",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityCE.class);
                startActivity(intent);
            }
        });

        ImageView buttoniVqds = findViewById(R.id.iVqds);
        buttoniVqds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"¿Qué Debes Saber?",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityQDS.class);
                startActivity(intent);
            }
        });
        TextView tVqds = findViewById(R.id.tVqds);
        tVqds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"¿Qué Debes Saber?",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActivityQDS.class);
                startActivity(intent);
            }
        });
    }
}