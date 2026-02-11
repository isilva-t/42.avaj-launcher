package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.factory.AircraftFactory;
import pt.isilvat.avaj.weather.WeatherTower;
import pt.isilvat.avaj.tools.*;
import pt.isilvat.avaj.exceptions.*;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Simulator {

    private static WeatherTower weatherTower = null;

    private static int simulationCycles;

    private static List<Flyable> getFlyables(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists() || !file.isFile()) {
                throw new InvalidScenarioFile("File not found: " + fileName);
            }

            BufferedReader br = new BufferedReader(
                new FileReader(file));

            String line = br.readLine();
            if (line == null) {
                throw new InvalidScenarioFile();
            }
            simulationCycles = Integer.parseInt(line.trim());
            if (simulationCycles < 0) {
                throw new InvalidSimulationCycles();
            }

            List<Flyable> flyables = new ArrayList<>();
            while((line = br.readLine()) != null) {
                String[] lineInfo = line.trim().split("\\s+");
                String type = lineInfo[0];
                String name = lineInfo[1];
                int longitude = Validator.getGeoCoord(lineInfo[2]);
                int latitude = Validator.getGeoCoord(lineInfo[3]);
                int height = Validator.getHeight(lineInfo[4]);
                Coordinates coordinates = new Coordinates(
                    longitude,
                    latitude,
                    height
                );
                Flyable flyable = AircraftFactory.newAircraft(type, name, coordinates);
                flyables.add(flyable);
            }
            br.close();
            return flyables;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return new ArrayList<>();
    }

    private static void runSimulation(List<Flyable> flyables) {
        weatherTower = new WeatherTower();
        Printer.powerOn();
        for (Flyable flyable : flyables) {
                flyable.registerTower(weatherTower);
        }
        for (; simulationCycles > 0; simulationCycles--) {
            weatherTower.changeWeather();
        }
    }

    public static void main(String[] args) {

        try {
            if (args.length != 1) {
                throw new InvalidNumberOfArguments();
            }

            Validator.validateFIleExtension(args[0]);
            List<Flyable> flyables = getFlyables(args[0]);
            runSimulation(flyables);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}