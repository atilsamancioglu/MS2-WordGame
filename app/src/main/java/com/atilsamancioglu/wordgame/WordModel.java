package com.atilsamancioglu.wordgame;

import java.util.ArrayList;

public class WordModel {

    String categoryName;
    ArrayList<String> gameWords;

    public WordModel(String categoryName, ArrayList<String> gameWords) {
        this.categoryName = categoryName;
        this.gameWords = gameWords;
    }
}
