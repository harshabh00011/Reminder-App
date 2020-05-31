package com.example.reminderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity3 extends AppCompatActivity {


    private Button proceed;
    private EditText Email;
    private EditText Password;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        firebaseAuth= FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null)
        {
            //profile activity here
//            finish();
  //          startActivity(new Intent(getApplicationContext(),Activity4.class));
        }

        proceed = (Button) findViewById(R.id.proceed);
        Email = (EditText)findViewById(R.id.email1);
        Password=(EditText)findViewById(R.id.password1);
        progressDialog=new ProgressDialog(Activity3.this);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registeruser();
                Intent i = new Intent(Activity3.this, activityy2.class);
                startActivity(i);
            }
        });
    }
    public void onclick(View view){
        View button3 = null;
        if(view == button3){
            registeruser();
        }

    }
    private void registeruser(){
        String email= Email.getText().toString().trim();
        String password=Password.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please Enter email", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;

        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please Enter password", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;


        }
        //if validations are ok
        //we will first show the progress bar
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Activity3.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {

                    finish();
                    startActivity(new Intent(getApplicationContext(), Activity4.class));

                    //user is successfully registered and logged in
                    //we will start the profile activity here
                    Toast.makeText(Activity3.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    Toast.makeText(Activity3.this,"Could not register",Toast.LENGTH_SHORT).show();
                }
            };

        });}

}
