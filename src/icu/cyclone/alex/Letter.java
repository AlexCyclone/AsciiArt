package icu.cyclone.alex;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    private List<String> letter = new ArrayList<>();

    public Letter() {
        super();
    }

    public Letter(List<String> letter) {
        super();
        this.letter = letter;
        normaliseLetter();
    }

    private void normaliseLetter() {
        int begin = findBegin();
        int end = findEnd();

        for (int i = 0; i < letter.size(); i++) {
            letter.set(i, letter.get(i).substring(begin, end + 1));
        }
    }

    private int findBegin() {
        int begin = FontsLoader.IGNORED_CHARS;
        boolean found = false;
        for (int i = begin; i < letter.get(0).length(); i++) {
            if (found) {
                break;
            }
            for (String string : letter) {
                if (string.charAt(i) != ' ') {
                    begin = i;
                    found = true;
                    break;
                }
            }
        }
        return begin;
    }

    private int findEnd() {
        int end = 2;
        boolean found = false;
        for (int i = letter.get(0).length() - 1; i > FontsLoader.IGNORED_CHARS - 1; i--) {
            if (found) {
                break;
            }
            for (String string : letter) {
                if (string.charAt(i) != ' ') {
                    end = i;
                    found = true;
                    break;
                }
            }
        }
        return end;
    }

    public String getLine(int line) {
        if (line < 0 || line >= letter.size()) {
            throw new IllegalArgumentException("Out of letter size");
        }
        return letter.get(line);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        for (String str : letter) {
            sb.append(str);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
