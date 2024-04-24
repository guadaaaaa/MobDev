package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnChanger);
        btnChanger.setBackgroundColor(Color.RED);
        btnChanger.setText("Change Me!");
        btnChanger.getBackground().setAlpha(255);
        btnChanger.setTextColor(Color.WHITE);
        btnChanger.setTextSize(20);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_exercise,menu);

        return true;
    }
    final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final Paint p = new Paint();
    Random color;
    Random nums = new Random();
    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        if(item.getItemId() == R.id.mItemChange){
            Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.mChangeBg){
            color = new Random();
            p.setARGB(255,color.nextInt(255),color.nextInt(255),color.nextInt(255));
            btnChanger.setBackgroundColor((p.getColor()));
        } else if(item.getItemId() == R.id.mChangeVisibility){
            int visibility = nums.nextInt(255);
            btnChanger.getBackground().setAlpha(visibility);
        } else if(item.getItemId() == R.id.mChangeText){
            int letters = nums.nextInt(alphabet.length());
            String value = String.valueOf(alphabet.charAt(letters));
            btnChanger.setText(value);
        } else if(item.getItemId() == R.id.mChangeFontSize){
            int num = nums.nextInt(45-28)+28;
            btnChanger.setTextSize(num);
        } else if(item.getItemId() == R.id.mChangeTxtColor){
            color = new Random();
            p.setARGB(255,color.nextInt(255),color.nextInt(255),color.nextInt(255));
            btnChanger.setTextColor((p.getColor()));
        }
        else if(item.getItemId() == R.id.mItemReset){
            btnChanger.setBackgroundColor(Color.RED);
            btnChanger.setText("Change Me!");
            btnChanger.getBackground().setAlpha(255);
            btnChanger.setTextColor(Color.WHITE);
            btnChanger.setTextSize(20);
            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.mItemExit){
            finish();
        }

        return true;
    }

}