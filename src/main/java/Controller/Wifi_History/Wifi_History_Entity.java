package Controller.Wifi_History;

import lombok.Data;

@Data
public class Wifi_History_Entity {
    public static final String Wifi_History_table = "CREATE TABLE  IF NOT EXISTS WIFI_HISTORY(" +
            " ID integer primary key autoincrement," +
            " LAT real," +
            " LNT real," +
            " DATE text" +
            ")";
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
