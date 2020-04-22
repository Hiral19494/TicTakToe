package com.example.tictaktoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //0= yellow; 1= red
    int activePlayer = 0;
    // 2 means unPlayed
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {0, 3, 6}, {1, 4, 7}, {3, 4, 5}, {6, 7, 8}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameIsActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {
        String winner = "";
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            gameState[tappedCounter] = activePlayer;

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
            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    gameIsActive = false;

                    winner = "Red Won";

                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Yellow Won";
                    }
                   winnerMessage(winner);
                }
                else {
                    boolean gameIsOver = true;
                    for (int counterState : gameState) {

                        if (counterState == 2) gameIsOver = false;

                    }

                    if(gameIsOver == true){
                        winner = " It is draw ";
                        winnerMessage(winner);

                    }
                }
            }

        }
    }

    public String winnerMessage(String stringMsg){
        Toast.makeText(getBaseContext(), stringMsg, Toast.LENGTH_LONG).show();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.playAgainLayout);
        linearLayout.setVisibility(View.VISIBLE);
        return null;
    }
}
