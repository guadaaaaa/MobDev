package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MatchActivity extends AppCompatActivity {

    int colors[] = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    static final int red = 0, blue = 1, green = 2, yellow = 3;
    Button btn[][];
    Button btnRestart;
    ArrayList<Integer> rowArr = new ArrayList<>();
    ArrayList<Integer> colArr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        start();
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });
    }

    public void start(){
        btn = new Button[5][5];
        for(int row= 0; row < 5; row++){
            for(int col= 0; col <5; col++){
                String resIDname = "btn"+row+col;
                btn[row][col] = findViewById(this.getResources().getIdentifier(resIDname,"id", this.getPackageName()));
            }
        }

        for(int row = 0; row<5; row++){
            for(int col = 0; col<5; col++){
                int random = new Random().nextInt(colors.length);
                btn[row][col].setBackgroundColor(colors[random]);
                if(random == 0){
                    btn[row][col].setTag("Red");
                } else if(random == 1){
                    btn[row][col].setTag("Blue");
                } else if(random == 2){
                    btn[row][col].setTag("Green");
                } else if(random == 3){
                    btn[row][col].setTag("Yellow");
                }
            }
        }

        game();
    }

    public void game(){
        ArrayList bttn = new ArrayList<>();
        for(int row= 0; row < 5; row++){
            for(int col= 0; col <5; col++){
                int finalRow = row;
                int finalCol = col;
                btn[row][col].setOnClickListener(e -> {
                    if(rowArr.size() < 2){
                        rowArr.add(finalRow);
                        colArr.add(finalCol);
                    }
                    if(rowArr.size() == 2){
                        swap();
                    }
                });
            }
        }
    }

    public void swap(){
        int row1 = rowArr.get(0), col1 = colArr.get(0);
        int row2 = rowArr.get(1), col2 = colArr.get(1);
        String tag1 = btn[row1][col1].getTag().toString();
        String tag2 = btn[row2][col2].getTag().toString();

        if((row1+1) == row2 || (Math.abs(row1-1)) == row2 || (col1+1) == col2 || (Math.abs(col2-1) == col2)){
            if(btn[row1][col1].getTag().toString().equals("Red")){
                if(btn[row2][col2].getTag().toString().equals("Red")){
                    btn[row1][col1].setBackgroundColor(colors[red]);
                    btn[row1][col1].setTag("Red");
                    btn[row2][col2].setBackgroundColor(colors[red]);
                    btn[row2][col2].setTag("Red");
                } else if(btn[row2][col2].getTag().toString().equals("Blue")){
                    btn[row1][col1].setBackgroundColor(colors[blue]);
                    btn[row1][col1].setTag("Blue");
                    btn[row2][col2].setBackgroundColor(colors[red]);
                    btn[row2][col2].setTag("Red");
                } else if(btn[row2][col2].getTag().toString().equals("Green")){
                    btn[row1][col1].setBackgroundColor(colors[green]);
                    btn[row1][col1].setTag("Green");
                    btn[row2][col2].setBackgroundColor(colors[red]);
                    btn[row2][col2].setTag("Red");
                } else if(btn[row2][col2].getTag().toString().equals("Yellow")){
                    btn[row1][col1].setBackgroundColor(colors[yellow]);
                    btn[row1][col1].setTag("Yellow");
                    btn[row2][col2].setBackgroundColor(colors[red]);
                    btn[row2][col2].setTag("Red");
                }
            } else if(btn[row1][col1].getTag().toString().equals("Blue")){
                if(btn[row2][col2].getTag().toString().equals("Red")){
                    btn[row1][col1].setBackgroundColor(colors[red]);
                    btn[row1][col1].setTag("Red");
                    btn[row2][col2].setBackgroundColor(colors[blue]);
                    btn[row2][col2].setTag("Blue");
                } else if(btn[row2][col2].getTag().toString().equals("Blue")){
                    btn[row1][col1].setBackgroundColor(colors[blue]);
                    btn[row1][col1].setTag("Blue");
                    btn[row2][col2].setBackgroundColor(colors[blue]);
                    btn[row2][col2].setTag("Blue");
                } else if(btn[row2][col2].getTag().toString().equals("Green")){
                    btn[row1][col1].setBackgroundColor(colors[green]);
                    btn[row1][col1].setTag("Green");
                    btn[row2][col2].setBackgroundColor(colors[blue]);
                    btn[row2][col2].setTag("Blue");
                } else if(btn[row2][col2].getTag().toString().equals("Yellow")){
                    btn[row1][col1].setBackgroundColor(colors[yellow]);
                    btn[row1][col1].setTag("Yellow");
                    btn[row2][col2].setBackgroundColor(colors[blue]);
                    btn[row2][col2].setTag("Blue");
                }
            } else if(btn[row1][col1].getTag().toString().equals("Green")){
                if(btn[row2][col2].getTag().toString().equals("Red")){
                    btn[row1][col1].setBackgroundColor(colors[red]);
                    btn[row1][col1].setTag("Red");
                    btn[row2][col2].setBackgroundColor(colors[green]);
                    btn[row2][col2].setTag("Green");
                } else if(btn[row2][col2].getTag().toString().equals("Blue")){
                    btn[row1][col1].setBackgroundColor(colors[blue]);
                    btn[row1][col1].setTag("Blue");
                    btn[row2][col2].setBackgroundColor(colors[green]);
                    btn[row2][col2].setTag("Green");
                } else if(btn[row2][col2].getTag().toString().equals("Green")){
                    btn[row1][col1].setBackgroundColor(colors[green]);
                    btn[row1][col1].setTag("Green");
                    btn[row2][col2].setBackgroundColor(colors[green]);
                    btn[row2][col2].setTag("Green");
                } else if(btn[row2][col2].getTag().toString().equals("Yellow")){
                    btn[row1][col1].setBackgroundColor(colors[yellow]);
                    btn[row1][col1].setTag("Yellow");
                    btn[row2][col2].setBackgroundColor(colors[green]);
                    btn[row2][col2].setTag("Green");
                }
            } else if(btn[row1][col1].getTag().toString().equals("Yellow")){
                if(btn[row2][col2].getTag().toString().equals("Red")){
                    btn[row1][col1].setBackgroundColor(colors[red]);
                    btn[row1][col1].setTag("Red");
                    btn[row2][col2].setBackgroundColor(colors[yellow]);
                    btn[row2][col2].setTag("Yellow");
                } else if(btn[row2][col2].getTag().toString().equals("Blue")){
                    btn[row1][col1].setBackgroundColor(colors[blue]);
                    btn[row1][col1].setTag("Blue");
                    btn[row2][col2].setBackgroundColor(colors[yellow]);
                    btn[row2][col2].setTag("Yellow");
                } else if(btn[row2][col2].getTag().toString().equals("Green")){
                    btn[row1][col1].setBackgroundColor(colors[green]);
                    btn[row1][col1].setTag("Green");
                    btn[row2][col2].setBackgroundColor(colors[yellow]);
                    btn[row2][col2].setTag("Yellow");
                } else if(btn[row2][col2].getTag().toString().equals("Yellow")){
                    btn[row1][col1].setBackgroundColor(colors[yellow]);
                    btn[row1][col1].setTag("Yellow");
                    btn[row2][col2].setBackgroundColor(colors[yellow]);
                    btn[row2][col2].setTag("Yellow");
                }
            }
        } else {
            rowArr.clear();
            colArr.clear();
        }
        rowArr.clear();
        colArr.clear();
    }
}