package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Success extends AppCompatActivity {

    ImageButton academics, geektalks, mygang, thriftit, tutorpoint, infom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        academics = (ImageButton) findViewById(R.id.academics);
        geektalks = (ImageButton) findViewById(R.id.geektalks);
        mygang    = (ImageButton) findViewById(R.id.mygang);
        thriftit  = (ImageButton) findViewById(R.id.thriftit);
        tutorpoint= (ImageButton) findViewById(R.id.tutorpoint);
        infom = (ImageButton) findViewById(R.id.infobtn);

        academics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), academics.class));

            }
        });
        geektalks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), geek.class));

            }
        });

        mygang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), gang.class));

            }
        });

        tutorpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), tutor.class));

            }
        });

        infom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),home.class));
            }
        });

        thriftit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),thrift.class));
            }
        });

    }


}