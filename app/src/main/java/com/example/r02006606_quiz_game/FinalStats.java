package com.example.r02006606_quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FinalStats extends AppCompatActivity {

    TextView score;
    RadioGroup rg;
    RadioButton choice;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_stats);

        //Pulling intent information from previous activity screen
        Intent finalIntent = getIntent();

        score = findViewById(R.id.score);
        score.setText("" + finalIntent.getIntExtra("SCORE", 0));
        total = Integer.parseInt(score.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}