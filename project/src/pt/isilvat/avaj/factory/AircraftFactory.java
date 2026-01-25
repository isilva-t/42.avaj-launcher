package pt.isilvat.avaj.factory;

import pt.isilvat.avaj.aircraft.*;
import pt.isilvat.avaj.coordinates.Coordinates;

public class AircraftFactory {

    private AircraftFactory() {
    }

    Flyable newAircraft(
        String p_type,
        String p_name,
        Coordinates p_coordinates
        ) {
            try {
                int id = 0; // must be requested by other class! we need to find who

                switch(p_type) {
                    case "Balloon": 
                        return new Balloon(id, p_name, p_coordinates);
                    case "Helicopter": 
                        return new Helicopter(id, p_name, p_coordinates);
                    case "JetPlane": 
                        return new JetPlane(id, p_name, p_coordinates);
                    default:
                        throw new Exception("wrong type of aircraft!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

}