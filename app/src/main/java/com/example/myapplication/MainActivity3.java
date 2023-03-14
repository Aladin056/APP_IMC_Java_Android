package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView res;
    private TextView msg;
    private Button con;
    private float imc;
    private String imcStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        res = (TextView) findViewById(R.id.res);
        msg = (TextView) findViewById(R.id.msg);
        con =  (Button)  findViewById(R.id.cons);


        String nom = getIntent().getStringExtra("nomstr");
        String poid = getIntent().getStringExtra("poidstr");
        String taille = getIntent().getStringExtra("taillestr");
        String nm ="Bonjour "+nom;
        msg.setText(nm);
        if (poid != null && !"".equals(poid)
                && taille != null && !"".equals(taille)) {

            float poidValue = Float.parseFloat(poid);
            float tailleValue = Float.parseFloat(taille)/100;

            imc = poidValue / (tailleValue * tailleValue);
            displayimc(imc);
        }
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(MainActivity3.this, MainActivity4.class);
                play.putExtra("imc",imcStr);
                startActivity(play);
            }
        });
    }


    private void displayimc(float imc) {

        String imclabel = "";
        ImageView imageView = findViewById(R.id.imageView);

        if (Float.compare(imc, 15f) <= 0) {
            imclabel = "maigreur";
            imageView.setImageResource(R.drawable.p1);
            imcStr ="1";
        } else if (Float.compare(imc, 18.5f) > 0 && Float.compare(imc, 25f) <= 0) {
            imclabel = "normal";
            imageView.setImageResource(R.drawable.p2);
            imcStr ="1";


        } else if (Float.compare(imc, 25f) > 0 && Float.compare(imc, 30f) <= 0) {
            imclabel = "surpoid";
            imageView.setImageResource(R.drawable.p3);
            imcStr ="2";


        } else if (Float.compare(imc, 30f) > 0 && Float.compare(imc, 35f) <= 0) {
            imclabel = "obèse niveau 1";
            imageView.setImageResource(R.drawable.p4);
            imcStr ="2";


        } else if (Float.compare(imc, 35f) > 0 && Float.compare(imc, 40f) <= 0) {
            imclabel = "obèse niveau 2";
            imageView.setImageResource(R.drawable.p4);
            imcStr ="2";


        } else if (Float.compare(imc, 40f) > 0 && Float.compare(imc, 42f) <= 0) {
            imclabel = "obèse niveau 3";
            imageView.setImageResource(R.drawable.p4);
            imcStr ="2";


        }

        imclabel = imc + "\n\n" + imclabel;
        res.setText(imclabel);
    }

    }
