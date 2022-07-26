package Controller.Wifi_History;

import lombok.Data;

@Data
public class Wifi_History_Entity {
    private int id;
    private double LAT ;
    private double LNT;
    private String DATE;

    public Wifi_History_Entity(double LAT, double LNT, String DATE) {
        this.LAT = LAT;
        this.LNT = LNT;
        this.DATE = DATE;
    }

    public void setId(int id) {
        this.id = id;
    }

}
