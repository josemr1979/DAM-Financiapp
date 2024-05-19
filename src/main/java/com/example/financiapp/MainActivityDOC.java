package com.example.financiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivityDOC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_doc);

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ImageButton iBAsala = findViewById(R.id.iBAsala);
        ImageButton iBAutono = findViewById(R.id.iBAutono);


        iBAsala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityDOC.this);
                builder.setTitle("Documentación Asalariados/as")
                        .setMessage("* IRPF \n* 3 últimas Nóminas \n* Justif. cuotas otras Entidades \n* Justificante finalidad \n* Vida laboral" +
                                "\n* Contrato laboral \n* Cuadro fincabilidad")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

        iBAutono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityDOC.this);
                builder.setTitle("Documentación Autónomos/as")
                        .setMessage("* Certificado estar corriente AEAT \n* Certificado estar corriente Seg. Social \n* IRPF Anual \n* IRPF Trimestral " +
                                "\n* IVA anual \n* IVA trimestral \n* Justif. cuotas otras Entidades \n* Justificante finalidad \n* Cuadro fincabilidad")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
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