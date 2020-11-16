package com.foxminded.collectionframework.domain;

import java.util.Map;

public interface SentenceRepository {
    boolean isPresent(String sentence);

    void put(String sentence, Map<Character, Integer> param);

    Map<Character, Integer> get(String sentence);
}
