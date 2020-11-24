package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.Repository;
import com.foxminded.collectionframework.formatter.Formatter;
import com.foxminded.collectionframework.provider.CounterProvider;
import com.foxminded.collectionframework.provider.CharactersCounterProvider;
import com.foxminded.collectionframework.validator.Validator;
import java.util.Map;

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

        CounterProvider counterProvider = new CharactersCounterProvider();
        validator.validate(sentence);

        if (!repository.isPresent(sentence)) {
            repository.put(sentence, counterProvider.countCharacters(sentence));
        }

        Map<Character, Integer> innerMap = repository.get(sentence);

        return formatter.format(sentence, innerMap);
    }
}
