package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    private EditText nom;
    private EditText poid;
    private EditText taille;
    private Button open;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nom = (EditText) findViewById(R.id.nom);
        poid =  findViewById(R.id.poid);
        taille = findViewById(R.id.taille);
        open = findViewById(R.id.open);

        open.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String poidStr = poid.getText().toString();
                String tailleStr = taille.getText().toString();
                String nomStr = nom.getText().toString();
                Intent play = new Intent(MainActivity2.this, MainActivity3.class);
                play.putExtra("nomstr", nomStr);
                play.putExtra("poidstr", poidStr);
                play.putExtra("taillestr", tailleStr);

                startActivity(play);
            }


        });
    }
}

