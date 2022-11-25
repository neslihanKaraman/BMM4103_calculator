package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    TextView prevValue;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prevValue=findViewById(R.id.prev_txt);
        display=findViewById(R.id.display_txt);

    }
    public void upDate(String str){
        String backStr=display.getText().toString();
        int cursor=display.getSelectionStart();
        String leftStr=backStr.substring(0,cursor);
        String rightStr=backStr.substring(cursor);
        display.setText(String.format("%s%s%s",leftStr,str,rightStr));
        display.setSelection(cursor+str.length());

    }
    public void zeroBtnPush(View view){upDate("0");}
    public void oneBtnPush(View view){upDate("1");}
    public void twoBtnPush(View view){upDate("2");}
    public void threeBtnPush(View view){upDate("3");}
    public void fourBtnPush(View view){upDate("4");}
    public void fiveBtnPush(View view){upDate("5");}
    public void sixBtnPush(View view){upDate("6");}
    public void sevenBtnPush(View view){upDate("7");}
    public void eightBtnPush(View view){upDate("8");}
    public void nineBtnPush(View view){upDate("9");}
    public void divideBtnPush(View view){upDate("/");}
    public void multiplyBtnPush(View view){upDate("x");}
    public void subtractBtnPush(View view){upDate("-");}
    public void addBtnPush(View view){upDate("+");}
    public void clearBtnPush(View view){
        display.setText(" ");
        prevValue.setText(" ");

    }
    public void pOpenBtnPush(View view){upDate("(");}
    public void pCloseBtnPush(View view){upDate(")");}
    public void equalBtnPush(View view){
        prevValue.setText(display.getText());
        String user=display.getText().toString();
        user=user.replaceAll(getResources().getString(R.string.multiplyText),"*");

        Expression exp=new Expression(user);
        String result=String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void decimalBtnPush(View view){upDate(".");}
    public void backSpaceBtnPush(View view){
        int cursor=display.getSelectionStart();
        int txtLen=display.getText().length();

        if(cursor!=0 && txtLen!=0)
        {
            SpannableStringBuilder select=(SpannableStringBuilder)display.getText();
            select.replace(cursor-1,cursor," ");
            display.setText(select);
            display.setSelection(cursor-1);
        }

    }
    public void cosBtnPush(View view){upDate("cos(");}
    public void sinBtnPush(View view){upDate("sin(");}
    public void tanBtnPush(View view){upDate("tan(");}
    public void arcSinBtnPush(View view){upDate("arcsin(");}
    public void arcTanBtnPush(View view){upDate("arctan(");}
    public void arcCosBtnPush(View view){upDate("arccos");}
    public void squareBtnPush(View view){upDate("sqrt(");}
    public void powerBtnPush(View view){upDate("^(");}
    public void logBtnPush(View view){upDate("log(");}

}