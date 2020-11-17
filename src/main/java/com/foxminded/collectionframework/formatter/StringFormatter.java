package com.foxminded.collectionframework.formatter;

import com.foxminded.collectionframework.domain.Repository;
import java.util.Map;

public class StringFormatter implements Formatter {

    private static final String LINE_BREAK = "\n";
    private static final String QUOTATION_MARK = "\"";
    private static final String DASH = " - ";

    @Override
    public String format(String sentence, Repository sentenceRepository) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> innerMap;
        innerMap = sentenceRepository.get(sentence);
        for (Map.Entry<Character, Integer> pair : innerMap.entrySet()) {
            Character symbol = pair.getKey();
            Integer symbolCount = pair.getValue();
            result.append(QUOTATION_MARK)
                    .append(symbol)
                    .append(QUOTATION_MARK)
                    .append(DASH)
                    .append(symbolCount)
                    .append(LINE_BREAK);
        }

        return result.toString();
    }
}
