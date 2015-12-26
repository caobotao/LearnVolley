package com.example.caobotao.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_add;
    Button btn_subtract;
    Button btn_multiply;
    Button btn_divide;
    Button btn_dot;
    Button btn_clear;
    Button btn_delete;
    Button btn_equal;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_zero);
        btn_1 = (Button) findViewById(R.id.btn_one);
        btn_2 = (Button) findViewById(R.id.btn_two);
        btn_3 = (Button) findViewById(R.id.btn_three);
        btn_4 = (Button) findViewById(R.id.btn_four);
        btn_5 = (Button) findViewById(R.id.btn_five);
        btn_6 = (Button) findViewById(R.id.btn_six);
        btn_7 = (Button) findViewById(R.id.btn_seven);
        btn_8 = (Button) findViewById(R.id.btn_eight);
        btn_9 = (Button) findViewById(R.id.btn_nine);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_subtract = (Button) findViewById(R.id.btn_subtract);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        et = (EditText) findViewById(R.id.et);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_subtract.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = et.getText().toString();
        switch (v.getId()){
            case R.id.btn_zero:
            case R.id.btn_one:
            case R.id.btn_two:
            case R.id.btn_three:
            case R.id.btn_four:
            case R.id.btn_five:
            case R.id.btn_six:
            case R.id.btn_seven:
            case R.id.btn_eight:
            case R.id.btn_nine:
                et.setText(str+((Button)v).getText() );
                break;
            case R.id.btn_dot:
                clickDot();
                break;
            case R.id.btn_add:
            case R.id.btn_subtract:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if(!( str.contains("+") || str.contains("-") || str.contains("x") || str.contains("÷"))) {
                    if(!(str == null || "".equals(str))){
                        et.setText(str + " " + ((Button) v).getText() + " ");
                    }
                }
                break;
            case R.id.btn_delete:
//                System.out.println("delete");
                if(str != null && !str.equals("")){
                    int sub = str.charAt(str.length()-1) == ' ' ? 2 : 1;
                    et.setText(str.substring(0,str.length()-sub));
                }
                break;
            case R.id.btn_clear:
                et.setText("");
                break;
            case R.id.btn_equal:
                getResult();
                break;
        }
    }

    private void clickDot() {
        String input = et.getText().toString();
        boolean isHasOp = false;
        isHasOp = input.contains(" ");
        if(isHasOp){
            String sAfterOp = input.substring(input.lastIndexOf(" "));
            if(sAfterOp.contains(".")){
                return;
            }
            else {
                et.setText(et.getText().toString() + ".");
            }
        }
        else{
            if(input.contains(".")){
                return;
            }
            else {
                et.setText(et.getText().toString() + ".");
            }
        }
    }

    private void getResult(){
        String exp = et.getText().toString();
        if(exp == null || exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        double result = 0;
        String s1 = exp.substring(0,exp.indexOf(" "));//运算符前面的数字
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);//运算符
        String s2 = exp.substring(exp.indexOf(" ")+3);//运算符后面的数字
//        Log.i("S2","aaa"+s2+"aaa");
        if(s2 == null || "".equals(s2.trim())){
            return;
        }
        if(s1 != "" && s2 != ""){
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if("+".equals(op)){
                result = d1 + d2;
            }
            else if ("-".equals(op)){
                result = d1 - d2;
            }
            else if ("x".equals(op)){
                result = d1 * d2;
            }
            else if ("÷".equals(op)){
                if(d2 == 0){
                    return;
                }
                result = d1 / d2;
            }
//            System.out.println(eliminateZeroAfterDot("3.00"));
//            Log.i("RESULT",result + "");
//            et.setText(result + "");
            et.setText(eliminateZeroAfterDot(result+""));
        }
    }
    private String eliminateZeroAfterDot(String number){

        if(!number.contains(".")){
            return number;
        }
        String numAfterDot = number.substring(number.indexOf('.') + 1);
        String re = "[0]{" + numAfterDot.length() + "}";
        if(numAfterDot.matches(re)){
            return number.substring(0, number.indexOf('.'));
        }
        return number;
    }
}
















