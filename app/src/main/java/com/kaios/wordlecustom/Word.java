package com.kaios.wordlecustom;

import android.view.View;
import java.util.ArrayList;

public class Word {
    private final ArrayList<Letter> letters;
    private static final int[] idlist = {R.id.letter11, R.id.letter12,R.id.letter13, R.id.letter14,R.id.letter15,
            R.id.letter21, R.id.letter22,R.id.letter23, R.id.letter24,R.id.letter25,
            R.id.letter31, R.id.letter32,R.id.letter33, R.id.letter34,R.id.letter35,
            R.id.letter41, R.id.letter42,R.id.letter43, R.id.letter44,R.id.letter45,
            R.id.letter51, R.id.letter52,R.id.letter53, R.id.letter54,R.id.letter55,
            R.id.letter61, R.id.letter62,R.id.letter63, R.id.letter64,R.id.letter65,};

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

    public String[] getWord(){
        String[] res = new String[5];
        for(int i =0; i<5; ++i){
            res[i] = letters.get(i).getLetter();
        }
        return res;
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

    public void colorize(int[] colorationIdList) {
        for(int i=0; i<5; ++i){
            letters.get(i).colorize(colorationIdList[i]);
        }
    }

    public void flashRed(int white, int red) {
        for(Letter l : letters){
            l.colorizeText(red);
        }
        /*
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        for(Letter l : letters){
            l.colorizeText(white);
        }*/


    }
}
