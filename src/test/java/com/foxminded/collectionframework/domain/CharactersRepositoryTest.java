package com.foxminded.collectionframework.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactersRepositoryTest {
    private static final String HELLO_WORLD_SENTENCE = "hello world!";
    private static final Map<Character, Integer> CHARACTERS = new LinkedHashMap<>();
    private static final Map<String, Map<Character, Integer>> REPO_MAP = new HashMap<>();

    private final Repository repository = new CharactersRepository(REPO_MAP);

    @BeforeAll
    static void setup() {
        REPO_MAP.put(HELLO_WORLD_SENTENCE, CHARACTERS);
    }

    @Test
    void checksForThePresenceInTheRepositoryShouldReturnTrue() {
        final boolean expected = true;
        final boolean actual = repository.isPresent(HELLO_WORLD_SENTENCE);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetFromTheRepository() {
        final Map<Character, Integer> actual = repository.get(HELLO_WORLD_SENTENCE);
        assertEquals(CHARACTERS, actual);
    }
}
