package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.coordinates.Coordinates;

public class Baloon extends Aircraft {

    public Baloon (
        long p_id,
        String p_name,
        Coordinates p_coordinates
    ) {
        super(
            p_id, 
            p_name, 
            p_coordinates);
    }

    public void updateConditions() {
    }

}