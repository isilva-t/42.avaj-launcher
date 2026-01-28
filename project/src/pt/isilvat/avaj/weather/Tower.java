package pt.isilvat.avaj.weather;

import java.util.ArrayList;
import java.util.List;
import pt.isilvat.avaj.aircraft.Flyable;


public class Tower {

    Tower() {
    }

    private List<Flyable> observers = new ArrayList<>();
    private final String name = "Tower Says: ";
    protected void conditionChanged() {

    }

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
    }
    
    public void unregister(Flyable p_flyable) {
        String flyableName = p_flyable.getFullName();
        String className = this.getClass().getSimpleName();
        System.out.println(this.name + flyableName + "unregistered from " + className);
        this.observers.remove(p_flyable);
    }
}