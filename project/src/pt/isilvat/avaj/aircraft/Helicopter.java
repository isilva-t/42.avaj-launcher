package pt.isilvat.avaj.aircraft;

public class Helicopter extends Aircraft {

    protected String rainMsg = "So much water out there?";
    protected String fogMsg = "It's outside, not our windows messed up!";
    protected String sunMsg = "Yay, enjoy the ride!";
    protected String snowMsg = "Maintain the power, the engine cannot cool down!";

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

    @Override
    public void updateConditions() {
        super.updateConditions();
    }

    @Override
    protected void weatherRain() {
        super.changeCoordinates(5, 0, 0);
        super.printChildMessage(super.rainMsg + rainMsg);
    }

    @Override
    protected void weatherFog() {
        super.changeCoordinates(1, 0, 0);
        super.printChildMessage(super.fogMsg + fogMsg);
    }

    @Override
    protected void weatherSun() {
        super.changeCoordinates(10, 0, 2);
        super.printChildMessage(super.sunMsg + sunMsg);
    }

    @Override
    protected void weatherSnow() {
        super.changeCoordinates(0, 0, -12);
        super.printChildMessage(super.snowMsg + snowMsg);
    }
}