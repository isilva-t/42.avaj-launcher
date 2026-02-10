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

import pt.isilvat.avaj.exceptions.*;

public class Simulator {

    private static WeatherTower weatherTower = null;

    private static int simulationCycles;

    private static void validateFIleExtension (String fileName) {
        try {
            if (!fileName.endsWith(".txt")) {
                throw new InvalidFileExtension();
            }
            if (fileName.equals(".txt") || fileName.endsWith("/.txt")) {
                throw new InvalidFileExtension("Only a hidden \".txt\" file.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static int getGeoCoord(String s_value) {
        try {
            int value = Integer.parseInt(s_value);
            if (value < 1) {
                throw new InvalidCoordinates("longitude");
            }
            return value;
        } catch (InvalidCoordinates e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return -1;
    } 

    private static int getHeight(String s_height) {
        try {
            int height = Integer.parseInt(s_height);
            if (height > 100 || height < 0) {
                throw new InvalidCoordinates("height");
            }
            return height;
        } catch (InvalidCoordinates e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return -1;
    }

    private static List<Flyable> getFlyables(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists() || !file.isFile()) {
                throw new InvalidScenarioFile("File not found: " + fileName);
            }

            BufferedReader br = new BufferedReader(
                new FileReader(file));

            String line;
            simulationCycles = Integer.parseInt(br.readLine());
            if (simulationCycles < 0) {
                throw new InvalidSimulationCycles();
            }

            weatherTower = new WeatherTower();

            List<Flyable> flyables = new ArrayList<>();

            while((line = br.readLine()) != null) {
                String[] lineInfo = line.split("\\s+");
                String type = lineInfo[0];
                String name = lineInfo[1];
                int longitude = getGeoCoord(lineInfo[2]);
                int latitude = getGeoCoord(lineInfo[3]);
                int height = getHeight(lineInfo[4]);
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

    private static void runSimulation() {
        for (; simulationCycles > 0; simulationCycles--) {
            weatherTower.changeWeather();
        }
    }

    public static void main(String[] args) {

        try {
            if (args.length != 1) {
                throw new InvalidNumberOfArguments();
            }
            validateFIleExtension(args[0]);

            List<Flyable> flyables = getFlyables(args[0]);
            Printer.powerOn();
            for (Flyable flyable : flyables) {
                flyable.registerTower(weatherTower);
            }

            runSimulation();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}