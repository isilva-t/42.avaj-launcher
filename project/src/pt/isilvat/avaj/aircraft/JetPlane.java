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
        super.changeCoordinates(0, 5, 0);
        super.printChildMessage(super.rainMsg + rainMsg);
    }

    protected void weatherFog() {
        super.changeCoordinates(0, 1, 0);
        super.printChildMessage(super.fogMsg + fogMsg);
    }

    protected void weatherSun() {
        super.changeCoordinates(0, 10, 2);
        super.printChildMessage(super.sunMsg + sunMsg);
    }

    protected void weatherSnow() {
        super.changeCoordinates(0, 0, -7);
        super.printChildMessage(super.snowMsg + snowMsg);
    }
}