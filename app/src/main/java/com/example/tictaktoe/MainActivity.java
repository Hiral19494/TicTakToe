package com.example.tictaktoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //0= yellow; 1= red
    int activePlayer = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow);
            counter.setTranslationY(-1000f);
            counter.animate().translationYBy(1000f).rotationBy(360).setDuration(1000);
            activePlayer = 1;
        } else {
            counter.setImageResource(R.drawable.red);
            counter.setTranslationX(-1000f);
            counter.animate().translationXBy(1000f).rotationBy(360).setDuration(1000);
            activePlayer = 0;
        }

    }
}
