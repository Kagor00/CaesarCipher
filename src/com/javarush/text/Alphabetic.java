package com.javarush.text;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Alphabetic {

    private final LinkedHashSet<Character> ENGLISH_ALPHABET = new LinkedHashSet<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
    ));

    private final LinkedHashSet<Character> UKRAINIAN_ALPHABET = new LinkedHashSet<>(Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й',
            'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч',
            'Ш', 'Щ', 'ь', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж',
            'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т',
            'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я', '.', ',', '«', '»',
            '"', '\'', ':', '!', '?', ' '
    ));

    public LinkedHashSet<Character> getENGLISH_ALPHABET() {
        return ENGLISH_ALPHABET;
    }

    public LinkedHashSet<Character> getUKRAINIAN_ALPHABET() {
        return UKRAINIAN_ALPHABET;
    }

    public LinkedHashSet<Character> detectAlphabet(String language) {
        if (language.equals("english")) {
            return getENGLISH_ALPHABET();
        } else {
            return getUKRAINIAN_ALPHABET();
        }
    }
}
