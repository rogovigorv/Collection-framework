package com.foxminded.collectionframework.provider;

import com.foxminded.collectionframework.domain.SentenceRepository;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounterProviderImpl implements CharCounterProvider {
    private static final int SYMBOL_COUNT = 1;

    @Override
    public String checkInCache(String sentence, SentenceRepository sentenceRepository) {
        String result;
        if (sentenceRepository.containsKey(sentence)) {
            result = sentenceRepository.toString(sentence);
        } else {
            result = charCalculator(sentence, sentenceRepository);
        }

        return result;
    }

    private String charCalculator(String sentence, SentenceRepository sentenceRepository) {
        Map<Character, Integer> calculationResultMap = new LinkedHashMap<>();

        char[] sentenceChars = sentence.toCharArray();

        for (char symbol : sentenceChars) {
            if (!calculationResultMap.containsKey(symbol)) {
                calculationResultMap.put(symbol, SYMBOL_COUNT);
            } else {
                calculationResultMap.put(symbol, calculationResultMap.get(symbol) + SYMBOL_COUNT);
            }
        }
        sentenceRepository.addToCache(sentence, calculationResultMap);

        return sentenceRepository.toString(sentence);
    }
}
