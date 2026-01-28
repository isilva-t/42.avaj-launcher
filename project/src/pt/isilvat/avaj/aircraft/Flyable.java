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

    public void unregisterTower() {
        if (this.weatherTower != null) {
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
    }

    public abstract String getFullName();
}

