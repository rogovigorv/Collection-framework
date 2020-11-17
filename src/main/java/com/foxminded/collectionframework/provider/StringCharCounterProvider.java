package com.foxminded.collectionframework.provider;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCharCounterProvider implements CharCounterProvider {

    @Override
    public Map<Character, Integer> countCharacters(String sentence) {
        Map<Character, Integer> result = new LinkedHashMap<>();

        char[] sentenceChars = sentence.toCharArray();

        for (char symbol : sentenceChars) {
            if (!result.containsKey(symbol)) {
                result.put(symbol, 1);
            } else {
                result.put(symbol, result.get(symbol) + 1);
            }
        }

        return result;
    }
}
