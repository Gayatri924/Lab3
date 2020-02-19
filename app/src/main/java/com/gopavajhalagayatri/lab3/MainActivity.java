package com.gopavajhalagayatri.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView one;
    TextView two;
    TextView three;
    TextView four;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SeekBar seekBar;
    int textSize;
    int saveProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        textSize = 12;
        editor = sharedPreferences.edit();
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
        seekBar = (SeekBar)findViewById(R.id.seekBar1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                textSize = textSize + (progress-saveProgress);
                saveProgress = progress;
                one.setTextSize(textSize);
                two.setTextSize(textSize);
                three.setTextSize(textSize);
                four.setTextSize(textSize);
            }
        });
    }

    public class Listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int[] count = {sharedPreferences.getInt("one", 0), sharedPreferences.getInt("two", 0),
                    sharedPreferences.getInt("three", 0), sharedPreferences.getInt("four", 0)};
            TextView current = (TextView) v;
            String text = "";
            if(current == one){
                count[0] += 1;
                text += "One was pressed";
            }else if(current == two){
                count[1] += 1;
                text += "Two was pressed";
            }else if(current == three){
                count[2] += 1;
                text += "Three was pressed";
            }else if(current == four) {
                count[3] += 1;
                text += "Four was pressed";
            }
            text += ". Click counts: One - " + count[0] + ", Two - " + count[1] + ", Three - " + count[2] + ", Four - " + count[3];
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            editor.putInt("one", count[0]);
            editor.putInt("two", count[1]);
            editor.putInt("three", count[2]);
            editor.putInt("four", count[3]);
            editor.apply();
        }
    }
}
