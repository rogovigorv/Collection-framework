package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.Repository;
import com.foxminded.collectionframework.domain.StringRepository;
import com.foxminded.collectionframework.formatter.Formatter;
import com.foxminded.collectionframework.formatter.StringFormatter;
import com.foxminded.collectionframework.input.Input;
import com.foxminded.collectionframework.input.StringInput;
import com.foxminded.collectionframework.validator.Validator;
import com.foxminded.collectionframework.validator.StringValidator;
import java.util.HashMap;

public class CharCounterDistributor {

    public void startCharCount() {
        Input input = new StringInput();
        Repository sentenceRepository = new StringRepository(new HashMap<>());

        while (true) {
            String sentence = input.inputSentence();

            Validator validator = new StringValidator();
            Formatter formatter = new StringFormatter();
            CharCounterFacade charCounterFacade = new CharCounterFacade(validator,
                    formatter, sentenceRepository);

            System.out.println(charCounterFacade.distribute(sentence));
        }
    }
}
