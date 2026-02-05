package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.aircraft.Flyable;
import pt.isilvat.avaj.weather.WeatherTower;
import pt.isilvat.avaj.printer.Printer;

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
            checkHeight();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };

    public String getFullName() {
        String className = this.getClass().getSimpleName();
        String nameAndId = "#" + this.name + "(" + this.id + ")";
        String fullName = className + nameAndId;
        return fullName;
    }

    private int getNormalizedHeight(int height) {
        if (height > 100) {
            return 100;
        }
        else if (height <= 0) {
            return 0;
        }
        return height;
    }

    private void checkHeight() {
        if (coordinates.getHeight() <= 0) {
            String className = this.getClass().getSimpleName();
            Printer.print(
                this.getFullName()
                + " landing.",
                coordinates.getStringCoord()
                );
            this.unregisterTower();
        }
    }

    protected void changeCoordinates(
        int p_longitude,
        int p_latitude,
        int p_height
        ) {
        int newHeight = getNormalizedHeight(
            coordinates.getHeight() + p_height);

        Coordinates newCoordinates = new Coordinates(
            coordinates.getLongitude() + p_longitude,
            coordinates.getLatitude() + p_latitude,
            newHeight);

        coordinates = newCoordinates;
    }

    protected void printChildMessage(String message) {
        Printer.print(
            this.getFullName()
            + " "
            + message,
            coordinates.getStringCoord());
    }

    protected void weatherRain() {}
    protected void weatherFog() {}
    protected void weatherSun() {}
    protected void weatherSnow() {}
}
