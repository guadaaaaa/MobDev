package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLayout;
    Button btnButton;
    Button btnCalc;
    Button btnMatch;
    Button btnPass;
    Button btnMenu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLayout= (Button)findViewById(R.id.btnLayout);
        btnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, LayoutExercise.class);
                startActivity(intent1);
            }
        });

        btnButton= (Button)findViewById(R.id.btnButton);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ButtonExercise.class);
                startActivity(intent2);
            }
        });

        btnCalc= (Button)findViewById(R.id.btnCalculator);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, CalculatorExercise.class);
                startActivity(intent3);
            }
        });

        btnMatch = (Button)findViewById(R.id.btnMatch);
        btnMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, MatchActivity.class);
                startActivity(intent4);
            }
        });

        btnPass = (Button) findViewById(R.id.btnPass);
        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this, PassingIntentsExercise.class);
                startActivity(intent5);
            }
        });

        btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(MainActivity.this, MenuExercise.class);
                startActivity(intent6);
            }
        });
    }
}