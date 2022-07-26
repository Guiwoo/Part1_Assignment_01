package Controller.Wifi_History;

public class Wifi_History_Utility {
    public static final String wifiHistoryTable = "CREATE TABLE  " +
            "IF NOT EXISTS WIFI_HISTORY( " +
            "ID integer primary key autoincrement, LAT real, LNT real, DATE text" +
            ")";
}
