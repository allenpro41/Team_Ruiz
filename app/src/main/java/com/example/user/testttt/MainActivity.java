package com.example.user.testttt;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChart mPieChart = (PieChart) findViewById(R.id.piestart);


        mPieChart.addPieSlice(new PieModel("", 5, Color.parseColor("#FE6DA8")));
        mPieChart.addPieSlice(new PieModel("", 2, Color.parseColor("#56B7F1")));


    }
    public void addstuds(View v){
        Intent i = new Intent(MainActivity.this, AddTask.class);
        startActivity(i);
    }
    public void viewstuds(View v){
        Intent i = new Intent(MainActivity.this, viewTask.class);
        startActivity(i);
    }
    public void gotostat(View v){
        Intent i = new Intent(MainActivity.this, Stats.class);
        startActivity(i);
    }
    public void gotoabout(View v){
        Intent i = new Intent(MainActivity.this, about.class);
        startActivity(i);
    }

}
