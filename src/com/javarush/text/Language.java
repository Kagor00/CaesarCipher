package com.javarush.text;

public class Language {
    private final Alphabetic alphabetic = new Alphabetic();

    public String detectLanguage(String text) {
        text = text.replaceAll("[^A-Za-zА-Яа-яЁёІіЇїЄєҐґ]", "");
        int englishCount = 0;
        int ukrainianCount = 0;

        for (char character: text.toCharArray()) {
            if (alphabetic.getENGLISH_ALPHABET().contains(character)) {
                englishCount++;
            } else if (alphabetic.getUKRAINIAN_ALPHABET().contains(character)) {
                ukrainianCount++;
            }
        }

        if (englishCount > ukrainianCount) {
            return "english";
        } else {
            return "ukrainian";
        }
    }
}
