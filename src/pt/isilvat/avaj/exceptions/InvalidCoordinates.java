package pt.isilvat.avaj.exceptions;

public class InvalidCoordinates extends Exception {

    public InvalidCoordinates() {
        super("Invalid Coordinate! Please check it!");
    }

    public InvalidCoordinates(String message) {
        super("Invalid " + message + " Please check it!");
    }
}