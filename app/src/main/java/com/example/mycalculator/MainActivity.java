package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

    TextView result;

    EditText numberPlaceHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.plusbtn);
        btnSubtract = findViewById(R.id.minusbtn);
        btnMultiply = findViewById(R.id.timesbtn);
        btnDivide = findViewById(R.id.dividebtn);
        btn0 = findViewById(R.id.zerobtn);
        btn1 = findViewById(R.id.onebtn);
        btn2 = findViewById(R.id.twobtn);
        btn3 = findViewById(R.id.threebtn);
        btn4 = findViewById(R.id.fourbtn);
        btn5 = findViewById(R.id.fivebtn);
        btn6 = findViewById(R.id.sixbtn);
        btn7 = findViewById(R.id.sevenbtn);
        btn8 = findViewById(R.id.eightbtn);
        btn9 = findViewById(R.id.ninebtn);

        numberPlaceHolder = (EditText) findViewById(R.id.editNum);



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num0 = btn0.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = btn1.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num2 = btn2.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num3 = btn3.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num4 = btn4.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num5 = btn5.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num6 = btn6.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num7 = btn7.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num8 = btn8.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num9 = btn9.getText().toString();
                numberPlaceHolder.setText(numberPlaceHolder.getText() + num9);
            }
        });
    }
}