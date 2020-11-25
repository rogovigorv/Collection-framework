package com.foxminded.collectionframework;

import com.foxminded.collectionframework.domain.Repository;
import com.foxminded.collectionframework.formatter.Formatter;
import com.foxminded.collectionframework.validator.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharCounterFacadeTest {
    private static final String HELLO_WORLD_SENTENCE_ACTUAL = "hello world!";
    private static final String HELLO_WORLD_SENTENCE_EXPECTED = "\"h\" - 1\n" +
                                                                "\"e\" - 1\n" +
                                                                "\"l\" - 3\n" +
                                                                "\"o\" - 2\n" +
                                                                "\" \" - 1\n" +
                                                                "\"w\" - 1\n" +
                                                                "\"r\" - 1\n" +
                                                                "\"d\" - 1\n" +
                                                                "\"!\" - 1\n";
    private static final Map<Character, Integer> CHARACTERS = new LinkedHashMap<>();

    @Mock
    private Validator validator;

    @Mock
    private Formatter formatter;

    @Mock
    private Repository repository;

    @InjectMocks
    private CharCounterFacade charCounterFacade;

    @BeforeAll
    static void setup() {
        CHARACTERS.put("h".charAt(0), 1);
        CHARACTERS.put("h".charAt(0), 1);
        CHARACTERS.put("e".charAt(0), 1);
        CHARACTERS.put("l".charAt(0), 3);
        CHARACTERS.put("o".charAt(0), 2);
        CHARACTERS.put(" ".charAt(0), 1);
        CHARACTERS.put("w".charAt(0), 1);
        CHARACTERS.put("r".charAt(0), 1);
        CHARACTERS.put("d".charAt(0), 1);
        CHARACTERS.put("!".charAt(0), 1);
    }

    @Test
    void charCounterFacadeWhenNotAccessingTheRepository() {

        doNothing().when(validator).validate(HELLO_WORLD_SENTENCE_ACTUAL);
        when(repository.isPresent(HELLO_WORLD_SENTENCE_ACTUAL)).thenReturn(false);
        when(repository.get(HELLO_WORLD_SENTENCE_ACTUAL)).thenReturn(CHARACTERS);
        when(formatter.format(HELLO_WORLD_SENTENCE_ACTUAL, CHARACTERS)).thenReturn(HELLO_WORLD_SENTENCE_EXPECTED);

        final String actual = charCounterFacade.distribute(HELLO_WORLD_SENTENCE_ACTUAL);

        assertEquals(HELLO_WORLD_SENTENCE_EXPECTED, actual);
    }

    @Test
    void charCounterFacadeWhenAccessingTheRepository() {

        doNothing().when(validator).validate(HELLO_WORLD_SENTENCE_ACTUAL);
        when(repository.isPresent(HELLO_WORLD_SENTENCE_ACTUAL)).thenReturn(true);
        when(repository.get(HELLO_WORLD_SENTENCE_ACTUAL)).thenReturn(CHARACTERS);
        when(formatter.format(HELLO_WORLD_SENTENCE_ACTUAL, CHARACTERS)).thenReturn(HELLO_WORLD_SENTENCE_EXPECTED);

        final String actual = charCounterFacade.distribute(HELLO_WORLD_SENTENCE_ACTUAL);

        assertEquals(HELLO_WORLD_SENTENCE_EXPECTED, actual);
    }
}
