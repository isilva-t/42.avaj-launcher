package pt.isilvat.avaj.weather;

import pt.isilvat.avaj.aircraft.Coordinates;

public class WeatherProvider {

    int cur = 0;
    private static WeatherProvider instance = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        if (this.cur > 3) {
            this.cur = 0;
        }
        return(weather[cur++]);
    }
}