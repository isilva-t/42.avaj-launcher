package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.aircraft.Flyable;
import pt.isilvat.avaj.weather.WeatherTower;

public class Aircraft extends Flyable {

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id,
        String p_name, 
        Coordinates p_coordinates) {

        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    protected void checkHeight() {
        int height = this.coordinates.getHeight();
        if (height > 100) {
            this.coordinates = new Coordinates(
                this.coordinates.getLongitude(),
                this.coordinates.getLatitude(),
                100
                );
        }
        else if (height <= 0) {
            String className = this.getClass().getSimpleName();
            System.out.println(
                className 
                + "#" 
                + this.name 
                + "(" 
                + this.id 
                + ") landing.");
            this.weatherTower.unregister(this);
        }
    }

    public void updateConditions() {};




}
