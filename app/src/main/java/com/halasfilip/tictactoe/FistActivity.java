package com.halasfilip.tictactoe;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class FistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button oneVOneButton = findViewById(R.id.OneVOneButton);
        final Button playerVCpuButton = findViewById(R.id.PlayerVCpuButton);


        oneVOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FistActivity.this, OneVOneGameActivity.class);
                startActivity(intent);
            }
        });

        playerVCpuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FistActivity.this, PlayerVCpuGameActivity.class);
                startActivity(intent);
            }
        });


    }
    
}
