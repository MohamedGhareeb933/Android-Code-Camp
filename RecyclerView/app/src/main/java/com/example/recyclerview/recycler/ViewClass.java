package com.example.recyclerview.recycler;

public class ViewClass {

    private int imageRes;
    private String text1;
    private String text2;


    public ViewClass(int imageRes, String string1, String string2) {
        this.imageRes = imageRes;
        this.text1 = string1;
        this.text2 = string2;
    }

    public void changeText(String text) {
        this.text1 = text;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
