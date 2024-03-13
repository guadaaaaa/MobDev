package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

    public class CalculatorExercise extends AppCompatActivity{

        Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
        Button btnPlus, btnMinus, btnMultiplication, btnDivide, btnEquals;
        Button btnC, btnAC, btnNeg, btnPercent, btnPoint;

        TextView expression;
        TextView result;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculator_exercise);
            result = findViewById(R.id.result);
            expression = findViewById(R.id.expression);
            expression.setText("");

            btn0 = (Button)findViewById(R.id.btn0);
            btn1 = (Button)findViewById(R.id.btn1);
            btn2 = (Button)findViewById(R.id.btn2);
            btn3 = (Button)findViewById(R.id.btn3);
            btn4 = (Button)findViewById(R.id.btn4);
            btn5 = (Button)findViewById(R.id.btn5);
            btn6 = (Button)findViewById(R.id.btn6);
            btn7 = (Button)findViewById(R.id.btn7);
            btn8 = (Button)findViewById(R.id.btn8);
            btn9 = (Button)findViewById(R.id.btn9);
            btnAC = (Button) findViewById(R.id.btnAC);
            btnC = (Button) findViewById(R.id.btnC);
            btnNeg = (Button) findViewById(R.id.btnNeg);
            btnPercent = (Button) findViewById(R.id.btnPercent);
            btnPoint = (Button) findViewById(R.id.btnPoint);
            btnPlus = (Button) findViewById(R.id.btnPlus);
            btnMinus = (Button) findViewById(R.id.btnMinus);
            btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
            btnDivide = (Button) findViewById(R.id.btnDivide);
            btnEquals = (Button) findViewById(R.id.btnEquals);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("1");
                    sequential();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("2");
                    sequential();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("3");
                    sequential();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("4");
                    sequential();
                }
            });
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("5");
                    sequential();
                }
            });
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("6");
                    sequential();
                }
            });
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("7");
                    sequential();
                }
            });
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("8");
                    sequential();
                }
            });
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("9");
                    sequential();
                }
            });
            btn0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.append("0");
                    sequential();
                }
            });
            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence text = expression.getText();
                    if(text.charAt(expression.length()-1) == '+' || text.charAt(expression.length()-1) == '*' || text.charAt(expression.length()-1) == '/' || text.charAt(expression.length()-1) == '%' || text.charAt(expression.length()-1) == '-'){
                        CharSequence newText = text.subSequence(0, text.length() - 1);
                        expression.setText(newText);
                    }
                    expression.append("+");
                }
            });

            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence text = expression.getText();
                    if(text.charAt(expression.length()-1) == '+' || text.charAt(expression.length()-1) == '*' || text.charAt(expression.length()-1) == '/' || text.charAt(expression.length()-1) == '%' || text.charAt(expression.length()-1) == '-'){
                        CharSequence newText = text.subSequence(0, text.length() - 1);
                        expression.setText(newText);
                    }
                    expression.append("-");
                }
            });
            btnMultiplication.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence text = expression.getText();
                    if(text.charAt(expression.length()-1) == '+' || text.charAt(expression.length()-1) == '*' || text.charAt(expression.length()-1) == '/' || text.charAt(expression.length()-1) == '%' || text.charAt(expression.length()-1) == '-'){
                        CharSequence newText = text.subSequence(0, text.length() - 1);
                        expression.setText(newText);
                    }
                    expression.append("*");
                }
            });
            btnDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence text = expression.getText();
                    if(text.charAt(expression.length()-1) == '+' || text.charAt(expression.length()-1) == '*' || text.charAt(expression.length()-1) == '/' || text.charAt(expression.length()-1) == '%' || text.charAt(expression.length()-1) == '-'){
                        CharSequence newText = text.subSequence(0, text.length() - 1);
                        expression.setText(newText);
                    }
                    expression.append("/");
                }
            });

            btnEquals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence text = expression.getText();
                    MathCalc mc = new MathCalc(expression.getText().toString());
                    result.setText(mc.SolveMdas().toString());
                }
            });

            btnPoint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence text = expression.getText();
                    if(text.charAt(expression.length()-1) == '.'){
                        CharSequence newText = text.subSequence(0, text.length() - 1);
                        expression.setText(newText);
                    }
                    expression.append(".");
                }
            });
            btnAC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    expression.setText("");
                    result.setText("0");
                }
            });
            btnC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CharSequence currentText = expression.getText();
                    if(currentText.length() > 0){
                        CharSequence newText = currentText.subSequence(0, currentText.length() - 1);
                        expression.setText(newText);
                    }
                }
            });

        }

        public void sequential(){
            MathCalc calc = new MathCalc(expression.getText().toString());
            if(expression.getText().length() > 1){
                result.setText(calc.solveSeq().toString());
            }
        }

    }