package com.foxminded.collectionframework.formatter;

import com.foxminded.collectionframework.domain.SentenceRepository;
import java.util.Map;

public class FormatterImpl implements Formatter {

    private static final String LINE_BREAK = "\n";
    private static final String QUOTATION_MARK = "\"";
    private static final String DASH = " - ";

    @Override
    public String toString(String sentence, SentenceRepository sentenceRepository) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> innerMap;
        innerMap = sentenceRepository.get(sentence);
        for (Map.Entry<Character, Integer> pair : innerMap.entrySet()) {
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
}
