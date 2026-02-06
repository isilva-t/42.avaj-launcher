package pt.isilvat.avaj.printer;

import java.io.FileOutputStream;
import java.io.IOException;

public class Printer {

    public static void powerOn() {
        
    }

    public static void powerOff() {
        
    }

    public static void print(String message, String coordinates) {

        toConsole(message, coordinates);
        toFile(message);
    }

    private static void toConsole(String message, String coordinates) {
        System.out.println(message + " " + coordinates);
    }

    private static void toFile(String message) {
        try {

        } catch (Exception e) {

        }
        
    }
}
