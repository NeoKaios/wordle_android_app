package com.kaios.wordlecustom;

import android.view.View;
import android.widget.Button;

public class Keyboard {
    private static Keyboard INSTANCE = null;
    private final static int[][] buttonsIdString = new int[][] {
            new int[]{ R.id.A,R.string.a}, new int[]{R.id.Z,R.string.z}, new int[]{R.id.E,R.string.e},
            new int[]{ R.id.R,R.string.r}, new int[]{R.id.T,R.string.t},
            new int[]{ R.id.Y,R.string.y}, new int[]{R.id.U,R.string.u}, new int[]{R.id.I,R.string.i},
            new int[]{ R.id.O,R.string.o}, new int[]{R.id.P,R.string.p}
    };

    private Keyboard() {

    }

    public static Keyboard getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Keyboard();
        }
        return(INSTANCE);
    }

    public void setup(View view){
        for (int[] idString : buttonsIdString) {
            Button b = view.findViewById(idString[0]);
            b.setOnClickListener(view1 -> WordleHandler.getInstance().letterPressed(idString[1]));
        }

        Button backspaceBtn = view.findViewById(R.id.Backspace);
        backspaceBtn.setOnClickListener(view1 -> WordleHandler.getInstance().backspacePressed());

        Button enterBtn = view.findViewById(R.id.Enter);
        enterBtn.setOnClickListener(view1 -> WordleHandler.getInstance().enterPressed());
    }


}
