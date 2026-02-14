# 42 Avaj Launcher

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

Compile:
```
make
```

run with scenario.txt:
```
make run
```

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
6
Baloon B1 25 4 10
JetPlane J1 23 44 13
Helicopter H1 654 33 1225
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

```
make run
java pt.isilvat.avaj.aircraft.Simulator scenario.txt
cat simulation.txt
Tower says: Baloon#B1(1) registered to weather tower                       
Tower says: JetPlane#J1(2) registered to weather tower                     
Tower says: Helicopter#H1(3) registered to weather tower                   
Baloon#B1(1) SUN ☀️  Let's enjoy this beautifull day!                      LON: 27, LAT: 4, H: 14
JetPlane#J1(2) FOG 🌫️  Where are we going?                                LON: 23, LAT: 45, H: 13
Helicopter#H1(3) SNOW ❄️  Maintain the power, we can't cool down!          LON: 654, LAT: 33, H: 0
Helicopter#H1(3) landing.                                                  LON: 654, LAT: 33, H: 0
Tower says: Helicopter#H1(3) unregistered from weather tower               
Baloon#B1(1) SUN ☀️  Let's enjoy this beautifull day!                      LON: 29, LAT: 4, H: 18
JetPlane#J1(2) RAIN ☔  Fine, we need some washing!                         LON: 23, LAT: 50, H: 13
Baloon#B1(1) SUN ☀️  Let's enjoy this beautifull day!                      LON: 31, LAT: 4, H: 22
JetPlane#J1(2) SNOW ❄️  Keep the power man, we need warm engines!          LON: 23, LAT: 50, H: 6
Baloon#B1(1) SUN ☀️  Let's enjoy this beautifull day!                      LON: 33, LAT: 4, H: 26
JetPlane#J1(2) RAIN ☔  Fine, we need some washing!                         LON: 23, LAT: 55, H: 6
Baloon#B1(1) SUN ☀️  Let's enjoy this beautifull day!                      LON: 35, LAT: 4, H: 30
JetPlane#J1(2) SNOW ❄️  Keep the power man, we need warm engines!          LON: 23, LAT: 55, H: 0
JetPlane#J1(2) landing.                                                    LON: 23, LAT: 55, H: 0
Tower says: JetPlane#J1(2) unregistered from weather tower                 
Baloon#B1(1) SUN ☀️  Let's enjoy this beautifull day!                      LON: 37, LAT: 4, H: 34
```

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