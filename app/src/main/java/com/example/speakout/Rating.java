package com.example.speakout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating extends AppCompatActivity {
    RatingBar ratingBar;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ratingBar =(RatingBar) findViewById(R.id.ratingBar);
        button = (Button) findViewById(R.id.button);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged( RatingBar ratingBar, float v, boolean fromUser ) {
                Toast.makeText(Rating.this, "Stars: " + (int)v ,Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                Toast.makeText(Rating.this, "Stars: " + (int)ratingBar.getRating(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
