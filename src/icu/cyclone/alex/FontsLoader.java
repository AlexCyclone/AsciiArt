package icu.cyclone.alex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface FontsLoader {

    public int LETTER_HIGHT = 8;
    public int IGNORED_CHARS = 2;

    public static void readFonts(File font, File chars, AsciiArt letters) throws IOException, IllegalArgumentException {
        if (font == null || chars == null || letters == null) {
            throw new IllegalArgumentException("Null file pointer or dictionary");
        }
        try (BufferedReader fr = new BufferedReader(new FileReader(font));
                BufferedReader cr = new BufferedReader(new FileReader(chars))) {
            while (true) {
                List<String> letter = new ArrayList<>();
                for (int i = 0; i < LETTER_HIGHT; i++) {
                    letter.add(fr.readLine());
                }
                if (letter.get(letter.size() - 1) == null) {
                    break;
                }
                letters.addLetter((Character) (cr.readLine().charAt(0)), new Letter(letter));
            }
        } catch (IOException e) {
            throw e;
        }
    }

}
