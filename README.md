# 42 Avaj Launcher

**Status:** 🚧 In Development

A Java aircraft weather simulation program implementing core OOP design patterns (Observer, Singleton, Factory).

![airport](project/doc/avaj.jpg)

## About

This project simulates aircraft behavior under changing weather conditions. Aircraft register with a weather tower and respond differently to weather changes based on their type (Helicopter, JetPlane, Balloon).

## What It Does

- Reads aircraft specifications from a scenario file
- Simulates weather changes based on 3D coordinates
- Each aircraft type reacts differently to weather (SUN, RAIN, FOG, SNOW)
- Aircraft land when reaching height 0
- Outputs simulation log to `simulation.txt`

## UML Class diagram

```mermaid

classDiagram

    class Tower {    
        - List<'Flyable'> observers
        + void register(Flyable* p_flyable)
        + void unregister(Flyable p_flyable)
        # void conditionChanged()
    }

    class Flyable {
        <<abstract>>
        # WeatherTower weatherTower
        + abstract void updateConditions()
        + void registerTower(WeatherTower p_tower)

        # void unregisterTower()
    }

    
    class Aircraft {
        # long id
        # String name
        # Coordinates coordinates
        # Aircraft(long p_id, String p_name, Coordinates p_coordinates)
        + String getFullName()

        - void checkHeight(String whatIsDoing)
        - int getNormalizedHeight(int height)

        # void changeCoordinates(int p_longitude, int p_latitude, int p_height)
        # void printChildMessage(String message)

        # void weatherRain()
        # void weatherFog()
        # void weatherSun()
        # void weatherSnow()
    }

    class Coordinates {
        - int longitude
        - int latitude
        - int height
        ~ Coordinates(int p_longitude, int p_latitude, int p_height)
        + int getLongitude()
        + int getLatitude()
        + int getHeight()

        + String getStringCoord()
    }

    class WeatherProvider {
        <<singleton>>
        - String[] weather
        + String getCurrentWeather(Coordinates p_coordinates)
    }

    class WeatherTower {
        + String getWeather(Coordinates p_coordinates)
        + void changeWeather()
    }

    class Baloon {
        + Baloon(long p_id, String p_name, Coordinates p_coordinates)
        + void updateConditions()

        # void weatherRain()
        # void weatherFog()
        # void weatherSun()
        # void weatherSnow()    
    }
    class Helicopter {
        + Helicopter(long p_id, String p_name, Coordinates p_coordinates)
        + void updateConditions()

        # void weatherRain()
        # void weatherFog()
        # void weatherSun()
        # void weatherSnow()    
    }
    class JetPlane {
        + JetPlane(long p_id, String p_name, Coordinates p_coordinates)
        + void updateConditions()

        # void weatherRain()
        # void weatherFog()
        # void weatherSun()
        # void weatherSnow()    
    }

    class AircraftFactory {
        <<singleton>>
        + Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    }

    class Printer {
        <<utility>>
        + static void print(String message, String coordinates)
        - static void toConsole(String message, String coordinates)
        - static void toFile(String message, String coordinates)
    }
    
    class Validator {
        + static void validateFileExtension(String fileName)
        + static int getGeoCoord(String s_value)
        + static int getHeight(String s_height)
    }

    class Simulator {
        - WeatherTower weatherTower
        - int simulationCycles
        - List<Flyable> getFlyables(String fileName)
        - void runSimulation(List<Flyable> flyables)
        + static void main(String[] args)
    }

    Flyable <|.. Aircraft
    Tower <|-- WeatherTower
    Tower o-- Flyable
    WeatherTower --o Flyable
    Aircraft *-- Coordinates

    Aircraft <|-- Baloon 
    Aircraft <|-- Helicopter 
    Aircraft <|-- JetPlane

    Tower ..> Printer : uses
    Aircraft ..> Printer : uses
    Simulator ..> Validator : uses
    Simulator ..> AircraftFactory : uses
    WeatherTower ..> WeatherProvider : uses

    Simulator o-- WeatherTower
    
```

## Requirements

- Java 17 LTS
- No external libraries or build tools

## Design Patterns

- **Observer:** Tower/WeatherTower notifies registered aircraft of weather changes
- **Singleton:** WeatherProvider and AircraftFactory single instances
- **Factory:** AircraftFactory creates aircraft based on type string
