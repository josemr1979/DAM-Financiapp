package com.example.financiapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;

import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class AmortizacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amortizacion);

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        double importe = intent.getDoubleExtra("importe", 0);
        int plazo = intent.getIntExtra("plazo", 0);
        double interes = intent.getDoubleExtra("interes", 0);


        TableLayout tableLayoutAmortizacion = findViewById(R.id.tableLayoutAmortizacion);
        generarTablaAmortizacion(tableLayoutAmortizacion, importe, plazo, interes);
        Button buttonGeneratePdf = (Button) findViewById(R.id.buttonGeneratePdf);

        buttonGeneratePdf.setOnClickListener(v -> {
            generatePdf();
        });

        Button buttonSendEmail = findViewById(R.id.buttonSendEmail);
        buttonSendEmail.setOnClickListener(v -> {
            sendEmail();
        });


    }

    private void generarTablaAmortizacion(TableLayout tableLayout, double importe, int plazo, double interes) {
        // Agregar encabezado
        TableRow headerRow = new TableRow(this);
        headerRow.setBackgroundColor(Color.LTGRAY);
        String[] headers = {"Período", "Cuota", "Interés", "Amortización", "Saldo"};
        for (String header : headers) {
            TextView textView = new TextView(this);
            textView.setText(header);
            textView.setPadding(16, 8, 16, 8);
            headerRow.addView(textView);
        }
        tableLayout.addView(headerRow);
        double saldo = importe;

        // Agregar filas de datos
        for (int i = 1; i <= plazo; i++) {
            // Calcular los valores para este período
            double cuota = calcularCuotaMensual(saldo, interes / 100 / 12, plazo - i + 1);
            double interesPeriodo = saldo * (interes / 100 / 12);
            double amortizacion = cuota - interesPeriodo;
            saldo -= amortizacion;

            // Crear una nueva fila
            TableRow row = new TableRow(this);
            TextView periodoTextView = new TextView(this);
            periodoTextView.setText(String.valueOf(i));
            TextView cuotaTextView = new TextView(this);
            cuotaTextView.setText(String.format("%.2f", cuota));
            TextView interesTextView = new TextView(this);
            interesTextView.setText(String.format("%.2f", interesPeriodo));
            TextView amortizacionTextView = new TextView(this);
            amortizacionTextView.setText(String.format("%.2f", amortizacion));
            TextView saldoTextView = new TextView(this);
            saldoTextView.setText(String.format("%.2f", saldo));

            // Ajustar la apariencia de las celdas
            TextView[] textViews = {periodoTextView, cuotaTextView, interesTextView, amortizacionTextView, saldoTextView};
            for (TextView textView : textViews) {
                textView.setPadding(16, 8, 16, 8);
                row.addView(textView);
            }

            // Agregar la fila a la tabla
            tableLayout.addView(row);
        }
    }

        private double calcularCuotaMensual ( double importe, double tasaInteresMensual,
        int plazoMeses){
            // Calcula el factor de amortización
            double factor = Math.pow(1 + tasaInteresMensual, -plazoMeses);

            // Calcula la cuota mensual utilizando la fórmula de cuota fija de amortización
            double cuotaMensual = importe * tasaInteresMensual / (1 - factor);

            return cuotaMensual;
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
    private void generatePdf() {
        try {
            // Crear un nuevo documento PDF
            //PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new FileOutputStream(getFilesDir() + "amortizacion.pdf")));
            String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/amortizacion.pdf";
            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new FileOutputStream(filePath)));

            com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDocument);





            Table pdfTable = new Table(new float[]{2, 3, 3, 3, 3}); // Column widths

            // Agregar encabezado de la tabla
            String[] headers = {"Período", "Cuota", "Interés", "Amortización", "Saldo"};
            for (int i = 0; i < headers.length; i++) {
                pdfTable.addCell(new Cell().add(new Paragraph(headers[i])));
            }

            // Obtener la tabla de la interfaz de usuario
            TableLayout tableLayout = findViewById(R.id.tableLayoutAmortizacion);

            // Agregar filas de datos de la tabla de la interfaz de usuario a la tabla del PDF
            for (int i = 0; i < tableLayout.getChildCount(); i++) {
                TableRow row = (TableRow) tableLayout.getChildAt(i);
                for (int j = 0; j < row.getChildCount(); j++) {
                    View view = row.getChildAt(j);
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        pdfTable.addCell(new Cell().add(new Paragraph(textView.getText().toString())));
                    }
                }
            }

            // Agregar la tabla al documento PDF
            document.add(pdfTable);


            // Cerrar el documento
            document.close();

            // Notificar al usuario que el PDF se ha generado y guardado correctamente
            Toast.makeText(this, "PDF generado y guardado correctamente", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar cualquier excepción de IO
            Toast.makeText(this, "Error al generar el PDF", Toast.LENGTH_SHORT).show();
        }
    }



    private void sendEmail() {
        try {
            // Ruta del archivo PDF generado
            String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/amortizacion.pdf";

            // Crear un Intent con la acción ACTION_SEND
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("application/pdf");

            // Agregar el archivo PDF como un adjunto
            File file = new File(filePath);
            Uri uri = FileProvider.getUriForFile(this, "financiapp.fileprovider", file);
            emailIntent.putExtra(Intent.EXTRA_STREAM, uri);

            // Agregar la dirección de correo electrónico predeterminada (opcional)
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"josemr1979@gmail.com"});

            // Iniciar la actividad de correo electrónico
            startActivity(Intent.createChooser(emailIntent, "Enviar correo electrónico"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al enviar correo electrónico", Toast.LENGTH_SHORT).show();
        }
    }


}