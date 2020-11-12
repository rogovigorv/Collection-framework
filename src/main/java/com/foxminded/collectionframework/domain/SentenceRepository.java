package com.foxminded.collectionframework.domain;

import java.util.Map;

public interface SentenceRepository {
    boolean containsKey(String sentence);

    String toString(String sentence);

    void addToCache(String sentence, Map<Character, Integer> param);
}
