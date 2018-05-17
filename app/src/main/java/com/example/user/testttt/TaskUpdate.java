package com.example.user.testttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TaskUpdate extends AppCompatActivity {


    static String sCourse;
    static int sID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_update);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,R.array.position,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Course");
        spinner.setAdapter(adapter);

        EditText name = findViewById(R.id.editText2);
        EditText year = findViewById(R.id.editText);

        Bundle b = getIntent().getExtras();
        name.setText(b.getString("sName"));
        year.setText(b.getString("sYear"));
        sCourse = b.getString("sCourse");
        sID = b.getInt("sID");
        spinner.setSelection(getIndex(spinner,sCourse));
    }

    public int getIndex(Spinner spinner, String Mystring){
        int index = 0;
        for (int i = 0; i < spinner.getCount(); i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(Mystring)){
                index = i;
                break;
            }
        }
        return index;
    }
    public void Back(View v) {
        Intent i = new Intent(TaskUpdate.this, viewTask.class);
        startActivity(i);
    }

    public void updateStudent(View v){
        EditText eName = findViewById(R.id.editText2);
        EditText eYear = findViewById(R.id.editText);
        Spinner eSpin = findViewById(R.id.spinner);

        DATABASE db = new DATABASE(this);
    db.UpdateStudent(sID,eYear.getText().toString(),eName.getText().toString(),eSpin.getSelectedItem().toString());

    Intent i = new Intent(TaskUpdate.this,viewTask.class);
    startActivity(i);
        Toast.makeText(getApplicationContext(), "Task  Updated Successfully", Toast.LENGTH_SHORT).show();
    }
}
