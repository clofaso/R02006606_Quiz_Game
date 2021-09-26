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

public class MainActivity5 extends AppCompatActivity {

    TextView score;
    RadioGroup rg;
    RadioButton choice;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        //Pulling intent information from previous activity screen
        Intent q5Intent = getIntent();

        //Updating score with previous total
        score = findViewById(R.id.score);
        score.setText("" + q5Intent.getIntExtra("SCORE", 0));
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
            if (choice.getText().equals("Neptune")) {
                //Increase score points
                total += 500;
                score.setText("" + total);

                //Output correct Toast message
                Toast msg = Toast.makeText(MainActivity5.this, "CORRECT!\nYou earned $500", Toast.LENGTH_LONG);
                //setGravity used to adjust Toast location
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();

            } else {
                Toast msg = Toast.makeText(MainActivity5.this, "Sorry, this is incorrect", Toast.LENGTH_LONG);
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();
            }

            //Add score to intent for next screen
            Intent n = new Intent(this, MainActivity6.class);
            n.putExtra("SCORE", total);
            startActivity(n);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}