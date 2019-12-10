package com.github.majidkhorsandi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Sorter {
    static List<Map.Entry<String, Integer>> sort(Map<String, Integer> wordCount) {
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
