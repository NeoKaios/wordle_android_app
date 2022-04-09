package com.kaios.wordlecustom;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

public class Letter {

    private TextView tv;
    private String value;

    public Letter(int id, View view ){
        tv = (TextView)view.findViewById(id);
        tv.setText(R.string.b);
    }

    public void writeLetter(String letter){
        tv.setText(letter);
        value = letter;
    }

    public void eraseLetter(){
        tv.setText("");
    }

    public String getLetter(){
        return value;
    }
}
