package com.example.user.testttt;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewTask extends AppCompatActivity {
    String fivemin = "05:00", tenmin = "10:00", fifteenmin = "15:00", twentymin = "20:00", twentyfivemin = "25:00",
            thirtymin = "30:00", thirtyfivemin = "35:00", fortymin = "40:00", fortyfivemin = "45:00", fiftymin = "50:00",fiftyfivemin = "55:00",sixtymin = "60:00";
    private long fiveminutes = 10000;
    //private long fiveminutes = 300000;
    private long tenminutes = 600000;

    private long fifteenminutes = 900000;
    private long twentyminutes = 1200000;

    private long twentyfiveminutes = 1500000;
    private long thirtyminutes = 1800000;

    private long thirtyfiveminutes = 2100000;
    private long fortyminutes = 2400000;

    private long fortyfiveminutes = 2700000;
    private long fiftyminutes = 3000000;

    private long firtyfiveminutes = 3300000;
    private long sixtyminutes = 3600000;
    public static int finish = 1;
    LinearLayout layout;
    DATABASE DATABASE;
    static TextView name,year,mins;
    static Button btnUpdate,btnDelete,btnUpdates;
    static String getmins;
    static String sCourse,sName,sYear;
    static int sID;
    static TextView getyear,getname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        DATABASE = new DATABASE(this);

            getdata();



        btnUpdates = findViewById(R.id.button7);
        btnUpdate = findViewById(R.id.button5);
        btnDelete = findViewById(R.id.button6);
        year = findViewById(R.id.textView6);
        name = findViewById(R.id.textView7);
        mins = findViewById(R.id.textView8);


       // year.setVisibility(View.INVISIBLE);
        name.setVisibility(View.INVISIBLE);
        mins.setVisibility(View.INVISIBLE);


    }
/*
    public static void hideButton(){
        btnUpdate.setVisibility(View.INVISIBLE);
        btnDelete.setVisibility(View.INVISIBLE);
        btnUpdates.setVisibility(View.INVISIBLE);

    }
    public static void showButton(){
        btnUpdate.setVisibility(View.VISIBLE);
        btnDelete.setVisibility(View.VISIBLE);
        btnUpdates.setVisibility(View.VISIBLE);
    }
*/

    public void getdata(){

        layout = (LinearLayout) findViewById(R.id.linearLayout);
        layout.invalidate();
        layout.removeAllViewsInLayout();
        ArrayList<studs> staff = DATABASE.selectStudent();

        for (int i = 0; i < staff.size(); i++) {
            Button b = new Button(getApplicationContext());
            b.setText("" + staff.get(i).name);
            layout.addView(b);
            b.setOnClickListener(new EditClickListener(i,DATABASE,getApplicationContext()));
        b.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        try {

        CharSequence[] items = {"Start Task","Update","Finished"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(viewTask.this);
        dialog.setTitle("Choose an action");
        dialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {


                if (item == 0) {
                    Startyeah();


                } else if (item == 1) {
                    Intent i = new Intent(viewTask.this, TaskUpdate.class);
                    i.putExtra("sName", sName);
                    i.putExtra("sCourse", sCourse);
                    i.putExtra("sYear", sYear);
                    i.putExtra("sID", sID);
                    startActivity(i);

                } else {
                    //ret
                    SharedPreferences settingsss = getSharedPreferences("yep", 0);
                    int snowDensity = settingsss.getInt("yeps", 0);
                    int holds = snowDensity + finish;

                    //save
                    SharedPreferences settingx = getSharedPreferences("mees", 0);
                    SharedPreferences.Editor editorr = settingx.edit();
                    editorr.putInt("youus",holds);
                    editorr.commit();





                    Toast.makeText(getApplicationContext(), "Task is Finished"+holds, Toast.LENGTH_SHORT).show();

                    DATABASE database = new DATABASE(viewTask.this);
                    database.DeleteStudent(sID);
                    //  hideButton();
                    getdata();

                }
            }

        });
        dialog.show();


        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
        }

        return true;
    }
});
        }
    }

public void Startyeah(){
        try {


    String getmins = EditClickListener.course.toString();
    //
    if( fivemin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",fiveminutes);

        startActivity(i);
        Toast.makeText(getApplicationContext(), "START TASK IS 5mins", Toast.LENGTH_SHORT).show();
    }
    else if (tenmin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",tenminutes);
        startActivity(i);
    }
    else if (fifteenmin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",fifteenminutes);
        startActivity(i);
    }
    else if (twentymin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",twentyminutes);
        startActivity(i);
    }
    else if (twentyfivemin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",twentyfiveminutes);
        startActivity(i);
    }
    else if (thirtymin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",thirtyminutes);
        startActivity(i);
    }
    else if (thirtyfivemin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",thirtyfiveminutes);
        startActivity(i);
    }
    else if (fortymin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",fortyminutes);
        startActivity(i);
    }
    else if (fortyfivemin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",fortyfiveminutes);
        startActivity(i);
    }
    else if (fiftymin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",fiftyminutes);
        startActivity(i);
    }
    else if (fiftyfivemin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",firtyfiveminutes);
        startActivity(i);
    }
    else if (sixtymin.equals(getmins)){
        Intent i = new Intent(viewTask.this,StartTask.class);
        i.putExtra("yehey",sixtyminutes);
        startActivity(i);
    }


        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Please Select a Task" , Toast.LENGTH_SHORT).show();
        }
} // long press start

    public void StartsTask(){
        String getmins = EditClickListener.course.toString();
        //  Toast.makeText(getApplicationContext(), getmins , Toast.LENGTH_SHORT).show();
        if( fivemin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",fiveminutes);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "START TASK IS 5mins", Toast.LENGTH_SHORT).show();
        }
        else if (tenmin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",tenminutes);
            startActivity(i);
        }
        else if (fifteenmin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",fifteenminutes);
            startActivity(i);
        }
        else if (twentymin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",twentyminutes);
            startActivity(i);
        }
        else if (twentyfivemin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",twentyfiveminutes);
            startActivity(i);
        }
        else if (thirtymin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",thirtyminutes);
            startActivity(i);
        }
        else if (thirtyfivemin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",thirtyfiveminutes);
            startActivity(i);
        }
        else if (fortymin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",fortyminutes);
            startActivity(i);
        }
        else if (fortyfivemin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",fortyfiveminutes);
            startActivity(i);
        }
        else if (fiftymin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",fiftyminutes);
            startActivity(i);
        }
        else if (fiftyfivemin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",firtyfiveminutes);
            startActivity(i);
        }
        else if (sixtymin.equals(getmins)){
            Intent i = new Intent(viewTask.this,StartTask.class);
            i.putExtra("yehey",sixtyminutes);
            startActivity(i);
        }

    }


      public void studUpdate(View v){ // update
      Intent i = new Intent(viewTask.this, TaskUpdate.class);
      i.putExtra("sName", sName);
      i.putExtra("sCourse",sCourse);
      i.putExtra("sYear",sYear);
      i.putExtra("sID", sID);
      startActivity(i);

    }

    public void studDelete(View v){
        DATABASE database  = new DATABASE(this);
        database.DeleteStudent(sID);
   //     hideButton();
        getdata();
        Toast.makeText(getApplicationContext(), "Student  Deleted Successfully", Toast.LENGTH_SHORT).show();
    }
}