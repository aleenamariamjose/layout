package com.example.speakout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


public class Activityu extends AppCompatActivity {
    private Button uprobtn, ratingbtn, abtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityu);
        abtn=(Button) findViewById(R.id.askbtn);
        abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openwifidirect();
            }
        });


        uprobtn = (Button) findViewById(R.id.proid);
        uprobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openuprofile();
            }
        });
        ratingbtn = (Button) findViewById(R.id.rbtn);
        ratingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRating();
            }
        });
    }
    public void openwifidirect(){
        Intent intent=new Intent(this,wifidirect1.class);
        startActivity(intent);
    }

    public void openuprofile() {
        Intent intent = new Intent(this, pprofile.class);
        startActivity(intent);
    }

    public void openRating() {
        Intent intent = new Intent(this, Rating.class);
        startActivity(intent);
    }




}

