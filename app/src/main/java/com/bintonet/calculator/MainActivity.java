package com.bintonet.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    Button btnPlus;
    Button btnMinus;
    Button btnDivide;
    Button btnMultiply;
    Button btnClearAll;
    Button btnEquals;

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;
    Button btnDecimalPoint;

    TextView textFinalResult;
    TextView textSum;

    Float fltFinalResult;
    Float fltTempSum;

    Integer intFinalResult;

    String strTempSum = "";
    String strNextOperation = "";

    Boolean isDecimalNumber = false;
    Boolean isResultDecimal = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main_2);


        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnClearAll = (Button) findViewById(R.id.btnClearAll);
        btnEquals = (Button) findViewById(R.id.btnEquals);

        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnDecimalPoint = (Button) findViewById(R.id.btnDecimalPoint);

        textSum = (TextView) findViewById(R.id.textSum);
        textFinalResult = (TextView) findViewById(R.id.textResult);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("9");
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed("0");
            }
        });
        btnDecimalPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isResultDecimal = true;
                if(!isDecimalNumber) {
                    numberButtonPressed(".");
                    isDecimalNumber = true;
                }
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSum.setText("");
                textFinalResult.setText("");
                strTempSum = "";
                strNextOperation = "";
                fltFinalResult = 0.0f;
                fltTempSum = 0.0f;
                isDecimalNumber = false;
                isResultDecimal = false;
                intFinalResult = 0;
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(strTempSum != "") {
                    float oper1 = Float.parseFloat(strTempSum);
                    //If next Operation is Null (i.e this is the first operation, lets just set the next operation value
                    if (strNextOperation == "") {
                        if(!isResultDecimal){
                            intFinalResult = Math.round(fltFinalResult);
                            textSum.setText(String.valueOf(intFinalResult));
                            textFinalResult.setText(String.valueOf(intFinalResult));
                        }else{
                            fltFinalResult = fltTempSum;
                            strTempSum = String.valueOf(fltFinalResult);
                            textSum.setText(String.valueOf(fltFinalResult));
                            textFinalResult.setText(String.valueOf(fltFinalResult));
                            isDecimalNumber = false;
                        }
                    } else {

                        switch (strNextOperation) {
                            case "+":
                                performAdd(oper1);
                                strNextOperation = "";
                                fltFinalResult = fltTempSum;
                                strTempSum = String.valueOf(fltFinalResult);
                                if(!isResultDecimal) {
                                    intFinalResult = Math.round(fltFinalResult);
                                    textSum.setText(String.valueOf(intFinalResult));
                                    textFinalResult.setText(String.valueOf(intFinalResult));
                                }else{
                                    textSum.setText(String.valueOf(fltFinalResult));
                                    textFinalResult.setText(String.valueOf(fltFinalResult));
                                    isDecimalNumber = false;
                                }

                                break;
                            case "-":
                                performMinus(oper1);
                                strNextOperation = "";
                                fltFinalResult = fltTempSum;
                                strTempSum = String.valueOf(fltFinalResult);
                                if(!isResultDecimal) {
                                    intFinalResult = Math.round(fltFinalResult);
                                    textSum.setText(String.valueOf(intFinalResult));
                                    textFinalResult.setText(String.valueOf(intFinalResult));
                                }else{
                                    textSum.setText(String.valueOf(fltFinalResult));
                                    textFinalResult.setText(String.valueOf(fltFinalResult));
                                    isDecimalNumber = false;
                                }
                                break;
                            case "/":
                                performDivide(oper1);
                                strNextOperation = "";
                                fltFinalResult = fltTempSum;
                                strTempSum = String.valueOf(fltFinalResult);
                                if(!isResultDecimal) {
                                    intFinalResult = Math.round(fltFinalResult);
                                    textSum.setText(String.valueOf(intFinalResult));
                                    textFinalResult.setText(String.valueOf(intFinalResult));
                                }else{
                                    textSum.setText(String.valueOf(fltFinalResult));
                                    textFinalResult.setText(String.valueOf(fltFinalResult));
                                    isDecimalNumber = false;
                                }
                                break;
                            case "x":
                                performMultiply(oper1);
                                strNextOperation = "";
                                fltFinalResult = fltTempSum;
                                strTempSum = String.valueOf(fltFinalResult);
                                if(!isResultDecimal) {
                                    intFinalResult = Math.round(fltFinalResult);
                                    textSum.setText(String.valueOf(intFinalResult));
                                    textFinalResult.setText(String.valueOf(intFinalResult));
                                }else{
                                    textSum.setText(String.valueOf(fltFinalResult));
                                    textFinalResult.setText(String.valueOf(fltFinalResult));
                                    isDecimalNumber = false;
                                }
                                break;
                            default:
                                strNextOperation = "";
                                fltFinalResult = fltTempSum;
                                strTempSum = String.valueOf(fltFinalResult);
                                if(!isResultDecimal) {
                                    intFinalResult = Math.round(fltFinalResult);
                                    textSum.setText(String.valueOf(intFinalResult));
                                    textFinalResult.setText(String.valueOf(intFinalResult));
                                }else{
                                    textSum.setText(String.valueOf(fltFinalResult));
                                    textFinalResult.setText(String.valueOf(fltFinalResult));
                                    isDecimalNumber = false;
                                }
                                break;

                        }
                    }
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDecimalNumber = false;
                if(strTempSum != "") {
                    textSum.setText(textSum.getText() + "+");
                    float oper1 = Float.parseFloat(strTempSum);
                    //If next Operation is Null (i.e this is the first operation, lets just set the next operation value
                    if (strNextOperation == "") {
                        if(!isResultDecimal){
                            strNextOperation = "+";
                            fltTempSum = Float.parseFloat(strTempSum);
                            intFinalResult = Math.round(fltTempSum);
                            textFinalResult.setText(String.valueOf(intFinalResult));
                        }else{
                            strNextOperation = "+";
                            fltTempSum = Float.parseFloat(strTempSum);
                            textFinalResult.setText(String.valueOf(fltTempSum));
                        }
                        strTempSum = "";
                    } else {
                        switch (strNextOperation) {
                            case "+":
                                performAdd(oper1);
                                strNextOperation = "+";
                                break;
                            case "-":
                                performMinus(oper1);
                                strNextOperation = "+";
                                break;
                            case "/":
                                performDivide(oper1);
                                strNextOperation = "+";
                                break;
                            case "x":
                                performMultiply(oper1);
                                strNextOperation = "+";
                                break;
                            default:
                                break;

                        }
                    }
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDecimalNumber = false;
                if(strTempSum != "") {
                    textSum.setText(textSum.getText() + "-");
                    float oper1 = Float.parseFloat(strTempSum);
                    //If next Operation is Null (i.e this is the first operation, lets just set the next operation value
                    if (strNextOperation == "") {
                        if(!isResultDecimal){
                            strNextOperation = "-";
                            fltTempSum = Float.parseFloat(strTempSum);
                            intFinalResult = Math.round(fltTempSum);
                            textFinalResult.setText(String.valueOf(intFinalResult));
                        }else{
                            strNextOperation = "-";
                            fltTempSum = Float.parseFloat(strTempSum);
                            textFinalResult.setText(String.valueOf(fltTempSum));
                        }
                        strTempSum = "";
                    } else {
                        switch (strNextOperation) {
                            case "+":
                                performAdd(oper1);
                                strNextOperation = "-";
                                break;
                            case "-":
                                performMinus(oper1);
                                strNextOperation = "-";
                                break;
                            case "/":
                                performDivide(oper1);
                                strNextOperation = "-";
                                break;
                            case "x":
                                performMultiply(oper1);
                                strNextOperation = "-";
                                break;
                            default:
                                break;

                        }
                    }
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDecimalNumber = false;
                if(strTempSum != "") {
                    textSum.setText(textSum.getText() + "x");
                    float oper1 = Float.parseFloat(strTempSum);
                    //If next Operation is Null (i.e this is the first operation, lets just set the next operation value
                    if (strNextOperation == "") {
                        if(!isResultDecimal){
                            strNextOperation = "x";
                            fltTempSum = Float.parseFloat(strTempSum);
                            intFinalResult = Math.round(fltTempSum);
                            textFinalResult.setText(String.valueOf(intFinalResult));
                        }else{
                            strNextOperation = "x";
                            fltTempSum = Float.parseFloat(strTempSum);
                            textFinalResult.setText(String.valueOf(fltTempSum));
                        }
                        strTempSum = "";
                    } else {
                        switch (strNextOperation) {
                            case "+":
                                performAdd(oper1);
                                strNextOperation = "x";
                                break;
                            case "-":
                                performMinus(oper1);
                                strNextOperation = "x";
                                break;
                            case "/":
                                performDivide(oper1);
                                strNextOperation = "x";
                                break;
                            case "x":
                                performMultiply(oper1);
                                strNextOperation = "x";
                                break;
                            default:
                                break;

                        }
                    }
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDecimalNumber = false;
                if(strTempSum != "") {
                    textSum.setText(textSum.getText() + "/");
                    float oper1 = Float.parseFloat(strTempSum);
                    //If next Operation is Null (i.e this is the first operation, lets just set the next operation value
                    if (strNextOperation == "") {
                        if(!isResultDecimal){
                            strNextOperation = "/";
                            fltTempSum = Float.parseFloat(strTempSum);
                            intFinalResult = Math.round(fltTempSum);
                            textFinalResult.setText(String.valueOf(intFinalResult));
                        }else{
                            strNextOperation = "/";
                            fltTempSum = Float.parseFloat(strTempSum);
                            textFinalResult.setText(String.valueOf(fltTempSum));
                        }
                        strTempSum = "";
                    } else {
                        switch (strNextOperation) {
                            case "+":
                                performAdd(oper1);
                                strNextOperation = "/";
                                break;
                            case "-":
                                performMinus(oper1);
                                strNextOperation = "/";
                                break;
                            case "/":
                                performDivide(oper1);
                                strNextOperation = "/";
                                break;
                            case "x":
                                performMultiply(oper1);
                                strNextOperation = "/";
                                break;
                            default:
                                break;

                        }
                    }
                }
            }
        });

    }

    public void numberButtonPressed(String numberPressed){
        textSum.setText(textSum.getText() + numberPressed);
        strTempSum = strTempSum + numberPressed;
    }

    public void performAdd(Float oper1){
        if(fltTempSum != null){
            fltTempSum = fltTempSum + oper1;
        }else{
            fltTempSum = oper1;
        }
        isDecimalNumber = false;
        strTempSum = "";
        if(!isResultDecimal) {
            intFinalResult = Math.round(fltTempSum);
            textFinalResult.setText(String.valueOf(intFinalResult));
        }else{
            textFinalResult.setText(String.valueOf(fltTempSum));
        }

    }

    public void performMinus(Float oper1){
        if(fltTempSum != null){
            fltTempSum = fltTempSum - oper1;
        }else{
            fltTempSum = oper1;
        }
        isDecimalNumber = false;
        strTempSum = "";
        if(!isResultDecimal) {
            intFinalResult = Math.round(fltTempSum);
            textFinalResult.setText(String.valueOf(intFinalResult));
        }else{
            textFinalResult.setText(String.valueOf(fltTempSum));
        }

    }

    public void performDivide(Float oper1){
        if(fltTempSum != null){
            fltTempSum = fltTempSum / oper1;
        }else{
            fltTempSum = oper1;
        }
        isDecimalNumber = false;
        strTempSum = "";
        textFinalResult.setText(String.valueOf(fltTempSum));

    }

    public void performMultiply(Float oper1){
        if(fltTempSum != null){
            fltTempSum = fltTempSum * oper1;
        }else{
            fltTempSum = oper1;
        }
        isDecimalNumber = false;
        strTempSum = "";
        if(!isResultDecimal) {
            intFinalResult = Math.round(fltTempSum);
            textFinalResult.setText(String.valueOf(intFinalResult));
        }else{
            textFinalResult.setText(String.valueOf(fltTempSum));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);


    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

}
