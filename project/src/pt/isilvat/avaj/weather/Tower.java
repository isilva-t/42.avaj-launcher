package pt.isilvat.avaj.weather;

import java.util.ArrayList;
import java.util.List;
import pt.isilvat.avaj.aircraft.Flyable;
import pt.isilvat.avaj.printer.Printer;


public class Tower {

    Tower() {
    }

    private List<Flyable> observers = new ArrayList<>();
    private final String name = "Tower Says:";
    private final String className = this.getClass().getSimpleName();

    protected void conditionChanged() {

        List<Flyable> observersShallowCopy = new ArrayList<>(this.observers);
        for (Flyable observer: observersShallowCopy) {
            observer.updateConditions();
        }
    }

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        Printer.print(
            this.name
            + " "
            + p_flyable.getFullName()
            + " "
            + "registered to"
            + " "
            + this.className,
            ""
        );
    }

    public void unregister(Flyable p_flyable) {
        String flyableName = p_flyable.getFullName();
        Printer.print(
            this.name 
            + " "
            + flyableName 
            + " "
            + "unregistered from" 
            + " "
            + this.className,
            "");
        this.observers.remove(p_flyable);
    }
}