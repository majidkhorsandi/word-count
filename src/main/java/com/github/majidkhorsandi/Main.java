package com.github.majidkhorsandi;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Map<String, Integer> wordsInFile;
        LocalDateTime start = LocalDateTime.now();
        try {
            wordsInFile = counter.countWordsInFile("/Users/majid/code/word-count/src/main/resources/words.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        List<Map.Entry<String, Integer>> sorted = Sorter.sort(wordsInFile);
        Duration duration = Duration.between(start, LocalDateTime.now());
        sorted.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        System.out.printf("execution time: %s ms", duration.toMillis());
    }

}
