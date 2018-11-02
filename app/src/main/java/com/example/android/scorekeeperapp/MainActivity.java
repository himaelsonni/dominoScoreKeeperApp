package com.example.android.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int x = 0, y = 0;
    TextView p1TotalScore, p2TotalScore;
    EditText p1input, p2input;
    Button p1calc, p2calc, btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1input = findViewById(R.id.ET_count1);
        p2input = findViewById(R.id.ET_count2);
        p1TotalScore = findViewById(R.id.tv_total_score1);
        p2TotalScore = findViewById(R.id.tv_total_score2);
        p1calc = findViewById(R.id.btn_score1);
        p2calc = findViewById(R.id.btn_score2);
        btn_reset = findViewById(R.id.btn_reset);
    }

    public void calcScore1(View view) {
        if (!p1input.getText().toString().equals("")) {
            x += Integer.parseInt(p1input.getText().toString());
            p1TotalScore.setText(String.valueOf(x));
            winner(x, y);
        } else {
            Toast toast = Toast.makeText(this, "Please Input Valid Score!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void calcScore2(View view) {
        if (!p2input.getText().toString().equals("")) {
            y += Integer.parseInt(p2input.getText().toString());
            p2TotalScore.setText(String.valueOf(y));
            winner(x, y);
        } else {
            Toast toast = Toast.makeText(this, "Please Input Valid Score!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void reset(View view) {
        x = 0;
        y = 0;
        p1TotalScore.setText("0");
        p2TotalScore.setText("0");
        p1input.setText("");
        p2input.setText("");
        p1input.setVisibility(View.VISIBLE);
        p2input.setVisibility(View.VISIBLE);
        p1calc.setVisibility(View.VISIBLE);
        p2calc.setVisibility(View.VISIBLE);

    }

    public void winner(int x, int y) {
        if (x > y && x >= 201) {
            Toast toast = Toast.makeText(this, "player 1 is winner :)", Toast.LENGTH_SHORT);
            toast.show();
            p1input.setVisibility(View.INVISIBLE);
            p2input.setVisibility(View.INVISIBLE);
            p1calc.setVisibility(View.INVISIBLE);
            p2calc.setVisibility(View.INVISIBLE); }

            else if (x < y && y >= 201) {
            Toast toast = Toast.makeText(this, "player 2 is winner :)", Toast.LENGTH_SHORT);
            toast.show();
            p2input.setVisibility(View.INVISIBLE);
            p1input.setVisibility(View.INVISIBLE);
            p1calc.setVisibility(View.INVISIBLE);
            p2calc.setVisibility(View.INVISIBLE); }
    }
}
