package pt.isilvat.avaj.aircraft;

public class JetPlane extends Aircraft {

    protected String rainMsg = "Fine, we need some washing!";
    protected String fogMsg = "Where are we going?";
    protected String sunMsg = "IIIIIhaaaaaaa!";
    protected String snowMsg = "Keep the power man, we need warm engines!";

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

    @Override
    public void updateConditions() {
        super.updateConditions();
    }

    @Override
    protected void weatherRain() {
        super.changeCoordinates(0, 5, 0);
        super.printChildMessage(super.rainMsg + rainMsg);
    }

    @Override
    protected void weatherFog() {
        super.changeCoordinates(0, 1, 0);
        super.printChildMessage(super.fogMsg + fogMsg);
    }

    @Override
    protected void weatherSun() {
        super.changeCoordinates(0, 10, 2);
        super.printChildMessage(super.sunMsg + sunMsg);
    }

    @Override
    protected void weatherSnow() {
        super.changeCoordinates(0, 0, -7);
        super.printChildMessage(super.snowMsg + snowMsg);
    }
}