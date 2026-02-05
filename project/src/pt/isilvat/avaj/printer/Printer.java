package pt.isilvat.avaj.printer;

public class Printer {

    public static void print(String message, String coordinates) {

        toConsole(message, coordinates);
        toFile(message);
    }

    private static void toConsole(String message, String coordinates) {
        System.out.println(message + " " + coordinates);
    }

    private static void toFile(String message) {
        
    }
}
