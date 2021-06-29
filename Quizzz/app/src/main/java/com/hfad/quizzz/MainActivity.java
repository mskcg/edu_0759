package com.hfad.quizzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button yesBtn;
    private Button noBtn;
    private Button showAnswerBtn;
    private TextView questionTextView;
    private Question[] questions = {
            new Question(R.string.question0, true),
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
            new Question(R.string.question5, true),
            new Question(R.string.question6, false),
            new Question(R.string.question7, true),
            new Question(R.string.question8, false),
            new Question(R.string.question9, true),
    };
    private String[] answers = new String[questions.length];    //  Записываем строку "Вопрос - ваш ответ да/нет" в массив
    private int score = 0;  // количество баллов за правильные ответы
    private int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO", "Метод onCreate() запущен");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            questionIndex = savedInstanceState.getInt("question");
        }

        questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(questions[questionIndex].getQuestion());
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        showAnswerBtn = findViewById(R.id.showAnswerBtn);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answers[questionIndex] = getString(questions[questionIndex].getQuestion())+"? Ваш ответ: Да";
                if(questions[questionIndex].isAnswer()){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    score++;
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }

                //questionIndex = (questionIndex + 1)%questions.length;    // зацикливание викторины
                questionIndex++;
                if(questionIndex == questions.length) {     // Если вопрос последний, то создаём интент
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("answers", answers);
                    intent.putExtra("score", score);
                    startActivity(intent);
                    questionIndex = 0;
                }
                questionTextView.setText(questions[questionIndex].getQuestion());
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answers[questionIndex] = getString(questions[questionIndex].getQuestion())+"? Ваш ответ: Нет";
                if(!questions[questionIndex].isAnswer()){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    score++;
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }

                //questionIndex = (questionIndex + 1)%questions.length;   // зацикливание викторины
                questionIndex++;
                if(questionIndex == questions.length) {     // Если вопрос последний, то создаём интент
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("answers", answers);
                    intent.putExtra("score", score);
                    startActivity(intent);
                    questionIndex = 0;
                }
                questionTextView.setText(questions[questionIndex].getQuestion());
            }
        });
        showAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswer());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SYSTEM INFO", "Метод onStart() запущен");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SYSTEM INFO", "Метод onResume() запущен");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO", "Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("question", questionIndex);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SYSTEM INFO", "Метод onPause() запущен");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SYSTEM INFO", "Метод onStop() запущен");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SYSTEM INFO", "Метод onDestroy() запущен");
    }

}