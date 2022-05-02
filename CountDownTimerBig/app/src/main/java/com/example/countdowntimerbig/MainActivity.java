package com.example.countdowntimerbig;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textTime;
    ImageButton btnStartAndPause;
    ImageButton btnStop;
    Button btnN1;
    Button btnN2;
    Button btnN5;
    Button btnN10;
    Button btnN15;
    Button btnN20;
    Button btnN25;
    Button btnN30;
    Button btnN35;
    Button btnN40;
    Button btnN45;
    Button btnN50;
    Button btnN55;
    Button btnN1Hour;

    private HorizontalScrollView scrollView;
    private CountDownTimer countDownTimer;
    private Animation animation;

    private long timeInMilliseconds;
    private boolean isPause = true;
    private boolean bigText = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initialization();
        setOnClickListener();
    }

    private void initialization() {

        scrollView = findViewById(R.id.scrollView);
        textTime = findViewById(R.id.textTime);
        btnStartAndPause = findViewById(R.id.btnStartAndPause);
        btnStop = findViewById(R.id.btnStop);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim);

        btnN1 = findViewById(R.id.btnN1);
        btnN2 = findViewById(R.id.btnN2);
        btnN5 = findViewById(R.id.btnN5);
        btnN10 = findViewById(R.id.btnN10);
        btnN15 = findViewById(R.id.btnN15);
        btnN20 = findViewById(R.id.btnN20);
        btnN25 = findViewById(R.id.btnN25);
        btnN25 = findViewById(R.id.btnN25);
        btnN25 = findViewById(R.id.btnN25);
        btnN30 = findViewById(R.id.btnN30);
        btnN35 = findViewById(R.id.btnN35);
        btnN40 = findViewById(R.id.btnN40);
        btnN45 = findViewById(R.id.btnN45);
        btnN50 = findViewById(R.id.btnN50);
        btnN55 = findViewById(R.id.btnN55);
        btnN1Hour = findViewById(R.id.btnN1hour);
    }

    private void setOnClickListener() {

        btnStartAndPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        btnN1.setOnClickListener(this);
        btnN2.setOnClickListener(this);
        btnN5.setOnClickListener(this);
        btnN10.setOnClickListener(this);
        btnN15.setOnClickListener(this);
        btnN20.setOnClickListener(this);
        btnN25.setOnClickListener(this);
        btnN30.setOnClickListener(this);
        btnN35.setOnClickListener(this);
        btnN40.setOnClickListener(this);
        btnN45.setOnClickListener(this);
        btnN50.setOnClickListener(this);
        btnN55.setOnClickListener(this);
        btnN1Hour.setOnClickListener(this);
        textTime.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnStartAndPause:
                if (isPause) {
                    startAndPauseTimer();
                } else {
                    pauseTime();
                }
                break;
            case R.id.btnStop:
                stopTime();
                break;
            //---------
            case R.id.btnN1:
                timeInMilliseconds = ConstantData.ONE_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN2:
                timeInMilliseconds = ConstantData.TWO_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN5:
                timeInMilliseconds = ConstantData.FIVE_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN10:
                timeInMilliseconds = ConstantData.TEN_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN15:
                timeInMilliseconds = ConstantData.FIFTEEN_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN20:
                timeInMilliseconds = ConstantData.TWENTY_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN25:
                timeInMilliseconds = ConstantData.TWENTY_FIVE_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN30:
                timeInMilliseconds = ConstantData.THIRTY_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN35:
                timeInMilliseconds = ConstantData.THIRTY_FIVE_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN40:
                timeInMilliseconds = ConstantData.FORTY_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN45:
                timeInMilliseconds = ConstantData.FORTY_FIVE_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN50:
                timeInMilliseconds = ConstantData.FIFTY_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN55:
                timeInMilliseconds = ConstantData.FIFTY_FIVE_MINUTE;
                updateTimeText();
                break;
            case R.id.btnN1hour:
                timeInMilliseconds = ConstantData.ONE_HOUR;
                updateTimeText();
                break;
            case R.id.textTime:
                if (bigText) {
                    textTime.startAnimation(animation);
                    bigText = false;
                    ViewGroup.LayoutParams params = textTime.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    textTime.setLayoutParams(params);
                    textTime.setTextSize(300.0f);
                } else {
                    textTime.startAnimation(animation);
                    ViewGroup.LayoutParams params = textTime.getLayoutParams();
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    textTime.setLayoutParams(params);
                    textTime.setTextSize(200.0f);
                    bigText = true;
                }
                break;
        }
    }

    private void startAndPauseTimer() {

        countDownTimer = new CountDownTimer(timeInMilliseconds, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                timeInMilliseconds = l;
                btnStartAndPause.setImageResource(R.drawable.pause);
                isPause = false;
                scrollView.setVisibility(View.INVISIBLE);
                updateTimeText();
            }

            @Override
            public void onFinish() {
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(500);
                stopTime();
            }
        }.start();
    }

    @SuppressLint("SetTextI18n")
    private void pauseTime() {
        countDownTimer.cancel();
        isPause = true;
        btnStartAndPause.setImageResource(R.drawable.start);
        updateTimeText();
    }

    private void stopTime() {
        try {
            countDownTimer.cancel();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        timeInMilliseconds = 0;
        textTime.setText("00:00");
        btnStartAndPause.setImageResource(R.drawable.start);
        scrollView.startAnimation(animation);
        scrollView.setVisibility(View.VISIBLE);
    }

    private void updateTimeText() {
        int minute = (int) (timeInMilliseconds / 1000) / 60;
        int second = (int) (timeInMilliseconds / 1000) % 60;

        String formatText = String.format(Locale.getDefault(), "%02d:%02d", minute, second);
        textTime.setText(formatText);
    }
}