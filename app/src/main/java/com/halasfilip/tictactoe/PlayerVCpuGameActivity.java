package com.halasfilip.tictactoe;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PlayerVCpuGameActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        scoreX = findViewById(R.id.textX);
        scoreO = findViewById(R.id.textY);

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

        scoreX.setText("X: " + pointsX);
        scoreO.setText("O: " + pointsO);

        resetButtons();

        Button resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
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
            checkWinO();
        }
        if (checkWinX()) {
            playerXWinner();
        } else if (checkWinO()) {
            playerOWinner();
        } else if (roundCount == 9) {
            draw();
        }
        if (!playerXTurn){
            scoreX.setBackgroundColor(Color.parseColor("#00FF0000"));
            scoreO.setBackgroundColor(Color.RED);
        } else {
            scoreO.setBackgroundColor(Color.parseColor("#00FF0000"));
            scoreX.setBackgroundColor(Color.RED);
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
        scoreO.setBackgroundColor(Color.parseColor("#00FF0000"));
        scoreX.setBackgroundColor(Color.RED);

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
    private boolean checkWinO() {
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
        scoreO.setBackgroundColor(Color.parseColor("#00FF0000"));
        scoreX.setBackgroundColor(Color.RED);
        if (button.getText() == " ") {
            button.setText("X");
            roundCount++;
            playerXTurn = !playerXTurn;
        }

    }


//???????????????????????????
    private void clickO(Button button) {
        scoreX.setBackgroundColor(Color.parseColor("#00FF0000"));
        scoreO.setBackgroundColor(Color.RED);
        clickCPU();
    }
//???????????????????????????
    private void clickCPU() {
        //tworzymy array z naszych przyciskow done
        //to juz w petli ??
        //cpu losuje 2 liczby od 1-3 done
        //if field jest pusty to cpu wpisuje O w guzik zgodny z array i koniec petli i koniec metody
        //else losuje 2 liczby od 1-3

        final Button[][] buttonsField = new Button[3][3];
        buttonsField[0][0] = button11;
        buttonsField[0][1] = button12;
        buttonsField[0][2] = button13;

        buttonsField[1][0] = button21;
        buttonsField[1][1] = button22;
        buttonsField[1][2] = button23;

        buttonsField[2][0] = button31;
        buttonsField[2][1] = button32;
        buttonsField[2][2] = button33;

        int randomRow;
        int randomCol;
        while (true) {
            randomRow = (int) (Math.random() * 3);
            randomCol = (int) (Math.random() * 3);
            if (buttonsField[randomRow][randomCol].getText() == " ") {
                buttonsField[randomRow][randomCol].setText("O");
                //--------------
                //chce zeby sam wykonal click zamiast na mnie czekac
                buttonsField[randomRow][randomCol].performClick();
                //--------------
                roundCount++;
                playerXTurn = !playerXTurn;
                break;
            }
        }
    }

    //done
    private void clickReset(Button button) {
        button.setText(" ");
    }
    //done
    private void playerXWinner() {
        pointsX++;
        updatePointsText();
        resetButtons();
        AlertDialog winnerDialog = new AlertDialog.Builder(PlayerVCpuGameActivity.this)
                .setTitle("Player X has won!")
                .setMessage("Score is\nX:   " + pointsX + "\nO:   " + pointsO)
                .setPositiveButton("Ok", null)
                .create();
        winnerDialog.show();
    }
    //dome
    private void playerOWinner() {
        pointsO++;
        updatePointsText();
        resetButtons();
        AlertDialog winnerDialog = new AlertDialog.Builder(PlayerVCpuGameActivity.this)
                .setTitle("CPU has won!")
                .setMessage("Score is\nX:   " + pointsX + "\nO:   " + pointsO)
                .setPositiveButton("Ok", null)
                .create();
        winnerDialog.show();
    }
    //done
    private void draw() {
        Toast.makeText(this, "BORING! draw..", Toast.LENGTH_SHORT).show();
        resetButtons();
    }
    //done
    private void updatePointsText() {
        scoreX.setText("X: " + pointsX);
        scoreO.setText("CPU: " + pointsO);
    }

}




