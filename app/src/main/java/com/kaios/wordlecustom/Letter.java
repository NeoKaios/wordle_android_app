package com.kaios.wordlecustom;

import android.view.View;
import android.widget.TextView;

public class Letter {

    private final TextView tv;
    private String value;

    public Letter(int id, View view ){
        tv = view.findViewById(id);
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

    public void colorize(int color) {
        tv.setBackgroundColor(color);
    }

    public void colorizeText(int color) {
        tv.setTextColor(color);
    }
}
