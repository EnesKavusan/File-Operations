package com.example.dosyaslemleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    EditText not;
    Button yeninot,listele;
    ArrayList<String > array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        not = findViewById(R.id.editTextTextPersonName2);
        yeninot = findViewById(R.id.button2);
        listele = findViewById(R.id.button3);

        yeninot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FileOutputStream yenidosya = null;
                try {
                    yenidosya = openFileOutput("Notlar.txt", Context.MODE_APPEND);

                    String yeni = not.getText().toString()+"\n";
                    yenidosya.write(yeni.getBytes());

                    Toast.makeText(MainActivity2.this, "path="+getFilesDir(), Toast.LENGTH_SHORT).show();
                    yenidosya.close();

                }catch (FileNotFoundException e){
                    e.printStackTrace();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String tumnotlar="";
                    FileInputStream dosyaoku = openFileInput("Notlar.txt");
                    int size = dosyaoku.available();
                    byte[] tumu = new byte[size];
                    dosyaoku.read(tumu);
                    dosyaoku.close();

                    tumnotlar = new String(tumu);
                    array = new ArrayList<String>(Arrays.asList(tumnotlar.split("\n")));

                }catch (IOException e){
                    e.printStackTrace();

                }finally {

                    Intent liste = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(liste);
                }
            }
        });
    }
}