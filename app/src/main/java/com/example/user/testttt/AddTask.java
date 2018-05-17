package com.example.user.testttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {


    DATABASE DATABASE;
    EditText year,name;
    Spinner SpinPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        DATABASE = new DATABASE(this);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
          this,R.array.position,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Minutes");
        spinner.setAdapter(adapter);


    };

    public void insertStudent(View v){


            EditText year = (EditText)findViewById(R.id.editText);
            EditText name = (EditText) findViewById(R.id.editText2);
            Spinner course = (Spinner)findViewById(R.id.spinner);
            Button btnAdd = (Button)findViewById(R.id.button3);


        DATABASE.AddStudent(year.getText().toString(), name.getText().toString(), course.getSelectedItem().toString());

        name.setText("");
        name.setHint("Name");
        year.setText("");
        year.setHint("Year");
//"+name+"
        Toast.makeText(getApplicationContext(), "Task  Added Successfully", Toast.LENGTH_SHORT).show();
    }

    public void Back(View v){
        Intent i = new Intent(AddTask.this, MainActivity.class);
        startActivity(i);
    }
}
