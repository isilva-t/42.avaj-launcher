package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.factory.AircraftFactory;
import pt.isilvat.avaj.weather.WeatherTower;
import pt.isilvat.avaj.printer.Printer;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Simulator {

    private static WeatherTower weatherTower = null;

    private static int simulationCycles;

    private static void loadData(String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(
                new FileReader(file));

            String line;

            while((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {

        }
    }

    private static void runSimulation() {
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

    public static void main(String[] args) {
        if (args.length < 1) {
            return;
        }
        try {

            loadData(args[0]);
            runSimulation();
            
        } catch (Exception e) {
            System.out.println("oops");
        }
    }
}