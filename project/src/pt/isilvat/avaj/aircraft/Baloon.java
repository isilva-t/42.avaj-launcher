package pt.isilvat.avaj.aircraft;

public class Baloon extends Aircraft {

    protected String rainMsg = "Our box it's floded!";
    protected String fogMsg = "So much money to see nothing!";
    protected String sunMsg = "Let's enjoy the day!";
    protected String snowMsg = "Its SNOWing, we're going to die!";

    public Baloon (
        long p_id,
        String p_name,
        Coordinates p_coordinates
    ) {
        super(
            p_id, 
            p_name, 
            p_coordinates);
    }

    public void updateConditions() {
        super.updateConditions();
    }

    protected void weatherRain() {        
        super.changeCoordinates(0, 0, -5);
        super.printChildMessage(super.rainMsg + rainMsg);
    }

    protected void weatherFog() {        
        super.changeCoordinates(0, 0, -3);
        super.printChildMessage(super.fogMsg + fogMsg);
    }

    protected void weatherSun() {        
        super.changeCoordinates(2, 0, 4);
        super.printChildMessage(super.sunMsg + sunMsg);
    }

    protected void weatherSnow() {
        super.changeCoordinates(0, 0, -15);
        super.printChildMessage(super.sunMsg + snowMsg);
    }
}