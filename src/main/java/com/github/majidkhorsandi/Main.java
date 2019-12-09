package com.github.majidkhorsandi;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader;
        try {
             fileReader = new FileReader(new File("/Users/majid/code/word-count/src/main/resources/words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        String[] wordsInLine = line.split("\\s");
        Map<String, Integer> wordCounts = new HashMap<String, Integer>();
        Arrays.stream(wordsInLine).forEach(word -> {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        });
        wordCounts.forEach((w, c)-> System.out.println(w + ": " + c));
    }
}
