package com.kaios.wordlecustom;

public class Keyboard {
    private static Keyboard INSTANCE = null;

    private Keyboard() {
    };

    public static Keyboard getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Keyboard();
        }
        return(INSTANCE);
    }



}
