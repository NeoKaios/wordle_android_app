package com.kaios.wordlecustom;

import android.view.View;

import java.util.ArrayList;

public class Word {
    private final ArrayList<Letter> letters;
    private static int[] idlist = {R.id.text11, R.id.text12,R.id.text13, R.id.text14,R.id.text15 };

    private int nbLettersWritten;

    public Word(int nb, View view){
        letters = new ArrayList<>();
        for(int i =0; i<5; ++i){
        letters.add(new Letter(idlist[(nb-1)*5+i], view));
        }
        nbLettersWritten = 0;
    }

    private void writeLetter(char letter){
        if(nbLettersWritten>=5){
            return;
        }
        letters.get(nbLettersWritten).writeLetter(letter);
        nbLettersWritten++;
    }
    public String getWord(){
        if(nbLettersWritten!=5){
            return "ISSUES";
        }
        else{
            StringBuilder res = new StringBuilder();
            for(int i =0; i<5; ++i){
                res.append(letters.get(i).getLetter());
            }
            return res.toString();
        }
    }
}
