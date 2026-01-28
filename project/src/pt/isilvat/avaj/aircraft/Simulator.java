package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.factory.AircraftFactory;
import pt.isilvat.avaj.weather.WeatherTower;

import java.util.List;
import java.util.ArrayList;

public class Simulator {

    private static WeatherTower weatherTower = null;

    public static void main(String[] args) {

        weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();

        List<Flyable> flyables = new ArrayList<>();


        Coordinates coords = new Coordinates(10, 10, 10);
        Flyable balloon = aircraftFactory.newAircraft("Balloon","B1", coords);            
        Flyable helicopter = aircraftFactory.newAircraft("Helicopter","H1", coords);            
        Flyable jetplane = aircraftFactory.newAircraft("JetPlane","B1", coords);
        flyables.add(balloon);
        flyables.add(helicopter);
        flyables.add(jetplane);
        for(Flyable flyable: flyables) {
            flyable.registerTower(weatherTower);
        }


        int simulationRunningTimes = 3;
        for (; simulationRunningTimes > 0; simulationRunningTimes--) {
            weatherTower.changeWeather();
        }
    }
}