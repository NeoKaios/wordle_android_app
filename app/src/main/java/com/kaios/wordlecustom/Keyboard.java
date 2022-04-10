package com.kaios.wordlecustom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Objects;

public class Keyboard {
    private static Keyboard INSTANCE = null;
    private final static int[][] buttonsIdString = new int[][] {
            new int[]{ R.id.A,R.string.a}, new int[]{R.id.Z,R.string.z}, new int[]{R.id.E,R.string.e}, new int[]{ R.id.R,R.string.r}, new int[]{R.id.T,R.string.t},
            new int[]{ R.id.Y,R.string.y}, new int[]{R.id.U,R.string.u}, new int[]{R.id.I,R.string.i}, new int[]{ R.id.O,R.string.o}, new int[]{R.id.P,R.string.p},
            new int[]{ R.id.Q,R.string.q}, new int[]{R.id.S,R.string.s}, new int[]{R.id.D,R.string.d}, new int[]{ R.id.F,R.string.f}, new int[]{R.id.G,R.string.g},
            new int[]{ R.id.H,R.string.h}, new int[]{R.id.J,R.string.j}, new int[]{R.id.K,R.string.k}, new int[]{ R.id.L,R.string.l}, new int[]{R.id.M,R.string.m},
            new int[]{ R.id.W,R.string.w}, new int[]{R.id.X,R.string.x}, new int[]{R.id.C,R.string.c}, new int[]{ R.id.V,R.string.v}, new int[]{R.id.B,R.string.b},
            new int[]{ R.id.N,R.string.n}
    };
    private final Hashtable<Integer, Button> keys;
    private final HashSet<Integer> greenKeys;
    private ColorStateList[] color;

    private Keyboard() {
        keys = new Hashtable<>();
        greenKeys = new HashSet<>();
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
            keys.put(idString[0], b);
            b.setOnClickListener(view1 -> WordleHandler.getInstance().letterPressed(idString[1]));
        }

        Button backspaceBtn = view.findViewById(R.id.Backspace);
        backspaceBtn.setOnClickListener(view1 -> WordleHandler.getInstance().backspacePressed());

        Button enterBtn = view.findViewById(R.id.Enter);
        enterBtn.setOnClickListener(view1 -> WordleHandler.getInstance().enterPressed());
    }


    public void colorize(int letter, int colorId) {
        int i =0;
        int nbKeys = 26;
        while( i < nbKeys){
            if(buttonsIdString[i][1] == letter){
                if(greenKeys.contains(buttonsIdString[i][0])){ //if already green, the key remains green (cannot become yellow)
                    break;
                }
                Objects.requireNonNull(keys.get(buttonsIdString[i][0])).setBackgroundTintList(color[colorId]);
                if(colorId == 2){
                    greenKeys.add(buttonsIdString[i][0]);
                }
                break;
            }
            i++;
        }

    }
}
