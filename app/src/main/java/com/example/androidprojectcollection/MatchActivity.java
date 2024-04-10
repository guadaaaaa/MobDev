package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MatchActivity extends AppCompatActivity {
    int[] colors = {R.drawable.redcandy, R.drawable.bluecandy, R.drawable.purplecandy, R.drawable.orangecandy};
    static final int red = 0, blue = 1, purple= 2, orange = 3;
    ImageButton[][] btn;
    Button btnRestart;
    int[][] btnColors = new int[5][5];
    ArrayList<Integer> rowArr = new ArrayList<>();
    ArrayList<Integer> colArr = new ArrayList<>();
    TextView tvScore;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        start();
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=0;
                tvScore.setText(String.valueOf(score));
                start();
            }
        });
    }

    public void start(){
        btn = new ImageButton[5][5];
        rowArr.clear();
        colArr.clear();
        for(int row= 0; row < 5; row++){
            for(int col= 0; col <5; col++){
                String resIDname = "btn"+row+col;
                btn[row][col] = findViewById(this.getResources().getIdentifier(resIDname,"id", this.getPackageName()));
            }
        }

        for(int row = 0; row<5; row++){
            for(int col = 0; col<5; col++){
                int random = new Random().nextInt(colors.length);
                if(random == 0){
                    btnColors[row][col] = red;
                } else if(random == 1){
                    btnColors[row][col] = blue;
                } else if(random == 2){
                    btnColors[row][col] = purple;
                } else if(random == 3){
                    btnColors[row][col] = orange;
                }
            }
        }
        game();
    }

    public void game(){
        check();
        tvScore.setText("0");
        changeColor();
        for(int row= 0; row < 5; row++){
            for(int col= 0; col <5; col++){
                int finalRow = row;
                int finalCol = col;
                btn[row][col].setOnClickListener(e -> {
                    if(rowArr.size() < 2){
                        rowArr.add(finalRow);
                        colArr.add(finalCol);
                        System.out.println("Size: "+ rowArr.size());
                        String rowValue = rowArr.get(0).toString();
                        String colValue = colArr.get(0).toString();
                        String colorValue = String.valueOf(btnColors[Integer.parseInt(rowValue)][Integer.parseInt(colValue)]);
                        check();
                    }
                    if(rowArr.size() == 2){
                        swap();
                        rowArr.clear();
                        colArr.clear();
                    }
                });
            }
        }
    }

    public void swap(){
        int row1 = rowArr.get(0), col1 = colArr.get(0);
        int row2 = rowArr.get(1), col2 = colArr.get(1);

        if((row1+1) == row2 || (Math.abs(row1-1)) == row2 || (col1+1) == col2 || (Math.abs(col1-1) == col2)){
            if(btnColors[row1][col1] == red){
                if(btnColors[row2][col2] == red){
                    btn[row1][col1].setBackgroundColor(colors[red]);
                    btnColors[row1][col1] = red;
                    btn[row2][col2].setBackgroundColor(colors[red]);
                    btnColors[row2][col2] = red;
                } else if(btnColors[row2][col2] == blue){
                    btn[row1][col1].setBackgroundColor(colors[blue]);
                    btnColors[row1][col1] = blue;
                    btn[row2][col2].setBackgroundColor(colors[red]);
                    btnColors[row2][col2] = red;
                } else if(btnColors[row2][col2] == purple){
                    btn[row1][col1].setBackgroundColor(colors[purple]);
                    btnColors[row1][col1] = purple;
                    btn[row2][col2].setBackgroundColor(colors[red]);
                    btnColors[row2][col2] = red;
                } else if(btnColors[row2][col2] == orange){
                    btn[row1][col1].setBackgroundColor(colors[orange]);
                    btnColors[row1][col1] = orange;
                    btn[row2][col2].setBackgroundColor(colors[red]);
                    btnColors[row2][col2] = red;
                }
            } else if(btnColors[row1][col1] == blue){
                if(btnColors[row2][col2] == red){
                    btn[row1][col1].setBackgroundColor(colors[red]);
                    btnColors[row1][col1] = red;
                    btn[row2][col2].setBackgroundColor(colors[blue]);
                    btnColors[row2][col2] = blue;
                } else if(btnColors[row2][col2] == blue){
                    btn[row1][col1].setBackgroundColor(colors[blue]);
                    btnColors[row1][col1] = blue;
                    btn[row2][col2].setBackgroundColor(colors[blue]);
                    btnColors[row2][col2] = blue;
                } else if(btnColors[row2][col2] == purple){
                    btn[row1][col1].setBackgroundColor(colors[purple]);
                    btnColors[row1][col1] = purple;
                    btn[row2][col2].setBackgroundColor(colors[blue]);
                    btnColors[row2][col2] = blue;
                } else if(btnColors[row2][col2] == orange){
                    btn[row1][col1].setBackgroundColor(colors[orange]);
                    btnColors[row1][col1] = orange;
                    btn[row2][col2].setBackgroundColor(colors[blue]);
                    btnColors[row2][col2] = blue;
                }
            } else if(btnColors[row1][col1] == purple){
                if(btnColors[row2][col2] == red){
                    btn[row1][col1].setBackgroundColor(colors[red]);
                    btnColors[row1][col1] = red;
                    btn[row2][col2].setBackgroundColor(colors[purple]);
                    btnColors[row2][col2] = purple;
                } else if(btnColors[row2][col2] == blue){
                    btn[row1][col1].setBackgroundColor(colors[blue]);
                    btnColors[row1][col1] = blue;
                    btn[row2][col2].setBackgroundColor(colors[purple]);
                    btnColors[row2][col2] = purple;
                } else if(btnColors[row2][col2] == purple){
                    btn[row1][col1].setBackgroundColor(colors[purple]);
                    btnColors[row1][col1] = purple;
                    btn[row2][col2].setBackgroundColor(colors[purple]);
                    btnColors[row2][col2] = purple;
                } else if(btnColors[row2][col2] == orange){
                    btn[row1][col1].setBackgroundColor(colors[orange]);
                    btnColors[row1][col1] = orange;
                    btn[row2][col2].setBackgroundColor(colors[purple]);
                    btnColors[row2][col2] = purple;
                }
            } else if(btnColors[row1][col1] == orange){
                if(btnColors[row2][col2] == red){
                    btn[row1][col1].setBackgroundColor(colors[red]);
                    btnColors[row1][col1] = red;
                    btn[row2][col2].setBackgroundColor(colors[orange]);
                    btnColors[row2][col2] = orange;
                } else if(btnColors[row2][col2] == blue){
                    btn[row1][col1].setBackgroundColor(colors[blue]);
                    btnColors[row1][col1] = blue;
                    btn[row2][col2].setBackgroundColor(colors[orange]);
                    btnColors[row2][col2] = orange;
                } else if(btnColors[row2][col2] == purple){
                    btn[row1][col1].setBackgroundColor(colors[purple]);
                    btnColors[row1][col1] = purple;
                    btn[row2][col2].setBackgroundColor(colors[orange]);
                    btnColors[row2][col2] = orange;
                } else if(btnColors[row2][col2] == orange){
                    btn[row1][col1].setBackgroundColor(colors[orange]);
                    btnColors[row1][col1] = orange;
                    btn[row2][col2].setBackgroundColor(colors[orange]);
                    btnColors[row2][col2] = orange;
                }
            }
            rowArr.clear();
            colArr.clear();
        }
        check();
    }

    private void check() {
        tvScore = (TextView) findViewById(R.id.tvScore);
        for(int row=0;row<5;row++){
            for(int col=0;col<3;col++){
                if(btnColors[row][col] == btnColors[row][col+1] && btnColors[row][col] == btnColors[row][col+2]){
                    score++;
                    btnColors[row][col] = new Random().nextInt(colors.length);
                    btnColors[row][col+1] = new Random().nextInt(colors.length);
                    btnColors[row][col+2] = new Random().nextInt(colors.length);
                    changeColor();
                    tvScore.setText(String.valueOf(score));
                }
            }

        }
        for(int row=0;row<3;row++){
            for(int col=0;col<5;col++){
                if(btnColors[row][col] == btnColors[row+1][col] && btnColors[row][col] == btnColors[row+2][col]){
                    score++;
                    btnColors[row][col] = new Random().nextInt(colors.length);
                    btnColors[row+1][col] = new Random().nextInt(colors.length);
                    btnColors[row+2][col] = new Random().nextInt(colors.length);
                    changeColor();
                    tvScore.setText(String.valueOf(score));
                }
            }
        }
    }
    public void changeColor(){
        for(int row=0;row<5;row++){
            for(int col=0;col<5;col++){
                int color = btnColors[row][col];
                btn[row][col].setBackgroundResource(colors[color]);
            }
        }
    }

}