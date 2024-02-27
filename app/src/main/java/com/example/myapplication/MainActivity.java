package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView textView, seekText;
    private SeekBar seekBar;

    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBarId);
        textView = findViewById(R.id.textId);

        seekBar = findViewById(R.id.seekbarId);
        seekText = findViewById(R.id.seektextId);

        nextButton = findViewById(R.id.nextButtonId);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textView.setText("Rating: "+ratingBar.getRating());
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekText.setText("Volume: "+seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "On Start", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "On Stop", Toast.LENGTH_SHORT).show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                startActivity(intent);

            }
        });
    }
}