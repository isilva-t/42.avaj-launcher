package pt.isilvat.avaj.printer;

import java.io.FileOutputStream;
import java.io.IOException;

public class Printer {

    public static final String fileName = "simulation.txt";

    public static void powerOn() {
        try {

            FileOutputStream outputFile= new FileOutputStream(fileName);
        } catch (Exception e) {

        }
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
            FileOutputStream outputFile = new FileOutputStream(fileName, true);
            outputFile.write((message + "\n").getBytes());
        } catch (Exception e) {

        }
        
    }
}
