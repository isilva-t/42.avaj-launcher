package pt.isilvat.avaj.weather;

import pt.isilvat.avaj.aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider instance = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        // needs logic here to generate correct weather
        return weather[0];
    }
}