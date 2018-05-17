package com.example.user.testttt;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by User on 1/2/2018.
 */

public class EditClickListener implements View.OnClickListener {
public static String name,course,year;
static int id;

int targetID = 0;
    DATABASE database;
    Context context;

    EditClickListener(int id, DATABASE db,Context c){
        targetID = id;
        database = db;
        context = c;
    }

    @Override
    public void onClick(View v) {
        ArrayList<studs> studs = database.selectStudent();
        id = studs.get(targetID).id;
        name = studs.get(targetID).name;
        year = studs.get(targetID).year;
        course = studs.get(targetID).course;

        viewTask view1 = new viewTask();
       // view1.showButton();

        view1.year.setText("Description:" +" " + year);
        view1.name.setText("Title:" +" " + name);
        view1.mins.setText("Minutes:" +" " + course);

        view1.sYear = ""+year;
        view1.sName = name;
        view1.sCourse = course;
        view1.sID = id;

    }


}
