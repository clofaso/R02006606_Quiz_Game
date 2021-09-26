package com.example.r02006606_quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView score;
    RadioGroup rg;
    RadioButton choice;
    int total, counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Pulling intent information from previous activity screen
        Intent q1Intent = getIntent();

        //Updating score with previous total
        score = findViewById(R.id.score);
        score.setText("" + q1Intent.getIntExtra("SCORE", 0));
        total = Integer.parseInt(score.getText().toString());
        counter = q1Intent.getIntExtra("TALLY", 0);

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
            if (choice.getText().equals("77")) {
                //Increase score points
                total += 100;
                score.setText("" + total);
                counter++;

                //Output correct Toast message
                Toast msg = Toast.makeText(MainActivity2.this, "CORRECT!\nYou earned $100", Toast.LENGTH_LONG);
                //setGravity used to adjust Toast location
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();

            } else {
                Toast msg = Toast.makeText(MainActivity2.this, "Sorry, this is incorrect", Toast.LENGTH_LONG);
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();
            }

            //Add score to intent for next screen
            Intent n = new Intent(this, MainActivity3.class);
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