package com.kaios.wordlecustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button b = findViewById(R.id.R);
        TextView tv = findViewById(R.id.text11);

        b.setOnClickListener(view -> {
            CharSequence l = tv.getText();
            if (l == "R") {
                tv.setText("L");
            } else {
                tv.setText("R");
            }
        });

        getString(R.string.a);
        WordleHandler.getInstance().startGame(getApplicationContext() ,findViewById(R.id.wordgrid), findViewById(R.id.keyboard));



    }
}