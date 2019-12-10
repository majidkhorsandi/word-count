package com.github.majidkhorsandi;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Counter {

    Map<String, Integer> countWordsInFile(String filePath) throws IOException {
        FileReader fileReader;
        fileReader = new FileReader(new File(filePath));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();
        String[] wordsInLine = line.split("\\s");
        Map<String, Integer> wordCounts = new HashMap<>();
        Arrays.stream(wordsInLine).forEach(word -> {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        });
        return wordCounts;
    }
}
