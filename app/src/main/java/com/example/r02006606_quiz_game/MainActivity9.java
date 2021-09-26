package com.example.r02006606_quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity9 extends AppCompatActivity {

    TextView score;
    RadioGroup rg;
    RadioButton choice;
    int total, counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        //Pulling intent information from previous activity screen
        Intent q9Intent = getIntent();

        //Updating score with previous total
        score = findViewById(R.id.score);
        score.setText("" + q9Intent.getIntExtra("SCORE", 0));
        total = Integer.parseInt(score.getText().toString());
        counter = q9Intent.getIntExtra("TALLY", 0);

        //Initializing Widgets
        rg = findViewById(R.id.radioGrp);
        TextView score = findViewById(R.id.score);

        //Add button activity when clicked
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
            //Get the id of option selected
            int radioId = rg.getCheckedRadioButtonId();
            choice = findViewById(radioId);

            //If the choice matches correct answer
            if (choice.getText().equals("Dallol Region, Ethiopia")) {
                //Increase score points
                total += 2500;
                score.setText("" + total);
                counter++;

                //Output correct Toast message
                Toast msg = Toast.makeText(MainActivity9.this, "CORRECT!\nYou earned $2500", Toast.LENGTH_LONG);
                //setGravity used to adjust Toast location
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();

            } else {
                Toast msg = Toast.makeText(MainActivity9.this, "Sorry, this is incorrect", Toast.LENGTH_LONG);
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();
            }

            //Add score to intent for next screen
            Intent n = new Intent(this, MainActivity10.class);
            n.putExtra("SCORE", total);
            n.putExtra("TALLY", counter);
            startActivity(n);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}