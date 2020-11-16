package com.foxminded.collectionframework.formatter;

import com.foxminded.collectionframework.domain.SentenceRepository;

public interface Formatter {

    String toString(String sentence, SentenceRepository sentenceRepository);
}
