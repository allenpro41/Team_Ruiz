package com.example.user.testttt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class about extends AppCompatActivity {
    Button btnabout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        btnabout = findViewById(R.id.btnabout);

    }
    public void viewabout (View v){
        Toast.makeText(getApplicationContext(),"No Updates Found", Toast.LENGTH_LONG).show();
    }
}
