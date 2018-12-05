package icu.cyclone.alex;

import java.util.HashMap;
import java.util.Map;

public class AsciiArt {
    private Map<Character, Letter> letters = new HashMap<>();

    public AsciiArt() {
        super();
    }

    public void addLetter(Character c, Letter letter) {
        letters.put(c, letter);
    }

    public Letter getLetter(Character c) {
        return letters.get(c);
    }

    @Override
    public String toString() {
        return "AsciiArt" + System.lineSeparator() + letters;
    }

}
