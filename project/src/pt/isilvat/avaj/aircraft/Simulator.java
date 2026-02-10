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

    private static int getLongitude(int longitude) {
        try {
            if (longitude < 1) {
                throw new InvalidCoordinates("longitude");
            }
            return longitude;
        } catch (InvalidCoordinates e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return -1;
    } 

    private static int getLatitude(int latitude) {
        try {
            if (latitude < 1) {
                throw new InvalidCoordinates("latitude");
            }
            return latitude;
        } catch (InvalidCoordinates e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return -1;
    }

    private static int getHeight(int height) {
        try {
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

    private static void loadData(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists() || !file.isFile()) {
                throw new InvalidScenarioFile("File not found: " + fileName);
            }

            BufferedReader br = new BufferedReader(
                new FileReader(file));

            String line;
            simulationCycles = Integer.parseInt(br.readLine());

            weatherTower = new WeatherTower();
            while((line = br.readLine()) != null) {
                String[] lineInfo = line.split("\\s+");
                String type = lineInfo[0];
                String name = lineInfo[1];
                int longitude = getLongitude(Integer.parseInt(lineInfo[2]));
                int latitude = getLatitude(Integer.parseInt(lineInfo[3]));
                int height = getHeight(Integer.parseInt(lineInfo[4]));
                Coordinates coordinates = new Coordinates(
                    longitude,
                    latitude,
                    height
                );
                Flyable flyable = AircraftFactory.newAircraft(type, name, coordinates);
                flyable.registerTower(weatherTower);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
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
            Printer.powerOn();
            validateFIleExtension(args[0]);
            loadData(args[0]);
            runSimulation();
            Printer.powerOff();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}