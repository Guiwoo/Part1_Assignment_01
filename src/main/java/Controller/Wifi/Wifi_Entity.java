package Controller.Wifi;

import lombok.Data;

@Data
public class Wifi_Entity {
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
     private String X_SWIFI_MGR_NO	;
     private String X_SWIFI_WRDOFC	;
     private String X_SWIFI_MAIN_NM	;
     private String X_SWIFI_ADRES1	;
     private String X_SWIFI_ADRES2	;
     private String X_SWIFI_INSTL_FLOOR;
     private String X_SWIFI_INSTL_TY	;
     private String X_SWIFI_INSTL_MBY	;
     private String X_SWIFI_SVC_SE	;
     private String X_SWIFI_CMCWR	;
     private String X_SWIFI_CNSTC_YEAR	;
     private String X_SWIFI_INOUT_DOOR	;
     private String X_SWIFI_REMARS3	;
     private double LAT;
     private double LNT;
     private String WORK_DTTM	;
     private double distance;
    public Wifi_Entity(String x_SWIFI_MGR_NO, String x_SWIFI_WRDOFC, String x_SWIFI_MAIN_NM, String x_SWIFI_ADRES1, String x_SWIFI_ADRES2, String x_SWIFI_INSTL_FLOOR, String x_SWIFI_INSTL_TY, String x_SWIFI_INSTL_MBY, String x_SWIFI_SVC_SE, String x_SWIFI_CMCWR, String x_SWIFI_CNSTC_YEAR, String x_SWIFI_INOUT_DOOR, String x_SWIFI_REMARS3, double LAT, double LNT,
                       String WORK_DTTM) {
        X_SWIFI_MGR_NO = x_SWIFI_MGR_NO;
        X_SWIFI_WRDOFC = x_SWIFI_WRDOFC;
        X_SWIFI_MAIN_NM = x_SWIFI_MAIN_NM;
        X_SWIFI_ADRES1 = x_SWIFI_ADRES1;
        X_SWIFI_ADRES2 = x_SWIFI_ADRES2;
        X_SWIFI_INSTL_FLOOR = x_SWIFI_INSTL_FLOOR;
        X_SWIFI_INSTL_TY = x_SWIFI_INSTL_TY;
        X_SWIFI_INSTL_MBY = x_SWIFI_INSTL_MBY;
        X_SWIFI_SVC_SE = x_SWIFI_SVC_SE;
        X_SWIFI_CMCWR = x_SWIFI_CMCWR;
        X_SWIFI_CNSTC_YEAR = x_SWIFI_CNSTC_YEAR;
        X_SWIFI_INOUT_DOOR = x_SWIFI_INOUT_DOOR;
        X_SWIFI_REMARS3 = x_SWIFI_REMARS3;
        this.LAT = LAT;
        this.LNT = LNT;
        this.WORK_DTTM = WORK_DTTM;
    }
    public void setDistance(double dis){
        this.distance = dis;
    }
}
