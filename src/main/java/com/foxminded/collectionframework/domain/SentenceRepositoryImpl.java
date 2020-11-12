package com.foxminded.collectionframework.domain;

import java.util.Map;

public class SentenceRepositoryImpl implements SentenceRepository {
    private static final String LINE_BREAK = "\n";
    private static final String QUOTATION_MARK = "\"";
    private static final String DASH = " - ";

    private final Map<String, Map<Character, Integer>> sentenceRepositoryMap;

    public SentenceRepositoryImpl(Map<String, Map<Character, Integer>> map) {
        this.sentenceRepositoryMap = map;
    }

    @Override
    public String toString(String sentence) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> innerMap;
        innerMap = sentenceRepositoryMap.get(sentence);
        for (Map.Entry<Character, Integer> pair : innerMap.entrySet())
        {
            Character symbol = pair.getKey();
            Integer symbolCount = pair.getValue();
            result.append(QUOTATION_MARK);
            result.append(symbol);
            result.append(QUOTATION_MARK);
            result.append(DASH);
            result.append(symbolCount);
            result.append(LINE_BREAK);
        }

        return String.valueOf(result);
    }

    @Override
    public boolean containsKey(String sentence) {
        return sentenceRepositoryMap.containsKey(sentence);
    }

    public void addToCache(String sentence, Map<Character, Integer> param) {
        this.sentenceRepositoryMap.put(sentence, param);
    }
}
