package com.halasfilip.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OneVOneGameActivity extends AppCompatActivity implements View.OnClickListener {

    private static int pointsX = 0;
    private static int pointsO = 0;
    private boolean playerXTurn = true;
    private int roundCount = 0;

    //row1
    private Button button11;
    private Button button12;
    private Button button13;
    //row2
    private Button button21;
    private Button button22;
    private Button button23;
    //row3
    private Button button31;
    private Button button32;
    private Button button33;

    private TextView scoreX;
    private TextView scoreO;
    private TextView turnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        scoreX = findViewById(R.id.textX);
        scoreO = findViewById(R.id.textY);
        turnText = findViewById(R.id.turnText);

        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        //row2
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        //row3
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);

        //row1
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        //row2
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button23.setOnClickListener(this);
        //row3
        button31.setOnClickListener(this);
        button32.setOnClickListener(this);
        button33.setOnClickListener(this);

        turnText.setText("Turn Player X");
        updatePointsText();
        resetButtons();


        Button resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneVOneGameActivity.this, FistActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (playerXTurn) {
            clickX((Button) v);
            checkWinX();

        } else {
            clickO((Button) v);
            checkWinY();

        }
        if (checkWinX()) {
            playerXWinner();
        } else if (checkWinY()) {
            playerOWinner();
        } else if (roundCount == 9) {
            draw();
        }

    }

    //done
    private void resetButtons() {
        //row1
        clickReset(button11);
        clickReset(button12);
        clickReset(button13);
        //row2
        clickReset(button21);
        clickReset(button22);
        clickReset(button23);
        //row3
        clickReset(button31);
        clickReset(button32);
        clickReset(button33);
        playerXTurn = true;
        roundCount = 0;


    }

    //done
    private void resetGame() {
        pointsX = 0;
        pointsO = 0;

        resetButtons();
        updatePointsText();
    }

    //done
    private boolean checkWinX() {
        //line1
        if (button11.getText() == "X" && button12.getText() == "X" && button13.getText() == "X") {
            return true;
        }
        //line2
        if (button21.getText() == "X" && button22.getText() == "X" && button23.getText() == "X") {
            return true;
        }
        //line3
        if (button31.getText() == "X" && button32.getText() == "X" && button33.getText() == "X") {
            return true;
        }
        //column1
        if (button11.getText() == "X" && button21.getText() == "X" && button31.getText() == "X") {
            return true;
        }
        //column2
        if (button12.getText() == "X" && button22.getText() == "X" && button32.getText() == "X") {
            return true;
        }
        //column3
        if (button13.getText() == "X" && button23.getText() == "X" && button33.getText() == "X") {
            return true;
        }
        //across1
        if (button11.getText() == "X" && button22.getText() == "X" && button33.getText() == "X") {
            return true;
        }
        //across2
        if (button31.getText() == "X" && button22.getText() == "X" && button13.getText() == "X") {
            return true;
        }
        return false;
    }

    //done
    private boolean checkWinY() {
        //line1
        if (button11.getText() == "O" && button12.getText() == "O" && button13.getText() == "O") {
            return true;
        }
        //line2
        if (button21.getText() == "O" && button22.getText() == "O" && button23.getText() == "O") {
            return true;
        }
        //line3
        if (button31.getText() == "O" && button32.getText() == "O" && button33.getText() == "O") {
            return true;
        }
        //column1
        if (button11.getText() == "O" && button21.getText() == "O" && button31.getText() == "O") {
            return true;
        }
        //column2
        if (button12.getText() == "O" && button22.getText() == "O" && button32.getText() == "O") {
            return true;
        }
        //column3
        if (button13.getText() == "O" && button23.getText() == "O" && button33.getText() == "O") {
            return true;
        }
        //across1
        if (button11.getText() == "O" && button22.getText() == "O" && button33.getText() == "O") {
            return true;
        }
        //across2
        if (button31.getText() == "O" && button22.getText() == "O" && button13.getText() == "O") {
            return true;
        }
        return false;
    }

    //done
    private void clickX(Button button) {

        if (button.getText() == " ") {
            button.setText("X");
            roundCount++;
            playerXTurn = !playerXTurn;
            turnText.setText("Turn Player O");
        } else {
            Toast.makeText(this, "Choose a different field", Toast.LENGTH_SHORT).show();
        }


    }

    //done
    private void clickO(Button button) {
        if (button.getText() == " ") {
            button.setText("O");
            roundCount++;
            playerXTurn = !playerXTurn;
            turnText.setText("Turn Player X");
        } else {
            Toast.makeText(this, "Choose a different field", Toast.LENGTH_SHORT).show();
        }
    }

    //done
    private void clickReset(Button button) {
        button.setText(" ");
    }


    private void playerXWinner() {
        pointsX++;
        updatePointsText();
        resetButtons();
        AlertDialog winnerDialog = new AlertDialog.Builder(OneVOneGameActivity.this)
                .setTitle("Player X has won!")
                .setMessage("Score is:\nX:   " + pointsX + "\nO:   " + pointsO)
                .setPositiveButton("Ok", null)
                .create();
        winnerDialog.show();
    }

    private void playerOWinner() {
        pointsO++;
        updatePointsText();
        resetButtons();
        AlertDialog winnerDialog = new AlertDialog.Builder(OneVOneGameActivity.this)
                .setTitle("Player O has won!")
                .setMessage("Score is:\nX:   " + pointsX + "\nO:   " + pointsO)
                .setPositiveButton("Ok", null)
                .create();
        winnerDialog.show();
    }

    private void draw() {
        AlertDialog drawDialog = new AlertDialog.Builder(OneVOneGameActivity.this)
                .setTitle("Draw")
                .setMessage("Score is:\nX:   " + pointsX + "\nO:   " + pointsO)
                .setPositiveButton("Ok", null)
                .create();
        drawDialog.show();
        resetButtons();
    }

    private void updatePointsText() {
        scoreX.setText("Player X: " + pointsX);
        scoreO.setText("Player O: " + pointsO);

    }

}




