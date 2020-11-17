package com.foxminded.collectionframework.provider;

import java.util.Map;

public interface CharCounterProvider {
    Map<Character, Integer> countCharacters(String sentence);
}
