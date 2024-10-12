package com.example.traducir;

public class Palabra {
    private final String english;
    private final int img;

    public Palabra(String english, int img) {
        this.english = english;
        this.img = img;
    }

    public String getEnglish() {
        return english;
    }

    public int getImg() {
        return img;
    }
}
