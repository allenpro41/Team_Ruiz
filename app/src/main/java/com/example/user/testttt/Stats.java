package com.example.user.testttt;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class Stats extends AppCompatActivity {
        TextView txtworkinterval,txtskiptask,txtfinish;
        private int snowDensity;
    private int asw;
    private int ye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);




        txtworkinterval = findViewById(R.id.txtWorksInterval);
        txtskiptask = findViewById(R.id.txtskip);
        txtfinish = findViewById(R.id.txtfinsih);
        // Bundle data = getIntent().getExtras();
        //getinterval = data.getInt( "yey");


        //retrieve INTERVAL
        SharedPreferences settings = getSharedPreferences("YOUR_PREF_NAME", 0);
         snowDensity = settings.getInt("SNOW_DENSITY", 0);

        txtworkinterval.setText(String.valueOf(snowDensity));


        //save INTERVAL
        SharedPreferences set = getSharedPreferences("yes", 0);
        SharedPreferences.Editor edit = set.edit();
        edit.putInt("get",snowDensity);
        edit.commit();


        //retrieve SKIPPED TASK

        SharedPreferences settingz = getSharedPreferences("me", 0);
         asw = settingz.getInt("you", 0);
       //   Toast.makeText(getApplicationContext(),"wew"+asw, Toast.LENGTH_SHORT).show();
        txtskiptask.setText(String.valueOf(asw));

        //save skipped task
        SharedPreferences sets = getSharedPreferences("yess", 0);
        SharedPreferences.Editor edits = sets.edit();
        edits.putInt("gets",asw);
        edits.commit();

        //ret finish
        SharedPreferences settingsss = getSharedPreferences("mees", 0);
         ye = settingsss.getInt("youus", 0);
        txtfinish.setText(String.valueOf(ye));

        //save finish
        SharedPreferences settingx = getSharedPreferences("yep", 0);
        SharedPreferences.Editor editorr = settingx.edit();
        editorr.putInt("yeps",ye);
        editorr.commit();

        mPieChart.addPieSlice(new PieModel("Work Interval", snowDensity, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("Skipped Task", asw, Color.parseColor("#56B7F1")));
        mPieChart.addPieSlice(new PieModel("Finished Task", ye, Color.parseColor("#CDA67F")));

        mPieChart.startAnimation();
        // Toast.makeText(getApplicationContext(),"yes", Toast.LENGTH_SHORT).show();
       // txtworkinterval.setText(z);

    }
}
