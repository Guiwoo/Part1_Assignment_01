package Controller.Wifi;

public class Wifi_Utility {
    public static final String CREATE_WIFI = "insert or replace into wifi(" +
            "X_SWIFI_MGR_NO," +
            " X_SWIFI_WRDOFC, " +
            "X_SWIFI_MAIN_NM, " +
            "X_SWIFI_ADRES1, " +
            "X_SWIFI_ADRES2, " +
            "X_SWIFI_INSTL_FLOOR, " +
            "X_SWIFI_INSTL_TY, " +
            "X_SWIFI_INSTL_MBY, " +
            "X_SWIFI_SVC_SE, " +
            "X_SWIFI_CMCWR, " +
            "X_SWIFI_CNSTC_YEAR, " +
            "X_SWIFI_INOUT_DOOR, " +
            "X_SWIFI_REMARS3," +
            "LAT, " +
            "LNT, " +
            "WORK_DTTM )" +
            " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
