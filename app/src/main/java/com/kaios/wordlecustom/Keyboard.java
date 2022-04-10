package com.kaios.wordlecustom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.Button;

import java.util.Hashtable;
import java.util.Objects;

public class Keyboard {
    private static Keyboard INSTANCE = null;
    private final static int[][] buttonsIdString = new int[][] {
            new int[]{ R.id.A,R.string.a}, new int[]{R.id.Z,R.string.z}, new int[]{R.id.E,R.string.e},
            new int[]{ R.id.R,R.string.r}, new int[]{R.id.T,R.string.t},
            new int[]{ R.id.Y,R.string.y}, new int[]{R.id.U,R.string.u}, new int[]{R.id.I,R.string.i},
            new int[]{ R.id.O,R.string.o}, new int[]{R.id.P,R.string.p}
    };
    private final Hashtable<Integer, Button> buttons;
    private ColorStateList[] color;
    private int nbButttons = 10;

    private Keyboard() {
        buttons = new Hashtable<>();
    }

    public static Keyboard getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Keyboard();
        }
        return(INSTANCE);
    }

    public void setup(Context context, View view){
        color = new ColorStateList[3];
        color[2] =  ColorStateList.valueOf(context.getResources().getColor(R.color.key_green));
        color[1] =  ColorStateList.valueOf(context.getResources().getColor(R.color.key_yellow));
        color[0] =  ColorStateList.valueOf(context.getResources().getColor(R.color.key_grey));

        for (int[] idString : buttonsIdString) {
            Button b = view.findViewById(idString[0]);
            buttons.put(idString[0], b);
            b.setOnClickListener(view1 -> WordleHandler.getInstance().letterPressed(idString[1]));
        }

        Button backspaceBtn = view.findViewById(R.id.Backspace);
        backspaceBtn.setOnClickListener(view1 -> WordleHandler.getInstance().backspacePressed());

        Button enterBtn = view.findViewById(R.id.Enter);
        enterBtn.setOnClickListener(view1 -> WordleHandler.getInstance().enterPressed());
    }


    public void colorize(int letter, int colorId) {
        int i =0;
        while( i < nbButttons ){
            if(buttonsIdString[i][1] == letter){
                Objects.requireNonNull(buttons.get(buttonsIdString[i][0])).setBackgroundTintList(color[colorId]);
                break;
            }
            i++;
        }

    }
}
