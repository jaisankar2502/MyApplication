package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Task extends AppCompatActivity {
    TextView tasktextview;
    Button taskButton;
    EditText tastEdittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        tasktextview= findViewById(R.id.taskTv);
        taskButton= findViewById(R.id.taskbutton);
        taskButton.setVisibility(View.INVISIBLE);
        //Declare timer
        CountDownTimer cTimer = new CountDownTimer(30000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
               tasktextview .setText("Tell me About Yourself?  Time:"  + millisUntilFinished / 1000);



                //here you can have your logic to set text to edittext
            }

            @SuppressLint("SetTextI18n")
            public void onFinish() {
                tasktextview.setText("done!");
                taskButton.setVisibility(View.VISIBLE);
            }

        }.start();

        taskButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                tastEdittext= findViewById(R.id.taskEd);
                String text= tastEdittext.getText().toString();
                if(text.isEmpty()){
                    tastEdittext.setError(" please fill the field!!!");


                }
                else{
                    cTimer.onFinish();
                    tasktextview.setText("done!");
                    Toast.makeText(getApplicationContext(),"Submit successfuly",Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(getApplicationContext(),Home.class));
                finish();

            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Home.class));
        finish();
    }
}