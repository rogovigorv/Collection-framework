package com.foxminded.collectionframework.formatter;

import com.foxminded.collectionframework.domain.Repository;

import java.util.Map;

public interface Formatter {

    String format(String sentence, Map<Character, Integer> innerMap);
}
