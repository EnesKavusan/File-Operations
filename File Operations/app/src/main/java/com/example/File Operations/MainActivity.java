package com.example.dosyaslemleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText kadi,sifre;
    Button giris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kadi = findViewById(R.id.editTextTextPersonName);
        sifre = findViewById(R.id.editTextTextPassword);
        giris = findViewById(R.id.button);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((kadi.getText().toString().equals("kavusan")) && (sifre.getText().toString().equals("12345"))){
                    kadi.setText("");
                    sifre.setText("");

                    Intent giris = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(giris);

                }else{
                    Toast.makeText(MainActivity.this, "Kullanıcı adı ve şifre yanlış!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}