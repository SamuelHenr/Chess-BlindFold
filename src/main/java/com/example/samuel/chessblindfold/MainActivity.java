
package com.example.samuel.chessblindfold;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    public TextView user_text;
    public int previous_x = -1;
    public int previous_y = -1;
    public TextToSpeech t;
    private Button main_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_text = findViewById(R.id.text);
        main_button = findViewById(R.id.button);

        t = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t.setLanguage(new Locale(Locale.getDefault().getLanguage()));
                }
            }
        });

        Toast.makeText(getApplicationContext(), "Touch the screen", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int move = event.getAction();

        switch(move) {
            case MotionEvent.ACTION_UP:

                Intent intent = new Intent(MainActivity.this, game.class);
                startActivity(intent);

                break;
        }

        return true;
    }

    public void reply(String speech) {

        t.speak(speech, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onPause() {
        super.onPause();

        if(t != null) {
            t.stop();
            t.shutdown();
        }

    }
}
