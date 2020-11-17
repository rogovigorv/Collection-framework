package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.Repository;
import com.foxminded.collectionframework.formatter.Formatter;
import com.foxminded.collectionframework.provider.CharCounterProvider;
import com.foxminded.collectionframework.provider.StringCharCounterProvider;
import com.foxminded.collectionframework.validator.Validator;

public class CharCounterFacade {
    private final Validator validator;
    private final Formatter formatter;
    private final Repository repository;

    public CharCounterFacade(Validator validator, Formatter formatter, Repository repository) {
        this.validator = validator;
        this.formatter = formatter;
        this.repository = repository;
    }

    public String distribute(String sentence) {

        CharCounterProvider charCounterProvider = new StringCharCounterProvider();
        validator.validate(sentence);

        if (!repository.isPresent(sentence)) {
            repository.put(sentence, charCounterProvider.countCharacters(sentence));
        }

        return formatter.format(sentence, repository);
    }
}
