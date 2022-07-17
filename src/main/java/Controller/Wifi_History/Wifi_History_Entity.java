package Controller.Wifi_History;

public class Wifi_History_Entity {
    public int id;
    public double LAT ;
    public double LNT;
    public String DATE;

    public Wifi_History_Entity(double LAT, double LNT, String DATE) {
        this.LAT = LAT;
        this.LNT = LNT;
        this.DATE = DATE;
    }

    public void setId(int id) {
        this.id = id;
    }
}
