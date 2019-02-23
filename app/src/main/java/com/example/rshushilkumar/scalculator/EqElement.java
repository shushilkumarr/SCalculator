package com.example.rshushilkumar.scalculator;

public class EqElement {
    private String type;
    private String value;
    private int pos;

    String getType(){
        return type;
    }
    String getValue(){
        return value;
    }
    int getPos(){
        return pos;
    }
    EqElement(String type,String value,int pos){
        this.type=type;
        this.value=value;
        this.pos=pos;
    }
}
