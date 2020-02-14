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

    Button submitButton;
    Button arrayButton;
    TextView arrayText;
    EditText responseText;
    TextView displayText;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.clickButton);
        arrayButton=findViewById(R.id.clickButton2);
        responseText=findViewById(R.id.responseEditText);
        displayText=findViewById(R.id.textBox);
        arrayText=findViewById(R.id.textBox2);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("testButton","input is: "+responseText.getText());
                displayText.setText(responseText.getText());
            }
        });
        arrayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("arrayButton","count is:" + count);
                count += 1;
                Resources res = getResources();
                String[] food = res.getStringArray(R.array.string_array);
                arrayText.setText(food[count%5]);
            }
        });
    }
}
