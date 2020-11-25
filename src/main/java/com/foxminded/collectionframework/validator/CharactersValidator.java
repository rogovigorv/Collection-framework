package com.foxminded.collectionframework.validator;

public class CharactersValidator implements Validator {

    @Override
    public void validate(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Sentence is null");
        }
        if (sentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence is empty");
        }
    }
}
