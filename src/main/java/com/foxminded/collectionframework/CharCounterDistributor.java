package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.SentenceRepository;
import com.foxminded.collectionframework.input.Input;
import com.foxminded.collectionframework.provider.CharCounterProvider;
import com.foxminded.collectionframework.validator.Validator;

public class CharCounterDistributor {
    private static final String END_OF_THE_PROGRAM = "end";

    private final Validator validator;
    private final CharCounterProvider charCounterProvider;
    private final SentenceRepository sentenceRepository;

    public CharCounterDistributor(Validator validator, CharCounterProvider charCounterProvider, SentenceRepository sentenceRepository) {
        this.validator = validator;
        this.charCounterProvider = charCounterProvider;
        this.sentenceRepository = sentenceRepository;
    }

    public void toString(Input input) {

        while (true) {
            String sentence = input.inputSentence();
            if(sentence.equals(END_OF_THE_PROGRAM)) {
                break;
            } else {
                validator.validate(sentence);
                System.out.println(charCounterProvider.checkInCache(sentence, sentenceRepository));
            }
        }
    }
}
