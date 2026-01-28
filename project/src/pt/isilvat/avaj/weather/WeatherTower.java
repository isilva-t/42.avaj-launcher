package pt.isilvat.avaj.weather;

import pt.isilvat.avaj.aircraft.Coordinates;

public class WeatherTower extends Tower {

    public WeatherTower() {
        
    }   

    public String getWeather(Coordinates p_coordinates) {
      
      WeatherProvider provider = WeatherProvider.getInstance();
      String weather = provider.getCurrentWeather(p_coordinates);
      
      return weather; 
    } 

    public void changeWeather() {
      System.out.println("Weather will changed from here.");
    }
}