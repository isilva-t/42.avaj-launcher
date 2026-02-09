package pt.isilvat.avaj.exceptions;

public class InvalidFileExtension extends Exception {

    private static final String defaultString = "File must be \"<filename>.txt\".";

    public InvalidFileExtension() {
        super(defaultString);
    }

    public InvalidFileExtension(String message) {
        super(defaultString + " " + message);
    }
}