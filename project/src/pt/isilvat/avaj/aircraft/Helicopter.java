package pt.isilvat.avaj.aircraft;

public class Helicopter extends Aircraft {

    protected String rainMsg = "So much water out there?";
    protected String fogMsg = "It's outside, not our windows messed up!";
    protected String sunMsg = "Yay, enjoy the ride!";
    protected String snowMsg = "Keep up power! Keep it warm!";

    public Helicopter (
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
        super.changeCoordinates(5, 0, 0);
        super.printChildMessage(super.rainMsg + rainMsg);
    }

    protected void weatherFog() {
        super.changeCoordinates(1, 0, 0);
        super.printChildMessage(super.fogMsg + fogMsg);
    }

    protected void weatherSun() {
        super.changeCoordinates(10, 0, 2);
        super.printChildMessage(super.sunMsg + sunMsg);
    }

    protected void weatherSnow() {
        super.changeCoordinates(0, 0, -12);
        super.printChildMessage(super.sunMsg + snowMsg);
    }
}