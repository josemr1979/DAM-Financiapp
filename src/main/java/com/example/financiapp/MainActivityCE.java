package com.example.financiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivityCE extends AppCompatActivity {

    SeekBar seek;
    TextView textView;
    TextInputEditText ingresos;
    TextInputEditText cuotas;
    TextView porcent;
    TextView max;
    float numero = 0.0f;
    Button boton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ce);

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        seek = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.tViewPagas);
        ingresos = (TextInputEditText) findViewById(R.id.tInputIngresos);
        cuotas = (TextInputEditText) findViewById(R.id.tInputCuotas);
        porcent = (TextView) findViewById(R.id.tViewPorcent);
        max = (TextView) findViewById(R.id.tViewMax);
        boton = (Button) findViewById(R.id.button);

        boton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.personalizado)));


        seek.setMax(24);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seek, int i, boolean b) {
                textView.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(ingresos.getText()) || TextUtils.isEmpty(cuotas.getText())) {

                    Toast.makeText(getBaseContext(),"Introduce todos los valores",Toast.LENGTH_SHORT).show();
                    return;
                }

                double num1 = Double.parseDouble(ingresos.getText().toString());
                double num2 = Double.parseDouble(cuotas.getText().toString());
                int num3 = Integer.parseInt(textView.getText().toString());

                double resultado = ((num2*12) / ((num1*num3))) * 100 ;
                double capacidad = (((num1*num3)/12) * 0.40) - num2;


                String formatResult = String.format("%.2f", resultado);
                porcent.setText("% Endeudamiento " + formatResult + "%");

                String formatResulta = String.format("%.2f", capacidad);
                max.setText("Capacidad Endeudamiento " + formatResulta + "€");

                double cuarentaPorciento = 40.00;

                if (resultado > cuarentaPorciento) {
                    porcent.setTextColor(Color.RED);
                } else {
                    int darkGreenColor = Color.rgb(0, 100, 0);
                    porcent.setTextColor(darkGreenColor);
                }

                if (resultado > cuarentaPorciento) {

                    //max.setText("Capacidad Endeudamiento -" + formatResulta + "€");
                    max.setTextColor(Color.RED);
                } else {
                    int darkGreenColor = Color.rgb(0, 100, 0);
                    max.setTextColor(darkGreenColor);
                }
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