package com.foxminded.collectionframework.formatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactersFormatterTest {
    private static final String HELLO_WORLD_SENTENCE = "hello world!";
    private static final Map<Character, Integer> CHARACTERS = new LinkedHashMap<>();

    private final Formatter formatter = new CharactersFormatter();

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
    void makeFormatOfSentence() {

        final String expected =
                "\"h\" - 1\n" +
                        "\"e\" - 1\n" +
                        "\"l\" - 3\n" +
                        "\"o\" - 2\n" +
                        "\" \" - 1\n" +
                        "\"w\" - 1\n" +
                        "\"r\" - 1\n" +
                        "\"d\" - 1\n" +
                        "\"!\" - 1\n";
        final String actual = formatter.format(HELLO_WORLD_SENTENCE, CHARACTERS);

        assertEquals(expected, actual);
    }
}
