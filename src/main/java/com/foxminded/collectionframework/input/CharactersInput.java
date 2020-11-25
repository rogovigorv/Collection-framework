package com.foxminded.collectionframework.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharactersInput implements Input {

    @Override
    public String inputSentence() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sentence = null;

        try {
            sentence = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sentence;
    }
}
