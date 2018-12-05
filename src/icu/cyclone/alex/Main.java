package icu.cyclone.alex;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AsciiArt letters = loadFont();
        Printer.print("Hello World!!! :)", letters);
    }
    
    public static AsciiArt loadFont() {
        File font = new File("font.txt");
        File chars = new File("char.txt");

        AsciiArt asciiArt = new AsciiArt();
        try {
            FontsLoader.readFonts(font, chars, asciiArt);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
        
        return asciiArt;
    }
}
