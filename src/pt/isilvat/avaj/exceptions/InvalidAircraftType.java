package pt.isilvat.avaj.exceptions;

public class InvalidAircraftType extends Exception {

    public InvalidAircraftType() {
        super("Invalid Aircraft Type!");
    }

    public InvalidAircraftType(String invalidAircraft) {
        super("Invalid Aircraft Type: " + invalidAircraft);
    }
}