package com.github.majidkhorsandi;

import java.io.*;
import java.util.*;

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
        Map<String, Integer> wordCounts = new HashMap<>();
        Arrays.stream(wordsInLine).forEach(word -> {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        });

        List<Map.Entry<String, Integer>> sorted = sort(wordCounts);
        sorted.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static List<Map.Entry<String, Integer>> sort(Map<String, Integer> wordCount) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        entries.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return 0;
            } else if (o1.getValue() < o2.getValue()) {
                return 1;
            } else {
                return -1;
            }
        });
        return entries;
    }
}
