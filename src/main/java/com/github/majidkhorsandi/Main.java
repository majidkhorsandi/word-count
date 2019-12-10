package com.github.majidkhorsandi;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Map<String, Integer> wordsInFile;
        try {
            wordsInFile = counter.countWordsInFile("/Users/majid/code/word-count/src/main/resources/words.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        List<Map.Entry<String, Integer>> sorted = Sorter.sort(wordsInFile);
        sorted.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

}
