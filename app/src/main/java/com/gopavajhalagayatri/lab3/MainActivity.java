package com.gopavajhalagayatri.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView one;
    TextView two;
    TextView three;
    TextView four;
    int[] count = {0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.textBox);
        two=findViewById(R.id.textBox2);
        three=findViewById(R.id.textBox3);
        four=findViewById(R.id.textBox4);
        Listener x = new Listener();
        one.setOnClickListener(x);
        two.setOnClickListener(x);
        three.setOnClickListener(x);
        four.setOnClickListener(x);
    }

    public class Listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            TextView current = (TextView) v;
            if(current == one){
                count[0] += 1;
            }else if(current == two){
                count[1] += 1;
            }else if(current == three){
                count[2] += 1;
            }else if(current == four){
                count[3] += 1;
            }
        }
    }
}
