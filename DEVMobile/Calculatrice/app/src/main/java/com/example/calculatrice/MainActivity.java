package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView screen;
    private int op1 = -1;
    private int op2 = -1;
    private char operator = 0;
    private boolean isOp1=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    };

    public void addNumber(View v){

        int val = Integer.parseInt(((Button)v).getText().toString());
        if(val == '='){
            if(op1 != -1 && op2 != -1 && operator != 0){
                switch(operator) {
                    case '+'  : op1 = op1 + op2; break;
                    case '-' : op1 = op1 - op2; break;
                    case '*'  : op1 = op1 * op2; break;
                    case '/'   : op1 = op1 / op2; break;
                    default : return;
                }
                ((TextView) findViewById(R.id.salut)).setText(op1);
                op1=-1;
                op2=-1;
                operator = 0;
            }else{
                ((TextView) findViewById(R.id.salut)).setText("Pas possible de le faire");
            }
        }



    }
}