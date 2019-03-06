package com.example.samuel.chessblindfold;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class game extends AppCompatActivity{

    public int previous_x = -1;
    public int previous_y = -1;
    public String message;
    public Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setContentView(R.layout.game);
                    }
                });
            }
        };

        new Thread(runnable).start();
    }
/*
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        // if the user moves the finger on the screen
        if(x != previous_x || y != previous_y) {
            previous_x = x;
            previous_y = y;
        } else {

            listenToUser();
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);

        }
        return true;
    }

    public void listenToUser() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        startActivityForResult(intent, 10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 10:

                if(resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    message = result.get(0);
                }

                break;
        }
    }*/

}
