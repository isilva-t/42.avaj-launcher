package pt.isilvat.avaj.aircraft;

import pt.isilvat.avaj.weather.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower = null;
    protected String onLand = " is on land.";
    protected String landing = " landing.";

    Flyable () {

    }

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        if (p_tower == null) {
            return;
        }
        this.weatherTower = p_tower;
        weatherTower.register(this);
        checkHeight(onLand);
    }

    protected void unregisterTower() {
        if (this.weatherTower != null) {
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
    }

    public abstract String getFullName();
    protected abstract void checkHeight(String whatIsDoing);
}

