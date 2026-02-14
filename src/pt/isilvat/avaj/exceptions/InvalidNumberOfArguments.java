package pt.isilvat.avaj.exceptions;

public class InvalidNumberOfArguments extends Exception {

    public InvalidNumberOfArguments() {
        super("Invalid number of arguments. Must be \"<filename>.txt\"");
    }
}