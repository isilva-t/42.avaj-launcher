package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.factory.AircraftFactory;
import pt.isilvat.avaj.weather.WeatherTower;
import pt.isilvat.avaj.printer.Printer;

import java.util.List;
import java.util.ArrayList;

public class Simulator {

    private static WeatherTower weatherTower = null;

    public static void main(String[] args) {

        weatherTower = new WeatherTower();

        List<Flyable> flyables = new ArrayList<>();

        Printer.print("", "");

        Coordinates coords = new Coordinates(10, 10, 10);
        Flyable balloon = AircraftFactory.newAircraft("Balloon","B1", coords);            
        Flyable helicopter = AircraftFactory.newAircraft("Helicopter","H1", coords);            
        Flyable jetplane = AircraftFactory.newAircraft("JetPlane","B1", coords);
        flyables.add(balloon);
        flyables.add(helicopter);
        flyables.add(jetplane);
        for(Flyable flyable: flyables) {
            flyable.registerTower(weatherTower);
        }


        int simulationRunningTimes = 15;
        for (; simulationRunningTimes > 0; simulationRunningTimes--) {
            weatherTower.changeWeather();
            Printer.print("", "");
        }
    }
}