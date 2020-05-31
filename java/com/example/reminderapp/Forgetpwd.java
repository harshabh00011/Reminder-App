package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forgetpwd extends AppCompatActivity {
    private Button newpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        newpwd = (Button) findViewById(R.id.newpwd);
        newpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity2();
            }

            private void openactivity2() {
                Intent i=new Intent(Forgetpwd.this,activityy2.class);
                startActivity(i);
            }
            });
        }
}
