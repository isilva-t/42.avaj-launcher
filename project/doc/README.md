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

## Objectives

As a 42 Project, the learning purposes and objectives of this project are:
- Enter in the Java path, after C/C++
- Introduce to the concept of UML class diagrams
- Object Oriented Design Patterns: Observer, Singleton and Factory

## Usage Instructions

// TODO

## Scenario File Format

The scenario file defines the simulation parameters and initial aircraft fleet.

### File Structure
```
<number_of_weather_changes>
<TYPE> <NAME> <LONGITUDE> <LATITUDE> <HEIGHT>
<TYPE> <NAME> <LONGITUDE> <LATITUDE> <HEIGHT>
...
```

### Example
```
25
Baloon B1 2 3 20
JetPlane J1 23 44 32
Helicopter H1 654 33 20
```

### Format Rules
- **Line 1**: Positive integer representing number of weather simulation cycles
- **Remaining lines**: Aircraft definitions with 5 space-separated values:
  - `TYPE`: Aircraft type (`Baloon`, `JetPlane`, or `Helicopter`)
  - `NAME`: Unique identifier for the aircraft
  - `LONGITUDE`: Positive integer for longitude coordinate
  - `LATITUDE`: Positive integer for latitude coordinate  
  - `HEIGHT`: Integer in range **0-100**

### Validation
The program validates:
- ✅ File must have `.txt` extension
- ✅ First line must be a positive integer
- ✅ Height must be between 0 and 100 (inclusive)
- ✅ Coordinates (longitude/latitude) must be positive
- ✅ Aircraft type must be valid (`Baloon`, `JetPlane`, `Helicopter`)
Invalid input will cause the program to exit with an error message.

Note: Due to the inconsistency in the 42 subject, the word "Baloon" is intentionally misspelled.

## Aircraft Weather Behaviour

| Aircraft | SUN | RAIN | FOG | SNOW |
|----------|-----|------|-----|------|
| **JetPlane** | Lat +10, H +2 | Lat +5 | Lat +1 | H -7 |
| **Helicopter** | Lon +10, H +2 | Lon +5 | Lon +1 | H -12 |
| **Balloon** | Lon +2, H +4 | H -5 | H -3 | H -15 |

*Lon = Longitude, Lat = Latitude, H = Height*

### Important Notes
- If height would exceed 100, it caps at 100
- If height reaches 0 or below, aircraft lands and unregisters from tower
- Weather is generated based on 3D coordinates (longitude, latitude, height)

## Example Output

// TODO

## Initialization Phase

INITIALIZATION_HERE

## Simulation Phase

SIMULATION_HERE

## UML Class diagram

MERMAID_HERE

## Project Structure

// TODO

## Requirements

- Java 17 LTS
- No external libraries or build tools

## Design Patterns

- **Observer:** Tower/WeatherTower notifies registered aircraft of weather changes
- **Singleton:** WeatherProvider and AircraftFactory single instances
- **Factory:** AircraftFactory creates aircraft based on type string