package com.foxminded.collectionframework.provider;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounterProviderImpl implements CharCounterProvider {
    private static final int SYMBOL_COUNT = 1;

    @Override
    public Map<Character, Integer> charCalculator(String sentence) {
        Map<Character, Integer> calculationResultMap = new LinkedHashMap<>();

        char[] sentenceChars = sentence.toCharArray();

        for (char symbol : sentenceChars) {
            if (!calculationResultMap.containsKey(symbol)) {
                calculationResultMap.put(symbol, SYMBOL_COUNT);
            } else {
                calculationResultMap.put(symbol, calculationResultMap.get(symbol) + SYMBOL_COUNT);
            }
        }

        return calculationResultMap;
    }
}
