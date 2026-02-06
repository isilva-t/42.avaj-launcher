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
            simulationCycles = Integer.parseInt(br.readLine());

            weatherTower = new WeatherTower();
            while((line = br.readLine()) != null) {
                String[] lineInfo = line.split("\\s+");
                String type = lineInfo[0];
                String name = lineInfo[1];
                Coordinates coordinates = new Coordinates(
                    Integer.parseInt(lineInfo[2]),
                    Integer.parseInt(lineInfo[3]),
                    Integer.parseInt(lineInfo[4])
                );
                Flyable flyable = AircraftFactory.newAircraft(type, name, coordinates);
                flyable.registerTower(weatherTower);
            }
        } catch (Exception e) {

        }
    }

    private static void runSimulation() {

        Printer.print("", "");
        for (; simulationCycles > 0; simulationCycles--) {
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