package analyzer;

import java.util.*;

public class Statistics {
    private final String content;

    public Statistics(String content) {
        this.content = content;
    }

    public void printStatistics() {
        System.out.println("Line Count: " + getLineCount());
        System.out.println("Word Count: " + getWordCount());
        System.out.println("Character Count: " + getCharacterCount());
        System.out.println("Most Frequent Words:");
        printMostFrequentWords(5);
    }

    public int getLineCount() {
        return content.split("\r\n|\r|\n").length;
    }

    public int getWordCount() {
        return content.trim().isEmpty() ? 0 : content.trim().split("\\s+").length;
    }

    public int getCharacterCount() {
        return content.length();
    }

    public void printMostFrequentWords(int topN) {
        Map<String, Integer> wordFreq = new HashMap<>();
        String[] words = content.toLowerCase().split("\\W+");

        for (String word : words) {
            if (word.isEmpty()) continue;
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        wordFreq.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
