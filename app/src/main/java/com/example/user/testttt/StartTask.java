package com.example.user.testttt;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.Locale;


public class StartTask extends AppCompatActivity{


    private Context mContext;
    private Activity mActivity;


    private TextView mTextViewCountDown ;
    private Button mButtonStartPause;
    private CountDownTimer mCountDownTimer;
    ProgressBar progressBar;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis ;
    private long mEndTime;
    int num1 = 0;
    int num2=1;
    public static int skip = 1;
    public static int sum = 1;
    long ye;
    PieChart SPieChart;

    TextView  getyear,getname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_task);
        try {

            getyear = findViewById(R.id.textView11);
            getname = findViewById(R.id.textView12);
            getyear.setText(viewTask.year.getText());
            getname.setText(viewTask.name.getText());
         SPieChart = (PieChart) findViewById(R.id.piestart);



        mContext = getApplicationContext();
        mActivity = StartTask.this;

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        Bundle data = getIntent().getExtras();
        mTimeLeftInMillis = data.getLong( "yehey");
        mTextViewCountDown.setText(String.valueOf(mTimeLeftInMillis));
        ye =mTimeLeftInMillis ;

        }catch (Exception e){
            Intent i = new Intent(StartTask.this, MainActivity.class);
            startActivity(i);
        }

        //SPieChart.addPieSlice(new PieModel("Finished Task", mEndTime, Color.parseColor("#56B7F1")));


        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        updateCountDownText();
        }


    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
                SPieChart.clearChart();
                SPieChart.addPieSlice(new PieModel("", millisUntilFinished, Color.parseColor("#CDA67F")));
                SPieChart.addPieSlice(new PieModel("",ye , Color.parseColor("#56B7F1")));

                if (mTimerRunning = false){
                   // Toast.makeText(getApplicationContext(), "notif", Toast.LENGTH_SHORT).show();

                }

                {

                  notificationnotyet();
                }

                //SPieChart.startAnimation();

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;


                SPieChart.addPieSlice(new PieModel("",ye , Color.parseColor("#56B7F1")));
                SPieChart.startAnimation();
                notification();



                ring();

//ret
                SharedPreferences settingss = getSharedPreferences("yes", 0);
                int snowDensity = settingss.getInt("get", 0);
                int hold = snowDensity + sum;

//save
                SharedPreferences settings = getSharedPreferences("YOUR_PREF_NAME", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("SNOW_DENSITY",hold);
                editor.commit();


                Toast.makeText(getApplicationContext(), "Task Successfully Finished", Toast.LENGTH_SHORT).show();
                updateButtons();
                Intent i = new Intent(StartTask.this, MainActivity.class);
                //i.putExtra("yey", sum);
                startActivity(i);



                }

        }.start();

        mTimerRunning = true;

        updateButtons();

    }

    private void pauseTimer() {

        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateButtons();

    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void updateButtons() {
        if (mTimerRunning) {

            mButtonStartPause.setText("Skip");
            confirmation();
        } else {


          //  txtworkinterval.setText("1");
            mButtonStartPause.setText("Start");



            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("millisLeft", mTimeLeftInMillis);
        outState.putBoolean("timerRunning", mTimerRunning);
        outState.putLong("endTime", mEndTime);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mTimeLeftInMillis = savedInstanceState.getLong("millisLeft");
        mTimerRunning = savedInstanceState.getBoolean("timerRunning");
        updateCountDownText();
        updateButtons();

        if (mTimerRunning) {
            mEndTime = savedInstanceState.getLong("endTime");
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
            startTimer();
        }}

    public void confirmation() {
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder AlertDlg = new AlertDialog.Builder(StartTask.this);
                AlertDlg.setMessage("Are you sure you want to skip this Task?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                        pauseTimer();


                        //ret
                        SharedPreferences settingss = getSharedPreferences("yess", 0);
                        int snowDensity = settingss.getInt("gets", 0);
                        int holds = snowDensity + skip;



                        //save
                        SharedPreferences settings = getSharedPreferences("me", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putInt("you",holds);
                        editor.commit();


                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert = AlertDlg.create();
                alert.setTitle("MOTIVATE ME");
                alert.show();


            }
        });


         }
         private void notification(){
             NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
             .setSmallIcon(android.R.drawable.stat_notify_more)
                     .setContentTitle("The Task Time is already finished")
                     .setContentText("");

             Intent notificationIntent = new Intent(this,StartTask.class);
             PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
             builder.setContentIntent(contentIntent);

             NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
             manager.notify(0,builder.build());


         }
    private void notificationnotyet(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.stat_notify_more)
                .setContentTitle("Your Task is running")
                .setContentText("");

        Intent notificationIntent = new Intent(this,StartTask.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());


    }
         private void ring(){

             MediaPlayer player = MediaPlayer.create(this,R.raw.rings);
             player.start();

            // Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
             //Ringtone ringtone = RingtoneManager.getRingtone(mContext,uri);
             //ringtone.play();
         }



}//YES OR NO confirmation

