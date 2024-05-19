package com.example.financiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    Button buttonRegister;
    EditText editTextemail, editTextpass;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    private String email = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        getSupportActionBar().setTitle("Financiapp by Jose Martín");
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.background_action_bar));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        buttonRegister = findViewById(R.id.buttonRegister);
        editTextemail = findViewById(R.id.editTextTextEmailAddress);
        editTextpass = findViewById(R.id.editTextTextPassword);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = editTextemail.getText().toString();
                password = editTextpass.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {

                    if (password.length() >= 6) {
                        registerUser();
                    } else {
                        Toast.makeText(RegistroActivity.this, "El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(RegistroActivity.this, "Completar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void registerUser () {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Map<String, Object> map = new HashMap<>();
                    map.put( "email", email);
                    map.put( "password", password);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {

                            if(task2.isSuccessful()){

                                startActivity(new Intent(RegistroActivity.this, MainActivityNew.class));
                                finish();

                            }else{
                                Toast.makeText(RegistroActivity.this, "No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }else{
                    Toast.makeText(RegistroActivity.this, "El usuario no pudo registrarse", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
