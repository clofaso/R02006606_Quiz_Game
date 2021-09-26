package com.example.r02006606_quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton choice;
    int total = 0;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            if(choice.getText().equals("40")){
                //Increase score points
                total += 100;
                score.setText(""+total);
                counter++;

                //Output correct Toast message
                Toast msg = Toast.makeText(MainActivity.this, "CORRECT!\nYou earned $100", Toast.LENGTH_LONG);
                //setGravity used to adjust Toast location
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();
            }
            else{
                Toast msg = Toast.makeText(MainActivity.this, "Sorry, this is incorrect", Toast.LENGTH_LONG);
                msg.setGravity(Gravity.CENTER, 0, 700);
                msg.show();
            }

            //Add score to intent for next screen
            Intent n = new Intent(this, MainActivity2.class);
            n.putExtra("SCORE", total);
            n.putExtra("TALLY", counter);
            startActivity(n);
        });
    }

    public void selection(View view) {
        int radioId = rg.getCheckedRadioButtonId();
        choice = findViewById(radioId);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}