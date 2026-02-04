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

```mermaid

classDiagram

    class Tower {    
        - List<'Flyable'> observers

        + void register(Flyable* p_flyable)
        + void unregister(Flyable p_flyable)
    }

    class Flyable {
        <<abstract>>
        + abstract void updateConditions()
        + void registerTower()
        + void unregisterTower()
    }

    
    class Aircraft {
        # long id
        # String name
        # Coordinates coordinates

        # Aircraft(long p_id, String p_name, Coordinates p_coordinates)
        + checkHeight()
    }

    class Coordinates {
        - int longitude
        - int latitude
        - int height

        Coordinates(int p_longitude, int p_latitude, int p_height)

        + int getLongitude()
        + int getLatitude()
        + int getHeight()
    }

    class WeatherProvider {
        <<singleton>>
        - string[] weather
        + string getCurrentWeather(Coordinates p_coordinates)
        + WeatherProvider getInstance()
    }

    class WeatherTower {
        + srting getWeather(Coordinates p_coordinates)
        + void changeWeather()
    }

    class Baloon {
        + Baloon(long p_id, string p_name, Coordinates p_coordinates)
        + void updateConditions()
    }
    class Helicopter {
        + Baloon(long p_id, string p_name, Coordinates p_coordinates)
        + void updateConditions()
    }
    class JetPlane {
        + Baloon(long p_id, string p_name, Coordinates p_coordinates)
        + void updateConditions()
    }

    class AircraftFactory {
        <<singleton>>
        + Flyable newAircraft(string p_type, string p_name, Coordinates p_coordinates)
        + AircraftFactory getInstance()
    }

    Flyable <|.. Aircraft
    Tower <|-- WeatherTower
    Tower o-- Flyable
    WeatherTower --o Flyable
    Aircraft *-- Coordinates

    Aircraft <|-- Baloon 
    Aircraft <|-- Helicopter 
    Aircraft <|-- JetPlane
```

## Requirements

- Java 17 LTS
- No external libraries or build tools

## Design Patterns

- **Observer:** Tower/WeatherTower notifies registered aircraft of weather changes
- **Singleton:** WeatherProvider and AircraftFactory single instances
- **Factory:** AircraftFactory creates aircraft based on type string
