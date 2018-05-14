package com.example.avraham.homeWork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView _screen;
    private String _screenTxt;
    private String _num1, _num2;
    private String _sign;

    private boolean _isOnError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        _screen = (TextView)findViewById(R.id.screen_result);
        initStrings();
    }

    public void number_onClick(View view) {
        isOnErrorHandler();

        Button btn = (Button) view;
        String value =  btn.getText().toString();

        if(_sign.equals("")){
            if(value.equals(".") && _num1.contains(".")) {
                _screenTxt = "Error: Too many dots";
                _isOnError = true;
            }
            else {
                _screenTxt += value;
                _num1 += value;
            }
        }
        else{
            if(value.equals(".") && _num2.contains(".")) {
                _screenTxt = "Error: Too many dots";
                _isOnError = true;
            }
            else {
                _screenTxt += value;
                _num2 += value;
            }
        }

        _screen.setText(_screenTxt);
    }

    public void signs_onClick(View view) {
        isOnErrorHandler();

        Button btn = (Button) view;
        String value =  btn.getText().toString();
        if(_sign.length() == 0){
            _screenTxt += value;
            _sign = value;
        }
        else{
            initStrings();
            _screenTxt = "ERROR: Too complex for me";
            _isOnError = true;
        }

        _screen.setText(_screenTxt);
    }

    public void erase_onClick(View view) {
        isOnErrorHandler();

        Button btn = (Button) view;
        String eraser = btn.getText().toString();
        if(eraser.equals("C")){
            if(_num2.length() > 0)
                _num2 = _num2.substring(0, _num2.length()-1);
            else if (_sign.length() > 0)
                _sign = _sign.substring(0, _sign.length()-1);
            else if (_num1.length() > 0)
                _num1 = _num1.substring(0, _num1.length()-1);

            if(_screenTxt.length() > 0)
                _screenTxt = _screenTxt.substring(0, _screenTxt.length()-1);
        }
        else if (eraser.equals("CE")){
            initStrings();
        }

        _screen.setText(_screenTxt);
    }

    public void calc_onClick(View view) {
        double num1, num2;
        double result = 0;

        //validate input
        if(_isOnError){_screenTxt = "ERROR: Illegal attempt"; }
        else if (_sign.length() == 0) {
            _screenTxt = "ERROR: Illegal attempt";
            _isOnError = true;
        }
        if(_num1.length() == 0 || _num1.equals(".")){
            if(_sign.equals("-")) {_num1 = "0";}
            else {_screenTxt = "ERROR: First number is missing"; }
            _isOnError = true;
        }
        if(_num2.length() == 0|| _num2.equals(".")){
            _screenTxt = "ERROR: Second number is missing";
            _isOnError = true;
        }

        if(_isOnError){
            _screen.setText(_screenTxt);
            return;
        }

        num1 = Double.parseDouble(_num1);
        num2 = Double.parseDouble(_num2);

        if(_sign.equals("-")){ result = num1 - num2;}
        else if(_sign.equals("+")){ result = num1 + num2;}
        else if(_sign.equals("X")){ result = num1 * num2;}
        else if(_sign.equals("/")){
            if(num2 == 0){
                _screenTxt = "ERROR: Divide by 0";
                _isOnError = true;
            }
            else{ result = num1 / num2;}
        }

        if(!_isOnError) {
            initStrings();
            _screenTxt = _num1 =Double.toString(result);
        }

        _screen.setText(_screenTxt);
    }


    private void initStrings(){
        _isOnError= false;
        _screenTxt = "";
        _num1 = _num2 = _sign = "";
    }

    private void isOnErrorHandler(){
        if (_isOnError){
            initStrings();
            _isOnError = false;
        }
    }
}
