package com.example.r02006606_quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FinalStats extends AppCompatActivity {

    TextView score, tally;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_stats);

        //Pulling intent information from previous activity screen
        Intent finalIntent = getIntent();

        //Setting final total pulling score with intent
        score = findViewById(R.id.score);
        score.setText("" + finalIntent.getIntExtra("SCORE", 0));
        total = Integer.parseInt(score.getText().toString());

        //Setting tally of correct questions by pulling counter with intent
        tally = findViewById(R.id.tally);
        tally.setText("" +finalIntent.getIntExtra("TALLY", 0) + " out of 10");

        //Add button activity when clicked
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
            //Switch back to question 1
            Intent n = new Intent(this, MainActivity.class);
            startActivity(n);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}