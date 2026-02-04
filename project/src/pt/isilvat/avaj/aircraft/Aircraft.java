package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.aircraft.Flyable;
import pt.isilvat.avaj.weather.WeatherTower;

public class Aircraft extends Flyable {

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected String rainMsg = "RAIN ☔  ";
    protected String fogMsg = "FOG 🌫️  ";
    protected String sunMsg = "SUN ☀️  ";
    protected String snowMsg = "SNOW ❄️  ";

    protected Aircraft(long p_id,
        String p_name, 
        Coordinates p_coordinates) {

        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    public void updateConditions() {
        if (this.weatherTower == null) {
            return;
        }
        String weather = this.weatherTower.getWeather(this.coordinates);
        try {
            switch(weather) {
                case "RAIN": 
                    this.weatherRain();
                    break;
                case "FOG":
                    this.weatherFog();
                    break;
                case "SUN":
                    this.weatherSun();
                    break;
                case "SNOW":
                    this.weatherSnow();
                    break;
                default:
                    throw new Exception("Invalid weather.");
            }
            this.checkHeight();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };

    public String getFullName() {
        String className = this.getClass().getSimpleName();
        String nameAndId = "#" + this.name + "(" + this.id + ") ";
        String fullName = className + nameAndId;
        return fullName;
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

    protected void changeCoordinates(
        int p_longitude,
        int p_latitude,
        int p_height
        ) {
            Coordinates newCoordinates = new Coordinates(
                coordinates.getLongitude() + p_longitude,
                coordinates.getLatitude() + p_latitude,
                coordinates.getHeight() + p_height);
        coordinates = newCoordinates;
    }

    protected String getStringCoordinates() {
        String textCoordinates = 
        " LON: " + coordinates.getLongitude() 
        + ", LAT: " + coordinates.getLatitude()
        + ", H: " + coordinates.getHeight();
        return textCoordinates;
    }

    protected void weatherRain() {
        System.out.print(
            this.getFullName()
            + this.rainMsg
        );
    }

    protected void weatherFog() {
        System.out.print(
            this.getFullName()
            + this.fogMsg
        );
    }

    protected void weatherSun() {
        System.out.print(
            this.getFullName()
            + this.sunMsg
        );
    }

    protected void weatherSnow() {
        System.out.print(
            this.getFullName()
            + this.snowMsg
        );
    }
}
