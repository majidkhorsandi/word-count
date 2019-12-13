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

    Map<String, Integer> wordCounts = new HashMap<>();
    bufferedReader
        .lines()
        .flatMap(l -> Arrays.stream(l.split("\\s")))
        .forEach(
            w -> {
              if (wordCounts.containsKey(w)) {
                wordCounts.put(w, wordCounts.get(w) + 1);
              } else {
                wordCounts.put(w, 1);
              }
            });
    return wordCounts;
  }
}
