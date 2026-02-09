package pt.isilvat.avaj.weather;

import pt.isilvat.avaj.aircraft.Coordinates;

public class WeatherProvider {

    int cur = 0;
    private static final WeatherProvider instance = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}


    public static String getCurrentWeather(Coordinates p_coordinates) {

        return instance.getWeather(p_coordinates);
    }

    private String getWeather(Coordinates p_coordinates) {
        
        int current = 
            (p_coordinates.getLongitude() * 4
            + p_coordinates.getLatitude() * 3
            + p_coordinates.getHeight() * 9) % 4;
        return(weather[current]);
    }
}