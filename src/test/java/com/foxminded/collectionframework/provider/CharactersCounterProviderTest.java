package com.foxminded.collectionframework.provider;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactersCounterProviderTest {
    private static final String HELLO_WORLD_SENTENCE = "hello world!";
    private static final String ONLY_SYMBOLS_SENTENCE = "!@#$%^&*()";
    private static final String ONLY_DIGITS_SENTENCE = "1234567890";
    private static final String REPEATING_LETTERS = "www";

    private final CounterProvider counterProvider = new CharactersCounterProvider();

    final Map<Character, Integer> expected = new LinkedHashMap<>();

    @Test
    void makeCountCharactersWhenSentenceIsHelloWorld() {

        expected.put("h".charAt(0), 1);
        expected.put("e".charAt(0), 1);
        expected.put("l".charAt(0), 3);
        expected.put("o".charAt(0), 2);
        expected.put(" ".charAt(0), 1);
        expected.put("w".charAt(0), 1);
        expected.put("r".charAt(0), 1);
        expected.put("d".charAt(0), 1);
        expected.put("!".charAt(0), 1);

        final Map<Character, Integer> actual = counterProvider.countCharacters(HELLO_WORLD_SENTENCE);

        assertEquals(expected, actual);
    }

    @Test
    void makeCountCharactersWhenSentenceContainsOnlySymbols() {

        expected.put("!".charAt(0), 1);
        expected.put("@".charAt(0), 1);
        expected.put("#".charAt(0), 1);
        expected.put("$".charAt(0), 1);
        expected.put("%".charAt(0), 1);
        expected.put("^".charAt(0), 1);
        expected.put("&".charAt(0), 1);
        expected.put("*".charAt(0), 1);
        expected.put("(".charAt(0), 1);
        expected.put(")".charAt(0), 1);

        final Map<Character, Integer> actual = counterProvider.countCharacters(ONLY_SYMBOLS_SENTENCE);

        assertEquals(expected, actual);
    }

    @Test
    void makeCountCharactersWhenSentenceContainsOnlyDigits() {

        expected.put("1".charAt(0), 1);
        expected.put("2".charAt(0), 1);
        expected.put("3".charAt(0), 1);
        expected.put("4".charAt(0), 1);
        expected.put("5".charAt(0), 1);
        expected.put("6".charAt(0), 1);
        expected.put("7".charAt(0), 1);
        expected.put("8".charAt(0), 1);
        expected.put("9".charAt(0), 1);
        expected.put("0".charAt(0), 1);

        final Map<Character, Integer> actual = counterProvider.countCharacters(ONLY_DIGITS_SENTENCE);

        assertEquals(expected, actual);
    }

    @Test
    void makeCountCharactersWhenSentenceContainsOnlyRepeatingLetters() {

        expected.put("w".charAt(0), 3);

        final Map<Character, Integer> actual = counterProvider.countCharacters(REPEATING_LETTERS);

        assertEquals(expected, actual);
    }
}
