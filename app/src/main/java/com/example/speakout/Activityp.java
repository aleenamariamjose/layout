package com.example.speakout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activityp extends AppCompatActivity {
    private Button pprobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityp);
        pprobtn=(Button) findViewById(R.id.button5);
        pprobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openuprofile();
            }
        });
    }
    public void openuprofile()
    {
        Intent intent=new Intent(this,uprofile.class);
        startActivity(intent);
    }
}
