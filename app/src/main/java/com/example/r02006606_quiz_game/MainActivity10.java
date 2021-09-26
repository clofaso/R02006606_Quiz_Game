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

public class MainActivity10 extends AppCompatActivity {

    TextView score;
    RadioGroup rg;
    RadioButton choice;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        //Pulling intent information from previous activity screen
        Intent q10Intent = getIntent();

        //Updating score with previous total
        score = findViewById(R.id.score);
        score.setText("" + q10Intent.getIntExtra("SCORE", 0));
        total = Integer.parseInt(score.getText().toString());

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
            if (choice.getText().equals("Alexander Fleming")) {
                //Increase score points
                total += 3000;
                score.setText("" + total);

                //Output correct Toast message
                Toast msg = Toast.makeText(MainActivity10.this, "CORRECT!\nYou earned $3000", Toast.LENGTH_LONG);
                //setGravity used to adjust Toast location
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();

            } else {
                Toast msg = Toast.makeText(MainActivity10.this, "Sorry, this is incorrect", Toast.LENGTH_LONG);
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();
            }

            //Add score to intent for next screen
            Intent n = new Intent(this, FinalStats.class);
            n.putExtra("SCORE", total);
            startActivity(n);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}