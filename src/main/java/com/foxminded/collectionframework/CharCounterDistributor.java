package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.SentenceRepository;
import com.foxminded.collectionframework.domain.SentenceRepositoryImpl;
import com.foxminded.collectionframework.input.Input;
import com.foxminded.collectionframework.input.InputImpl;
import java.util.HashMap;

public class CharCounterDistributor {
    private static final String END_OF_THE_PROGRAM = "end";

    public void startCharCount() {
        Input input = new InputImpl();
        SentenceRepository sentenceRepository = new SentenceRepositoryImpl(new HashMap<>());

        while (true) {
            String sentence = input.inputSentence();

            if(sentence.equals(END_OF_THE_PROGRAM)) {
                break;
            } else {
                System.out.println(new CharCounterFacade().distribute(sentence, sentenceRepository));
            }
        }
    }
}
