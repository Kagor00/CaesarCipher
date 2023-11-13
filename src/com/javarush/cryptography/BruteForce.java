package com.javarush.cryptography;

import com.javarush.text.Alphabetic;
import com.javarush.text.Language;

import java.util.LinkedHashSet;

public class BruteForce {
    private final Alphabetic alphabetic = new Alphabetic();
    private final Language language = new Language();
    private final CaesarCipher caesarCipher = new CaesarCipher();

    public int findKey(String text) {
        LinkedHashSet<Character> alphabet = alphabetic.detectAlphabet(language.detectLanguage(text));
        int alphabetSize = alphabet.size();
        int key = 0;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < alphabetSize; i++) {
            String findText = caesarCipher.decode(text, i);
            int count = countFirstLetterIsUpperCase(findText);
            count += countStartsWithSpaceOrNewLine(findText);
            count += countEndsWithDot(findText);
            count += countLetterCommaSpaceLetter(findText);
            count += countLetterDotSpaceLetter(findText);
            count += countLetterSpaceLetter(findText);


            if (count > maxCount) {
                maxCount = count;
                key = i;
            }
        }
        return key;
    }

    private int countFirstLetterIsUpperCase(String text) {
        return Character.isUpperCase(text.charAt(0)) ? 1 : 0;
    }

    private int countStartsWithSpaceOrNewLine(String text) {
        int count = 0;
        if (text.startsWith(" ") || text.startsWith("\n") || text.startsWith("\n\n")) {
            count = 1;
        }
        return count;
    }

    private int countEndsWithDot(String text) {
        return text.endsWith(".") ? 1 : 0;
    }

    private int countLetterSpaceLetter(String text) {
        int count = 0;
        for (int i = 1; i < text.length() - 1; i++) {
            if (text.charAt(i) == ' ' && Character.isLowerCase(text.charAt(i - 1)) && Character.isLowerCase(text.charAt(i + 1))) {
                count++;
            }
        }
        return count;
    }

    private int countLetterCommaSpaceLetter(String text) {
        int count = 0;
        for (int i = 2; i < text.length() - 2; i++) {
            if (text.charAt(i) == ',' && text.charAt(i + 1) == ' ' && Character.isLowerCase(text.charAt(i - 1)) && Character.isLowerCase(text.charAt(i + 2))) {
                count++;
            }
        }
        return count;
    }

    private int countLetterDotSpaceLetter(String text) {
        int count = 0;
        for (int i = 2; i < text.length() - 2; i++) {
            if (text.charAt(i) == '.' && text.charAt(i + 1) == ' ' && Character.isLowerCase(text.charAt(i - 1)) && Character.isUpperCase(text.charAt(i + 2))) {
                count++;
            }
        }
        return count;
    }
}
