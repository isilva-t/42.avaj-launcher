package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.weather.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower = null;

    Flyable () {

    }

    public abstract void updateConditions();
    
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }

}

