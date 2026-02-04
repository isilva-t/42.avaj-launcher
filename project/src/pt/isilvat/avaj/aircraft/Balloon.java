package pt.isilvat.avaj.aircraft;

public class Balloon extends Aircraft {

    protected String rainMsg = "Our box it's floded!";
    protected String fogMsg = "So much money to see nothing!";
    protected String sunMsg = "Let's enjoy the day!";
    protected String snowMsg = "Its SNOWing, we're going to die!";

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