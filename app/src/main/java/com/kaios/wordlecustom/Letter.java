package com.kaios.wordlecustom;

import android.view.View;
import android.widget.TextView;

public class Letter {

    private TextView tv;
    private char value;

    public Letter(int id, View view ){
        tv = (TextView)view.findViewById(id);
    }

    public void writeLetter(char letter){
        tv.setText(letter);
        value = letter;
    }

    public void eraseLetter(){
        tv.setText("");
    }

    public char getLetter(){
        return value;
    }
}
