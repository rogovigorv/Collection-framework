package com.foxminded.collectionframework.domain;

import java.util.Map;

public class SentenceRepositoryImpl implements SentenceRepository {

    private final Map<String, Map<Character, Integer>> sentenceRepositoryMap;

    public SentenceRepositoryImpl(Map<String, Map<Character, Integer>> map) {
        this.sentenceRepositoryMap = map;
    }

    @Override
    public boolean isPresent(String sentence) {
        return sentenceRepositoryMap.containsKey(sentence);
    }

    @Override
    public void put(String sentence, Map<Character, Integer> param) {
        this.sentenceRepositoryMap.put(sentence, param);
    }

    @Override
    public Map<Character, Integer> get(String sentence) {
        return this.sentenceRepositoryMap.get(sentence);
    }
}
