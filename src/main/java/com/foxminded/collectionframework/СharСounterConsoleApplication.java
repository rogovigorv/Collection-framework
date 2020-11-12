package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.SentenceRepository;
import com.foxminded.collectionframework.domain.SentenceRepositoryImpl;
import com.foxminded.collectionframework.input.Input;
import com.foxminded.collectionframework.input.InputImpl;
import com.foxminded.collectionframework.provider.CharCounterProvider;
import com.foxminded.collectionframework.provider.CharCounterProviderImpl;
import com.foxminded.collectionframework.validator.Validator;
import com.foxminded.collectionframework.validator.ValidatorImpl;
import java.util.HashMap;

public class СharСounterConsoleApplication {
    public static void main(String[] args) {
        Input input = new InputImpl();
        Validator validator = new ValidatorImpl();
        CharCounterProvider charCounterProvider = new CharCounterProviderImpl();
        SentenceRepository sentenceRepository = new SentenceRepositoryImpl(new HashMap<>());

        CharCounterDistributor charCounterDistributor = new CharCounterDistributor(validator,
                charCounterProvider, sentenceRepository);

            charCounterDistributor.toString(input);
    }
}
