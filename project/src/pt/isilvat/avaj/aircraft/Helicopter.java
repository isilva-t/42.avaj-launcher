package pt.isilvat.avaj.aircraft;

public class Helicopter extends Aircraft {

    protected String rainMsg = super.rainMsg + "So much water out there?";
    protected String fogMsg = super.fogMsg + "It's outside, not our windows messed up!";
    protected String sunMsg = super.sunMsg + "Yay, enjoy the ride!";
    protected String snowMsg = super.snowMsg + "Keep up power! Keep it warm!";
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
    }

}