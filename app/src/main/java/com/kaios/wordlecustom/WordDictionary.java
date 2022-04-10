package com.kaios.wordlecustom;

import android.content.Context;
import android.util.Log;

import androidx.annotation.RequiresPermission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class WordDictionary {
    private static WordDictionary INSTANCE = null;
    private ArrayList<String> dictionary;
    private  ArrayList<String> selectableWords;
    private WordDictionary() {
        dictionary = new ArrayList<>();
        selectableWords = new ArrayList<>();
    }

    public static WordDictionary getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WordDictionary();
        }
        return(INSTANCE);
    }

    public void FillDictionary(Context context)  {
        String string = "";
        InputStream is = context.getResources().openRawResource(R.raw.words);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (true) {
            try {
                if ((string = reader.readLine()) == null) break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("WWW", string);
            dictionary.add(string);
        }
        try {
            is.close();
        }
        catch (IOException ignored){

        }
    }

    public boolean isAWord(String word){
        return dictionary.contains(word);
    }

    public String pickWord(Context context) {
        if(selectableWords.isEmpty()){
            FillSelectable(context);
        }
        return selectableWords.get(new Random().nextInt(selectableWords.size()));

    }

    private void FillSelectable(Context context) {
        selectableWords = dictionary; //todo
    }
}
