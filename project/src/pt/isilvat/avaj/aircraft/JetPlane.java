package pt.isilvat.avaj.aircraft;

public class JetPlane extends Aircraft {

    protected String rainMsg = "Fine, we need some washing!";
    protected String fogMsg = "Where are we going?";
    protected String sunMsg = "IIIIIhaaaaaaa!";
    protected String snowMsg = "Keep the power man, we need warmed motors!";

    public JetPlane (
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