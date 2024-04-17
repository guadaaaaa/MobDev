package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Space;
import android.widget.Spinner;

public class PassingIntentsExercise extends AppCompatActivity {

    Button btnSubmit, btnClear;
    EditText txtFName, txtLName, txtBdate, txtPhone, txtemail, txtAddress, txtNationality;
    RadioButton radbtnMale, radbtnFemale, radbtnOthers;
    RadioButton radbtn1, radbtn2, radbtn3, radbtn4;
    Spinner SpCourses, spStatus;

    private final String[] courses = {"","BSCS", "BSIT"};
    private final String[] status = {"","Single", "Married", "Separated"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
        txtFName = (EditText) findViewById(R.id.txtFName);
        txtLName = (EditText) findViewById(R.id.txtLName);
        txtBdate = (EditText) findViewById(R.id.txtBdate);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtAddress = (EditText) findViewById(R.id.txtAddress);
        radbtnMale = (RadioButton)findViewById(R.id.radbtnMale);
        radbtnFemale = (RadioButton)findViewById(R.id.radbtnFemale);
        radbtnOthers = (RadioButton)findViewById(R.id.radbtnOthers);
        radbtn1 = (RadioButton) findViewById(R.id.radbtn1);
        radbtn2 = (RadioButton) findViewById(R.id.radbtn2);
        radbtn3 = (RadioButton) findViewById(R.id.radbtn3);
        radbtn4 = (RadioButton) findViewById(R.id.radbtn4);
        txtNationality = (EditText) findViewById(R.id.txtNationality);

        spStatus = (Spinner) findViewById(R.id.spStatus);
        ArrayAdapter Status = new ArrayAdapter(this, android.R.layout.simple_spinner_item, status);
        Status.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStatus.setAdapter(Status);

        SpCourses = (Spinner) findViewById(R.id.SpCourses);
        ArrayAdapter Courses = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);
        Courses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpCourses.setAdapter(Courses);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtFName.setText("");
                txtLName.setText("");
                txtBdate.setText("");
                txtAddress.setText("");
                txtemail.setText("");
                txtPhone.setText("");
                radbtnMale.setChecked(false);
                radbtnFemale.setChecked(false);
                radbtnOthers.setChecked(false);
                radbtn1.setChecked(false);
                radbtn2.setChecked(false);
                radbtn3.setChecked(false);
                radbtn4.setChecked(false);
                SpCourses.setSelection(0);
                spStatus.setSelection(0);
                txtNationality.setText("");
            }
        });
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = txtFName.getText().toString();
                String lname = txtLName.getText().toString();
                String gender;
                if(radbtnMale.isChecked())
                    gender = "Male";
                else if(radbtnFemale.isChecked())
                    gender = "Female";
                else if(radbtnOthers.isChecked())
                    gender = "Others";
                else
                    gender = "Unknown";

                String bdate = txtBdate.getText().toString();
                String phone = txtPhone.getText().toString();
                String email = txtemail.getText().toString();
                String address = txtAddress.getText().toString();
                String course = SpCourses.getSelectedItem().toString();
                String status = spStatus.getSelectedItem().toString();
                String nationality = txtNationality.getText().toString();

                String level = null;
                if(radbtn1.isChecked())
                    level = "1st Year";
                else if(radbtn2.isChecked())
                    level = "2nd Year";
                else if(radbtn3.isChecked())
                    level = "3rd Year";
                else if(radbtn4.isChecked())
                    level = "4th Year";

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                intent.putExtra("txtFName", fname);         intent.putExtra("txtLName", lname);
                intent.putExtra("txtGender", gender);       intent.putExtra("txtBdate", bdate);
                intent.putExtra("txtPhone", phone);         intent.putExtra("txtemail", email);
                intent.putExtra("txtAddress", address);     intent.putExtra("txtCourse", course);
                intent.putExtra("txtLevel", level);         intent.putExtra("txtStatus", status);
                intent.putExtra("txtnationality", nationality);
                startActivity(intent);
            }
        });
    }
}