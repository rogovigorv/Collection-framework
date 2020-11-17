package com.foxminded.collectionframework.formatter;

import com.foxminded.collectionframework.domain.Repository;

public interface Formatter {

    String format(String sentence, Repository sentenceRepository);
}
