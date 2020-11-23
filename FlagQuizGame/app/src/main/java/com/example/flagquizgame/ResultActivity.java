package com.example.flagquizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewTotalCorrect,textViewTotalWrong,textViewTotalEmpty,textViewSuccess;
    private Button buttonAgain,buttonQuit;
    int correct,wrong,empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewTotalCorrect = findViewById(R.id.textViewTotalCorrect);
        textViewTotalWrong = findViewById(R.id.textViewTotalWrong);
        textViewTotalEmpty = findViewById(R.id.textViewTotalEmpty);
        textViewSuccess = findViewById(R.id.textViewSuccess);
        buttonAgain = findViewById(R.id.buttonAgain);
        buttonQuit = findViewById(R.id.buttonQuit);

        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);
        empty = getIntent().getIntExtra("empty",0);

        textViewTotalCorrect.setText("Total Correct Answer : "+correct);
        textViewTotalWrong.setText("Total Wrong Answer : "+ wrong);
        textViewTotalEmpty.setText("Total Empty Answer : "+empty);
        textViewSuccess.setText("Success Rate : "+(correct*10));

        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(Intent.ACTION_MAIN);
                newIntent.addCategory(Intent.CATEGORY_HOME);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(newIntent);
                finish();

            }
        });

    }
}