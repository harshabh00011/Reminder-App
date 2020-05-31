package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4 extends AppCompatActivity {
    private Button add_task;
    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        add_task = (Button) findViewById(R.id.add_task);
        add_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity5();
            }

            private void openActivity5() {
                Intent i=new Intent(Activity4.this,Activity5.class);
                startActivity(i);

            }
        });

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity2();
            }

            private void openactivity2() {
                Intent i = new Intent(Activity4.this,activityy2.class);
                startActivity(i);
            }
        });

    }

    public void openActivity3() {
        Intent intent=new Intent(this,Activity3.class);
        startActivity(intent);
    }
    public void openActivity4() {
        Intent intent=new Intent(this,Activity4.class);
        startActivity(intent);
    }
}