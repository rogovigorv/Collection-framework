package com.foxminded.collectionframework.validator;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    private static final String SENTENCE_IS_NULL = null;
    private static final String SENTENCE_IS_EMPTY = "";

    private final Validator validator = new CharactersValidator();

    @Test
    void validatorShouldThrowIllegalArgumentExceptionWhenNullPassed() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validate(SENTENCE_IS_NULL));
        assertThat("Sentence is null", equalTo(exception.getMessage()));
    }

    @Test
    void validatorShouldThrowIllegalArgumentExceptionWhenEmptySentencePassed() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validate(SENTENCE_IS_EMPTY));
        assertThat("Sentence is empty", equalTo(exception.getMessage()));
    }
}
