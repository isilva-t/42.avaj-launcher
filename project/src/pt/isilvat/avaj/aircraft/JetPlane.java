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