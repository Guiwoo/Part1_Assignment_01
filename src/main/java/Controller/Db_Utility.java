package Controller;


public class Db_Utility {
    public static final String Wifi_Table = "CREATE TABLE IF NOT EXISTS WIFI ("+
            "X_SWIFI_MGR_NO text primary key,\n" +
            "X_SWIFI_WRDOFC text NULL,\n" +
            "X_SWIFI_MAIN_NM text NULL,\n" +
            "X_SWIFI_ADRES1 text NULL,\n" +
            "X_SWIFI_ADRES2 text NULL,\n" +
            "X_SWIFI_INSTL_FLOOR text NULL,\n" +
            "X_SWIFI_INSTL_TY text NULL,\n" +
            "X_SWIFI_INSTL_MBY text NULL,\n" +
            "X_SWIFI_SVC_SE text NULL,\n" +
            "X_SWIFI_CMCWR text NULL,\n" +
            "X_SWIFI_CNSTC_YEAR VARCHAR(13) NULL,\n" +
            "X_SWIFI_INOUT_DOOR VARCHAR(10) NULL,\n" +
            "X_SWIFI_REMARS3 text NULL,\n" +
            "LAT real NULL,\n" +
            "LNT real NULL,\n" +
            "WORK_DTTM text NULL" +
            ");";
    public static final String Wifi_History_table = "CREATE TABLE  IF NOT EXISTS WIFI_HISTORY(" +
            " ID integer primary key autoincrement," +
            " LAT real," +
            " LNT real," +
            " DATE text" +
            ")";
}
