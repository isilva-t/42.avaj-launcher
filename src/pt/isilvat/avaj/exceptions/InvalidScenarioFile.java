package pt.isilvat.avaj.exceptions;

public class InvalidScenarioFile extends Exception {

    public InvalidScenarioFile() {
        super("Invalid Scenario file.");
    }

    public InvalidScenarioFile(String message) {
        super(message);
    }
}