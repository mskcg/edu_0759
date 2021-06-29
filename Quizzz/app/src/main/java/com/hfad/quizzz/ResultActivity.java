package com.hfad.quizzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView answersTableTextView;
    private String[] answers;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        answersTableTextView = findViewById(R.id.answersTableTextView);
        score = getIntent().getIntExtra("score", 0);
        answers = getIntent().getStringArrayExtra("answers");
        String resultText = "";
        for (String s:answers) {
            resultText += s+"\n";
        }
        resultText += "\nИтого, вы получаете "+score+" баллов!";
        answersTableTextView.setText(resultText);
    }
}