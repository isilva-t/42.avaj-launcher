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
        if (this.cur > 3) {
            this.cur = 0;
        }
        return(weather[cur++]);
    }
}