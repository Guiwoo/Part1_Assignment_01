package Controller.Wifi_History;

public class Wifi_History_Entity {
    public static final String Wifi_History_table = "CREATE TABLE  IF NOT EXISTS WIFI_HISTORY(" +
            " ID integer primary key autoincrement," +
            " LAT real," +
            " LNT real," +
            " DATE text" +
            ")";
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
