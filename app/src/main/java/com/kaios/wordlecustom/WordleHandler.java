package com.kaios.wordlecustom;

import android.content.Context;
import android.view.View;

import java.util.Hashtable;

public class WordleHandler {
    private static WordleHandler INSTANCE = null;
    private final Keyboard keyboard;
    private Word currentWord;
    private Hashtable<Integer, String > converter;

    private WordleHandler() {
        keyboard = Keyboard.getInstance();
    }

    public static WordleHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WordleHandler();
        }
        return(INSTANCE);
    }
    public void startGame(Context context, View wordgrid, View keyboardView){
        populateConverter(context);
        currentWord = new Word(1, wordgrid);
        keyboard.setup(keyboardView);
    }

    private void populateConverter(Context context) {
        converter = new Hashtable<>();
        converter.put(R.string.a, context.getString(R.string.a));
        converter.put(R.string.b, context.getString(R.string.b));
        converter.put(R.string.c, context.getString(R.string.c));
        converter.put(R.string.d, context.getString(R.string.d));
        converter.put(R.string.e, context.getString(R.string.e));
        converter.put(R.string.f, context.getString(R.string.f));
        converter.put(R.string.g, context.getString(R.string.g));
        converter.put(R.string.h, context.getString(R.string.h));
        converter.put(R.string.i, context.getString(R.string.i));
        converter.put(R.string.j, context.getString(R.string.j));
        converter.put(R.string.k, context.getString(R.string.k));
        converter.put(R.string.l, context.getString(R.string.l));
        converter.put(R.string.m, context.getString(R.string.m));
        converter.put(R.string.n, context.getString(R.string.n));
        converter.put(R.string.o, context.getString(R.string.o));
        converter.put(R.string.p, context.getString(R.string.p));
        converter.put(R.string.q, context.getString(R.string.q));
        converter.put(R.string.r, context.getString(R.string.r));
        converter.put(R.string.s, context.getString(R.string.s));
        converter.put(R.string.t, context.getString(R.string.t));
        converter.put(R.string.u, context.getString(R.string.u));
        converter.put(R.string.v, context.getString(R.string.v));
        converter.put(R.string.w, context.getString(R.string.w));
        converter.put(R.string.x, context.getString(R.string.x));
        converter.put(R.string.y, context.getString(R.string.y));
        converter.put(R.string.z, context.getString(R.string.z));
    }

    public void letterPressed(int stringId){
        currentWord.writeLetter(converter.get(stringId));
    }

    public void backspacePressed() {
        currentWord.delete();
    }

    public void enterPressed() {

    }
}
