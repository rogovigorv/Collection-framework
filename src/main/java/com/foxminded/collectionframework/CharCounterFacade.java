package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.SentenceRepository;
import com.foxminded.collectionframework.formatter.Formatter;
import com.foxminded.collectionframework.formatter.FormatterImpl;
import com.foxminded.collectionframework.provider.CharCounterProvider;
import com.foxminded.collectionframework.provider.CharCounterProviderImpl;
import com.foxminded.collectionframework.validator.Validator;
import com.foxminded.collectionframework.validator.ValidatorImpl;

public class CharCounterFacade {

    public String distribute(String sentence, SentenceRepository sentenceRepository) {
        Validator validator = new ValidatorImpl();
        CharCounterProvider charCounterProvider = new CharCounterProviderImpl();
        Formatter formatter = new FormatterImpl();

        validator.validate(sentence);
        if (!this.checkInCache(sentence, sentenceRepository)) {
            sentenceRepository.put(sentence, charCounterProvider.charCalculator(sentence));
        }

        return formatter.toString(sentence, sentenceRepository);
    }

    private boolean checkInCache(String sentence, SentenceRepository sentenceRepository) {
        return sentenceRepository.isPresent(sentence);
    }
}
