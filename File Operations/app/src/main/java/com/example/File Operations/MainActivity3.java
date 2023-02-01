package com.example.dosyaslemleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ListView lv;
    ArrayList<String> tumnotlar = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lv = findViewById(R.id.lview);

        tumnotlar = (ArrayList<String>) getIntent().getSerializableExtra("listv");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,tumnotlar);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                tumnotlar.remove(i);
                adapter.notifyDataSetChanged();

                FileOutputStream yenidosya = null;

                try {
                    yenidosya = openFileOutput("Notlar.txt", Context.MODE_PRIVATE);
                    for (int k=0;k<tumnotlar.size();k++){
                        String yeni = tumnotlar.get(k)+"\n";
                        yenidosya.write(yeni.getBytes());
                    }
                    yenidosya.close();

                }catch (FileNotFoundException e){
                    e.printStackTrace();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}