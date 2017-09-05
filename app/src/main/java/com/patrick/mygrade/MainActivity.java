package com.patrick.mygrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText quiz_1;
    EditText quiz_2;
    EditText seat_Work;
    EditText Lab_Exer;
    EditText Major_Exam;

    Double ra;
    Double fg;
    Button btn_Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quiz_1 = (EditText) findViewById(R.id.quiz1);
        quiz_2 = (EditText) findViewById(R.id.quiz2);
        seat_Work = (EditText) findViewById(R.id.seatwork);
        Lab_Exer = (EditText) findViewById(R.id.lab);
        Major_Exam = (EditText) findViewById(R.id.major);
        btn_Send = (Button) findViewById(R.id.btnSend);

    }

        public void callSecondActivity (View view){
            Double quiz1Score = Double.parseDouble(quiz_1.getText().toString());
            Double quiz2Score = Double.parseDouble(quiz_2.getText().toString());
            Double seatScore = Double.parseDouble(seat_Work.getText().toString());
            Double labScore = Double.parseDouble(Lab_Exer.getText().toString());
            Double majorScore = Double.parseDouble(Major_Exam.getText().toString());

            ra = (quiz1Score * .1) + (quiz2Score * .1) + (seatScore * .1) + (labScore * .4) + (majorScore * .3);

            if (ra < 60) {
                fg = 5.0;
            } else if (ra >= 60 && ra < 66) {
                fg = 3.0;
            } else if (ra >= 66 && ra < 71) {
                fg = 2.75;
            } else if (ra >= 71 && ra < 76) {
                fg = 2.5;
            } else if (ra >= 76 && ra < 81) {
                fg = 2.25;
            } else if (ra >= 81 && ra < 86) {
                fg = 2.0;
            } else if (ra >= 86 && ra < 91) {
                fg = 1.75;
            } else if (ra >= 91 && ra < 93) {
                fg = 1.5;
            } else if (ra >= 93 && ra < 95) {
                fg = 1.25;
            } else if (ra >= 95 && ra <= 100) {
                fg = 1.0;
            } else {
                fg = 0.0;
            }

            Intent intent = new Intent(this, secondActivity.class);
            intent.putExtra("raGrade", ra.toString());
            intent.putExtra("fgGrade", fg.toString());
            startActivity(intent);
    }




}
