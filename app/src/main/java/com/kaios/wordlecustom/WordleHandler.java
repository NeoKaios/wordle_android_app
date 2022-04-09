package com.kaios.wordlecustom;

import android.view.View;

public class WordleHandler {
    private static WordleHandler INSTANCE = null;
    private Keyboard keyboard;
    private Word currentWord;

    private WordleHandler() {
    };

    public static WordleHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WordleHandler();
        }
        return(INSTANCE);
    }
    public void startGame(View view){
        currentWord = new Word(1, view);
        keyboard = Keyboard.getInstance();
    }


}
