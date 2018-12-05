package icu.cyclone.alex;

import java.util.ArrayList;
import java.util.List;

public interface Printer {

    public static void print(String str, AsciiArt asciiArt) {
        if (str == null) {
            return;
        }
        List<Letter> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(asciiArt.getLetter(c));
        }

        for (int i = 0; i < FontsLoader.LETTER_HIGHT; i++) {
            StringBuilder sb = new StringBuilder();

            for (Letter letter : list) {
                if (letter == null) {
                    sb.append("   ");
                } else {
                    sb.append(letter.getLine(i));
                }
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }

}
