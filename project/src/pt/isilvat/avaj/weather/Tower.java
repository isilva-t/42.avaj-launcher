package pt.isilvat.avaj.weather;

import java.util.ArrayList;
import java.util.List;
import pt.isilvat.avaj.aircraft.Flyable;


public class Tower {

    Tower() {
    }

    private List<Flyable> observers = new ArrayList<>();

    protected void conditionChanged() {

    }

    public void register(Flyable p_flyable) {

    }
    public void unregister(Flyable p_flyable) {

    }
}