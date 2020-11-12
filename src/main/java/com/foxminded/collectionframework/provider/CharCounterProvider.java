package com.foxminded.collectionframework.provider;

import com.foxminded.collectionframework.domain.SentenceRepository;

public interface CharCounterProvider {

    String checkInCache(String inputSentence, SentenceRepository sentenceRepository);
}
