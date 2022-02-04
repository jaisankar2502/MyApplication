package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class Verify extends AppCompatActivity {
    private String verificationId;
    Button verify;
    EditText otpGiven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        verificationId = getIntent().getStringExtra("verificationId");
         verify=findViewById(R.id.verifyBtn);
         otpGiven=findViewById(R.id.id_otp);
         verify.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String otp=otpGiven.getText().toString().trim();
                 if(otp.isEmpty()){
                     Toast.makeText(Verify.this,"Enter OTP", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     if (verificationId != null) {
                         PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId,otp);
                         FirebaseAuth
                                 .getInstance()
                                 .signInWithCredential(credential)
                                 .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                     @Override
                                     public void onComplete(@NonNull Task<AuthResult> task) {
                                         if(task.isSuccessful()){
                                             Toast.makeText(Verify.this, "Welcome...", Toast.LENGTH_SHORT).show();
                                             Intent intent = new Intent(Verify.this, Home.class);
                                             intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                             startActivity(intent);
                                         }
                                         else{
                                             Toast.makeText(Verify.this, "OTP is not Valid!", Toast.LENGTH_SHORT).show();

                                         }




                                     }
                                 });



                     }

                 }


             }
         });

    }
}