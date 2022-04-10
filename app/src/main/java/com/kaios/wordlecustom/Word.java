package com.kaios.wordlecustom;

import android.view.View;
import java.util.ArrayList;

public class Word {
    private final ArrayList<Letter> letters;
    private static final int[] idlist = {R.id.letter11, R.id.letter12,R.id.letter13, R.id.letter14,R.id.letter15,
            R.id.letter21, R.id.letter22,R.id.letter23, R.id.letter24,R.id.letter25};

    private int nbLettersWritten;

    public Word(int nb, View view){
        letters = new ArrayList<>();
        for(int i =0; i<5; ++i){
        letters.add(new Letter(idlist[(nb-1)*5+i], view));
        }
        nbLettersWritten = 0;
    }

    public void writeLetter(String letter){
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

    public void delete() {
        if(nbLettersWritten<=0){
            return;
        }
        nbLettersWritten--;
        letters.get(nbLettersWritten).eraseLetter();

    }

    public boolean isFull() {
        return nbLettersWritten >= 5;
    }
}
