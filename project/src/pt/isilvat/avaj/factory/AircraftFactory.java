package pt.isilvat.avaj.factory;

import pt.isilvat.avaj.aircraft.*;
import pt.isilvat.avaj.coordinates.Coordinates;

public class AircraftFactory {

    private static AircraftFactory instance = new AircraftFactory();

    private long id = 0;
    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        return instance;
    }

    public Flyable newAircraft(
        String p_type,
        String p_name,
        Coordinates p_coordinates
        ) {
            try {
                if (this.id < 0) {
                    throw new Exception("Can't register more aircrafts!");
                } 
                switch(p_type) {
                    case "Balloon": 
                        return new Balloon(++this.id, p_name, p_coordinates);
                    case "Helicopter": 
                        return new Helicopter(++this.id, p_name, p_coordinates);
                    case "JetPlane": 
                        return new JetPlane(++this.id, p_name, p_coordinates);
                    default:
                        throw new Exception("wrong type of aircraft!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
}