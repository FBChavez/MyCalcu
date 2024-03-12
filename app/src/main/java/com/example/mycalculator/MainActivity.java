package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnPoint;
    private TextView equation;
    private EditText numberPlaceHolder;
    private String numA = "", numB = "", op = "";
    private Double result;
    private Stack<Double> numbersStack;
    private Stack<Character> operationsStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.plusbtn);
        btnSubtract = findViewById(R.id.minusbtn);
        btnMultiply = findViewById(R.id.timesbtn);
        btnDivide = findViewById(R.id.dividebtn);
        btnEquals = findViewById(R.id.equalsbtn);
        btnClear = findViewById(R.id.clearbtn);

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
        btnPoint = findViewById(R.id.pointbtn);

        numberPlaceHolder = (EditText) findViewById(R.id.editNum);
        equation = (TextView) findViewById(R.id.equationString);

        numbersStack = new Stack<>();
        operationsStack = new Stack<>();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num0 = btn0.getText().toString();

                setPlaceHolders(num0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = btn1.getText().toString();

                setPlaceHolders(num1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num2 = btn2.getText().toString();

                setPlaceHolders(num2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num3 = btn3.getText().toString();

                setPlaceHolders(num3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num4 = btn4.getText().toString();

                setPlaceHolders(num4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num5 = btn5.getText().toString();

                setPlaceHolders(num5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num6 = btn6.getText().toString();

                setPlaceHolders(num6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num7 = btn7.getText().toString();

                setPlaceHolders(num7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num8 = btn8.getText().toString();

                setPlaceHolders(num8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num9 = btn9.getText().toString();

                setPlaceHolders(num9);
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if(lastChar != '.') {
                    String point = btnPoint.getText().toString();

                    setPlaceHolders(point);
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty()) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + btnAdd.getText().toString());
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + btnAdd.getText().toString());
                }

                if(!numB.toString().isEmpty()) {
                    result = calculateForInline(Double.parseDouble(numA), Double.parseDouble(numB), op) ;
                    numberPlaceHolder.setText(String.valueOf(result));

                    numA = String.valueOf(result);
                    numB = "";
                    result = (double) 0;
                }

                op = btnAdd.getText().toString();
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty()) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + btnSubtract.getText().toString());
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + btnSubtract.getText().toString());
                }

                if(!numB.toString().isEmpty()) {
                    result = calculateForInline(Double.parseDouble(numA), Double.parseDouble(numB), op) ;
                    numberPlaceHolder.setText(String.valueOf(result));

                    numA = String.valueOf(result);
                    numB = "";
                    result = (double) 0;
                }

                op = btnSubtract.getText().toString();
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty()) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + btnMultiply.getText().toString());
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + btnMultiply.getText().toString());
                }

                if(!numB.toString().isEmpty()) {
                    result = calculateForInline(Double.parseDouble(numA), Double.parseDouble(numB), op) ;
                    numberPlaceHolder.setText(String.valueOf(result));

                    numA = String.valueOf(result);
                    numB = "";
                    result = (double) 0;
                }

                op = btnMultiply.getText().toString();
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty()) {
                    return; // Don't allow operation as the first input
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + btnDivide.getText().toString());
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + btnDivide.getText().toString());
                }

                if(!numB.toString().isEmpty()) {
                    result = calculateForInline(Double.parseDouble(numA), Double.parseDouble(numB), op) ;
                    numberPlaceHolder.setText(String.valueOf(result));

                    numA = String.valueOf(result);
                    numB = "";
                    result = (double) 0;
                }

                op = btnDivide.getText().toString();
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = equation.getText().toString();
                if (expression.isEmpty() || isOperator(expression.charAt(expression.length() - 1))) {
                    return; // Don't allow equals if the equation ends with an operator
                }

                evaluateExpression(expression);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equation.setText("");
                numberPlaceHolder.setText("");
                numA = "";
                numB = "";
                op = "";
                result = null;

                // Clear the stacks
                numbersStack.clear();
                operationsStack.clear();
            }
        });
    }

    private void setPlaceHolders(String num) {
        equation.setText(equation.getText() + num);

        if(op.toString().isEmpty() && numB.toString().isEmpty()) {
            numA = (numA + num);
            numberPlaceHolder.setText(numA);
        } else {
            numB = (numB + num);
            numberPlaceHolder.setText(numB);
        }
    }
    private Double calculateForInline(Double num1, Double num2, String op) {
        switch(op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                try {
                    return num1 / num2;
                } catch (ArithmeticException a) {
                    numberPlaceHolder.setText("MATH ERROR");
                }
        }

        return (double) 0;
    }


    private void evaluateExpression(String expression) {
        // Clear the previous result
        numbersStack.clear();
        operationsStack.clear();

        int n = expression.length();
        int i = 0;
        while (i < n) {
            if (Character.isDigit(expression.charAt(i))) {
                StringBuilder num = new StringBuilder();
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    num.append(expression.charAt(i));
                    i++;
                }
                numbersStack.push(Double.parseDouble(num.toString()));
            } else if (isOperator(expression.charAt(i))) {
                while (!operationsStack.isEmpty() && hasPrecedence(expression.charAt(i), operationsStack.peek())) {
                    performOperation();
                }
                operationsStack.push(expression.charAt(i));
                i++;
            } else {
                i++;
            }
        }

        while (!operationsStack.isEmpty()) {
            performOperation();
        }

        // Display the result in the EditText
        if (!numbersStack.isEmpty()) {
            numberPlaceHolder.setText(String.valueOf(numbersStack.pop()));
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char op1, char op2) {
        return (op2 != '(' && op2 != ')') && (op1 != '*' && op1 != '/');
    }

    private void performOperation() {
        if (numbersStack.size() < 2 || operationsStack.isEmpty()) {
            return;
        }

        double b = numbersStack.pop();
        double a = numbersStack.pop();
        char operation = operationsStack.pop();

        double result = 0;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                } else {
                    // Handle division by zero error
                }
                break;
        }
        numbersStack.push(result);
    }
}
