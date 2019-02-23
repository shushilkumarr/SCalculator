package com.example.rshushilkumar.scalculator;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class MyStringParser {
    private String[] tokens;
    public MyStringParser(){}
    public void parse(String eq, Context context){
            tokens=eq.split(" ");
        Toast.makeText(context,tokens.toString(),Toast.LENGTH_LONG);
    }

}
