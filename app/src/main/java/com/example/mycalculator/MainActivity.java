package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear, btnBack;
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
        btnBack = findViewById(R.id.backspacebtn);

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

                if(equationText.toString().isEmpty() || (equationText.charAt(equationText.length()-1) != '.')) {
                    String point = btnPoint.getText().toString();

                    setPlaceHolders(point);
                }

//                char lastChar = equationText.charAt(equationText.length() - 1);
//
//                if(lastChar != '.') {
//                    String point = btnPoint.getText().toString();
//
//                    setPlaceHolders(point);
//                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty() || (equation.getText().charAt(equation.length()-1) == '.')) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + "+");
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + "+");
                }

                if(!numB.isEmpty()) {
                    result = calculateForInline(Double.parseDouble(numA), Double.parseDouble(numB), op) ;
                    numberPlaceHolder.setText(String.valueOf(result));

                    numA = String.valueOf(result);
                    numB = "";
                    result = (double) 0;
                }

                op = "+";
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty() || (equation.getText().charAt(equation.length()-1) == '.')) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + "-");
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + "-");
//                    substring ([starting_index], [end_index - 1]);
//                    20+3- 5 length : balig "20+3" + "-"
//                    substring (0, (5-1) - 1) (0, 3)
                }

                // 20
                // 20+  : Store 20 in numA, store + in op
                // 20-  : change the op to -
                // 20-5 :
                // 20-5* : Store 5 in numB, solve 20-5 and store in result, then store result in numA && reset numB and result
                // 20-5*2 :
                // 20-5*2 = : Solve using (PE) MDAS

                if(!numB.toString().isEmpty()) {
                    result = calculateForInline(Double.parseDouble(numA), Double.parseDouble(numB), op) ;
                    numberPlaceHolder.setText(String.valueOf(result));

                    numA = String.valueOf(result);
                    numB = "";
                    result = (double) 0;
                }

                op = "-";
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty() || (equation.getText().charAt(equation.length()-1) == '.')) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + "*");
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + "*");
                }

                if(!numB.toString().isEmpty()) {
                    result = calculateForInline(Double.parseDouble(numA), Double.parseDouble(numB), op) ;
                    numberPlaceHolder.setText(String.valueOf(result));

                    numA = String.valueOf(result);
                    numB = "";
                    result = (double) 0;
                }

                op = "*";
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (equation.getText().toString().isEmpty() || (equation.getText().charAt(equation.length()-1) == '.')) {
                    return;
                }

                String equationText = equation.getText().toString();
                char lastChar = equationText.charAt(equationText.length() - 1);

                if (!isOperator(lastChar)) {
                    equation.setText(equation.getText() + "/");
                } else {
                    equation.setText(equationText.substring(0, equationText.length() - 1) + "/");
                }

                if(!numB.toString().isEmpty()) {
                    result = calculateForInline(Double.parseDouble(numA), Double.parseDouble(numB), op) ;
                    numberPlaceHolder.setText(String.valueOf(result));

                    numA = String.valueOf(result);
                    numB = "";
                    result = (double) 0;
                }

                op = "/";
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = equation.getText().toString();
                if (expression.isEmpty() || isOperator(expression.charAt(expression.length() - 1))) {
                    return;
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

                numbersStack.clear();
                operationsStack.clear();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Character lastChar = equation.getText().toString().charAt(equation.length() - 1);
                equation.setText(equation.getText().toString().substring(0, equation.getText().length() - 1));
                if(isOperator(lastChar)) {

                }
            }
        });
    }

    // Click 1 : equation text "1" && store at numA
    // Click 2 : concat text "2" at equation && concatenate at numA; "1" + "2" = "12"
    // Click + : concat text "+" at equation && store at op
    // Click - : update/change the last index of equation to "-" && change op
    // Click 3 :

    private void setPlaceHolders(String num) {
        if(op.isEmpty() && numB.isEmpty()) {
            if(numA.contains(".") && num.equals(".")) {
                return;
            }
            numA = (numA + num);
            numberPlaceHolder.setText(numA);
        } else {
            if(numB.contains(".") && num.equals(".")) {
                return;
            }
            numB = (numB + num);
            numberPlaceHolder.setText(numB);
        }

        equation.setText(equation.getText() + num);
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
        numbersStack.clear();
        operationsStack.clear();

        int n = expression.length();
        int i = 0;
        while (i < n) {
            if (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.') {
                StringBuilder num = new StringBuilder();
                while (i < n && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(expression.charAt(i));
                    i++;
                }
                numbersStack.push(Double.parseDouble(num.toString()));
            } else if (isOperator(expression.charAt(i))) {
                while (!operationsStack.isEmpty() && (hasPrecedence(expression.charAt(i)) || (!hasPrecedence(expression.charAt(i)) && !hasPrecedence(operationsStack.peek())))) {
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

        if (!numbersStack.isEmpty()) {
            numberPlaceHolder.setText(String.valueOf(numbersStack.pop()));
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

//    private boolean hasPrecedence(char op1, char op2) {
//        return (op2 != '(' && op2 != ')') && (op1 != '*' && op1 != '/');
//    }


    private boolean hasPrecedence(char op1) {
        return (op1 != '*' && op1 != '/');
    }

    private void performOperation() {
        if (numbersStack.size() < 2 || operationsStack.isEmpty()) {
            return;
        }

        double b = numbersStack.pop();
        double a = numbersStack.pop();
        char operation = operationsStack.pop();

        double res = 0;
        switch (operation) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                if (b != 0) {
                    res = a / b;

                } else {
                    numberPlaceHolder.setText("MATH ERROR");
                }
                break;
        }
        numbersStack.push(res);
    }
}
