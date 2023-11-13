package com.javarush.cryptography;

import com.javarush.text.Alphabetic;
import com.javarush.text.Language;

import java.util.LinkedHashSet;

public class CaesarCipher {
    private final Alphabetic alphabetic = new Alphabetic();
    private final Language language = new Language();


    public String encode(String text, int key) {
        LinkedHashSet<Character> alphabet = alphabetic.detectAlphabet(language.detectLanguage(text));
        return transformText(text, key, alphabet);
    }

    public String decode(String text, int key) {
        LinkedHashSet<Character> alphabet = alphabetic.detectAlphabet(language.detectLanguage(text));
        return transformText(text, -key, alphabet);
    }

    private char getResultChar(char currentChar, LinkedHashSet<Character> alphabet, int key) {
        if (alphabet.contains(currentChar)) {
            int alphabetSize = alphabet.size();
            int currentIndex = 0;

            for (Character character : alphabet) {
                if (character == currentChar) {
                    int resultIndex = (currentIndex + key) % alphabetSize;
                    if (resultIndex < 0) {
                        resultIndex += alphabetSize;
                    }
                    return (Character) alphabet.toArray()[resultIndex];
                }
                currentIndex++;
            }
        }
        return currentChar;
    }

    private String transformText(String text, int key, LinkedHashSet<Character> alphabet) {
        StringBuilder builder = new StringBuilder(text);

        for (int i = 0; i < text.length(); i++) {
            char currentChar = builder.charAt(i);
            char resultChar = getResultChar(currentChar, alphabet, key);
            builder.setCharAt(i, resultChar);
        }

        return builder.toString();
    }
}