package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity5 extends AppCompatActivity implements View.OnClickListener {
    private Button location;
    private FirebaseAuth firebaseAuth;
    private EditText addtask;
    private EditText taskid;
    private EditText place;
    private EditText taskdetails;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            startActivity(new Intent(this,Activity6.class));

        }

        FirebaseUser user= firebaseAuth.getCurrentUser();

        location = (Button) findViewById(R.id.proceed);
        addtask=(EditText) findViewById(R.id.addtask);
        taskid=(EditText) findViewById(R.id.taskid);
        place=(EditText) findViewById(R.id.place);
        taskdetails=(EditText) findViewById(R.id.taskdetails);

    }

    public void move(View view) { Intent i = new Intent(Activity5.this, MapsActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {

    }
}
