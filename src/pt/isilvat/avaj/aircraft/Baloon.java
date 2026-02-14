package pt.isilvat.avaj.aircraft;

public class Baloon extends Aircraft {

    protected String rainMsg = "Our box it's floded!";
    protected String fogMsg = "So much money on this trip to see nothing!";
    protected String sunMsg = "Let's enjoy this beautifull day!";
    protected String snowMsg = "It's SNOWing, we're going to die!";

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

    @Override
    public void updateConditions() {
        super.updateConditions();
    }

    @Override
    protected void weatherRain() {        
        super.changeCoordinates(0, 0, -5);
        super.printChildMessage(super.rainMsg + rainMsg);
    }

    @Override
    protected void weatherFog() {        
        super.changeCoordinates(0, 0, -3);
        super.printChildMessage(super.fogMsg + fogMsg);
    }

    @Override
    protected void weatherSun() {        
        super.changeCoordinates(2, 0, 4);
        super.printChildMessage(super.sunMsg + sunMsg);
    }

    @Override
    protected void weatherSnow() {
        super.changeCoordinates(0, 0, -15);
        super.printChildMessage(super.snowMsg + snowMsg);
    }
}