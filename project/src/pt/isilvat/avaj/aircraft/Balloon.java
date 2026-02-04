package pt.isilvat.avaj.aircraft;

public class Balloon extends Aircraft {

    protected String rainMsg = super.rainMsg + "Our box it's floded!";
    protected String fogMsg = super.fogMsg + "So much money to see nothing!";
    protected String sunMsg = super.sunMsg + "Let's enjoy the day!";
    protected String snowMsg = super.snowMsg + "Its SNOWing, we're going to die!";

    public Balloon (
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
        super.weatherRain();
    }

    protected void weatherFog() {
        super.weatherFog();
    }

    protected void weatherSun() {
        super.weatherSun();
    }

    protected void weatherSnow() {
        super.weatherSnow();
    }
}