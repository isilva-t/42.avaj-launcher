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
            System.out.println(this.getFullName() + " landing.");
            this.unregisterTower();
        }
    }

    public void updateConditions() {
        if (this.weatherTower == null) {
            return;
        }
        String weather = this.weatherTower.getWeather(this.coordinates);
    };

    public String getFullName() {
        String className = this.getClass().getSimpleName();
        String nameAndId = "#" + this.name + "(" + this.id + ")";
        String fullName = className + nameAndId;
        return fullName;
    }
}
