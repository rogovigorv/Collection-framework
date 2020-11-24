package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.Repository;
import com.foxminded.collectionframework.domain.CharactersRepository;
import com.foxminded.collectionframework.formatter.Formatter;
import com.foxminded.collectionframework.formatter.CharactersFormatter;
import com.foxminded.collectionframework.input.Input;
import com.foxminded.collectionframework.input.CharactersInput;
import com.foxminded.collectionframework.validator.Validator;
import com.foxminded.collectionframework.validator.CharactersValidator;
import java.util.HashMap;

public class CharCounterDistributor {

    public void startCharCount() {
        Input input = new CharactersInput();
        Repository sentenceRepository = new CharactersRepository(new HashMap<>());

        while (true) {
            String sentence = input.inputSentence();

            Validator validator = new CharactersValidator();
            Formatter formatter = new CharactersFormatter();
            CharCounterFacade charCounterFacade = new CharCounterFacade(validator,
                    formatter, sentenceRepository);

            System.out.println(charCounterFacade.distribute(sentence));
        }
    }
}
