package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    private TextView ms_co;
    private Button call;
    private Button mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ms_co =  findViewById(R.id.msg_co);
        call =findViewById(R.id.call);
        mail =findViewById(R.id.mail);
        String adr ="alabenmaamer56@gmail.com";
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0752632168"));
                startActivity(intent);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,adr);
                intent.setType("message/rfc822");
                startActivity(intent);

            }
        });

        String imc = getIntent().getStringExtra("imc");
        String txt1 ="Limiter sa consommation de sucres et de sel ; Consommer des fruits et des légumes quotidiennement ; Augmenter la consommation de calcium chez les enfants ; Suivre régulièrement l'évolution de la courbe de poids des enfants et des adolescents est un moyen de prévention contre l'obésité.";
        String txt2="Limiter sa consommation de sucres et de sel ; Consommer des fruits et des légumes quotidiennement . ";
        float imcValue = Float.parseFloat(imc);
        if (imcValue == 1){
            ms_co.setText(txt2);

        } else if (imcValue == 2) {
            ms_co.setText(txt1);


        }



    }
}