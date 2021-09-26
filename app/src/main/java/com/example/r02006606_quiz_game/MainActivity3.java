package com.example.r02006606_quiz_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Pulling intent information from previous activity screen
        Intent q1Intent = getIntent();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}