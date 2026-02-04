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
        super.weatherRain();
        System.out.println(rainMsg);
    }

    protected void weatherFog() {
        super.weatherFog();
        System.out.println(fogMsg);
    }

    protected void weatherSun() {
        super.weatherSun();
        System.out.println(sunMsg);
    }

    protected void weatherSnow() {
        super.weatherSnow();
        System.out.println(snowMsg);
    }
}