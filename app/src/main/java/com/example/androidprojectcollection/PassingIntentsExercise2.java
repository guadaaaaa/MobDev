package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    TextView txtP2Fname, txtP2Lname, txtP2Gender, txtP2Address, txtP2Phone, txtP2Email, txtP2Bdate, txtP2Course, txtP2level, txtP2status, txtP2Nationality;
    Button btnP2return;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        txtP2Fname = (TextView) findViewById(R.id.txtP2Fname);
        txtP2Lname = (TextView) findViewById(R.id.txtP2Lname);
        txtP2Gender = (TextView) findViewById(R.id.txtP2Gender);
        txtP2Address = (TextView) findViewById(R.id.txtP2Address);
        txtP2Bdate = (TextView) findViewById(R.id.txtP2Bdate);
        txtP2Phone = (TextView) findViewById(R.id.txtP2PhoneNum);
        txtP2Email = (TextView) findViewById(R.id.txtP2Email);
        txtP2Course = (TextView) findViewById(R.id.txtP2Course);
        txtP2level = (TextView) findViewById(R.id.txtP2level);
        txtP2status = (TextView) findViewById(R.id.txtP2Status);
        txtP2Nationality = (TextView) findViewById(R.id.txtP2Nationality);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("txtFName");
        String lname = intent.getStringExtra("txtLName");
        String gender = intent.getStringExtra("txtGender");
        String bdate = intent.getStringExtra("txtBdate");
        String phone = intent.getStringExtra("txtPhone");
        String email = intent.getStringExtra("txtemail");
        String address = intent.getStringExtra("txtAddress");
        String course = intent.getStringExtra("txtCourse");
        String level = intent.getStringExtra("txtLevel");
        String status = intent.getStringExtra("txtStatus");
        String nationality = intent.getStringExtra("txtnationality");

        txtP2Fname.setText(fname);
        txtP2Lname.setText(lname);
        txtP2Address.setText(address);
        txtP2Gender.setText(gender);
        txtP2Phone.setText(phone);
        txtP2Bdate.setText(bdate);
        txtP2Email.setText(email);
        txtP2Course.setText(course);
        txtP2level.setText(level);
        txtP2status.setText(status);
        txtP2Nationality.setText(nationality);

        btnP2return = (Button) findViewById(R.id.btnP2Return);
        btnP2return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}