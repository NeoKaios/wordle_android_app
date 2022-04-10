package com.kaios.wordlecustom;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class WordleHandler {
    private static WordleHandler INSTANCE = null;
    private final Keyboard keyboard;
    private Word currentWord;
    private String answer;
    private Hashtable<Integer, String > converter;
    private Word[] words;
    private int wordCnt;
    private int green;
    private int grey;
    private int yellow;
    private int red;
    private int white;

    private WordleHandler() {
        keyboard = Keyboard.getInstance();
    }

    public static WordleHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WordleHandler();
        }
        return(INSTANCE);
    }

    public void startGame(Context context, View wordGrid, View keyboardView){
        populateConverter(context);
        green = context.getResources().getColor(R.color.green);
        yellow = context.getResources().getColor(R.color.yellow);
        grey = context.getResources().getColor(R.color.grey);
        red = context.getResources().getColor(R.color.red);
        white = context.getResources().getColor(R.color.white);
        words = new Word[] { new Word(1, wordGrid), new Word(2, wordGrid), new Word(3, wordGrid), new Word(4, wordGrid), new Word(5, wordGrid), new Word(6, wordGrid)};
        wordCnt= 0;
        currentWord = words[wordCnt];
        keyboard.setup(context, keyboardView);
        WordDictionary.getInstance().FillDictionary(context);
        answer = WordDictionary.getInstance().pickWord(context);
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
        currentWord.flashRed(white, white);
        currentWord.delete();
    }

    public void enterPressed() {
        if(!currentWord.isFull()){
            return;
        }
        //todo check if real word, else shake
        StringBuilder wordBuilder = new StringBuilder();
        for (String letter : currentWord.getWord()){
            wordBuilder.append(letter);
        }
        String word = wordBuilder.toString();
        if(!WordDictionary.getInstance().isAWord(word)){
            currentWord.flashRed(white, red);
            return;
        }
        colorizeWord();

        if(wordCnt>=6){
            return;
        }
        wordCnt++;
        currentWord = words[wordCnt];
    }
    
    public int getLetterId(String letter){
        for (Map.Entry<Integer, String> entry : converter.entrySet()) {
            if (entry.getValue().equals(letter)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    private void colorizeWord(){
        String[] word = currentWord.getWord();
        HashSet<Integer> buttons = new HashSet<>();

        String[] correct = new String[] { answer.substring(0,1), answer.substring(1,2), answer.substring(2,3), answer.substring(3,4), answer.substring(4,5)};
        int[] colorationIdList = new int[]{grey,grey,grey,grey,grey };
        //checking green
        for(int i =0; i<5; ++i){
            if(word[i].equals(correct[i])){
                colorationIdList[i] = green;
                int letterId = getLetterId(word[i]);
                keyboard.colorize(letterId, 2);
                buttons.add(letterId);
                word[i] = "_";
                correct[i] = "-";
            }
        }
        //checking yellow
        for (int i=0; i<5; i++){
            if(word[i].equals("_")){
                continue;
            }
            int j = 0;
            while(j<5){
                if(correct[j].equals(word[i])){
                    colorationIdList[i] = yellow;
                    int letterId = getLetterId(word[i]);
                    if(!buttons.contains(letterId)){
                        keyboard.colorize(letterId, 1);
                        buttons.add(letterId);
                    }
                    word[i] = "_";
                    correct[j] = "-";
                    break;
                }
                j++;
            }
        }
        //check grey
        for(int i =0; i<5; ++i){
            if(!word[i].equals("_")){
                int letterId = getLetterId(word[i]);
                if(!buttons.contains(letterId)){
                    keyboard.colorize(letterId, 0);
                    buttons.add(letterId);
                }
            }
        }

        currentWord.colorize(colorationIdList);


    }
}
