package Controller.Wifi;

public class Wifi_Entity {
    public String X_SWIFI_MGR_NO	;
    public String X_SWIFI_WRDOFC	;
    public String X_SWIFI_MAIN_NM	;
    public String X_SWIFI_ADRES1	;
    public String X_SWIFI_ADRES2	;
    public String X_SWIFI_INSTL_FLOOR;
    public String X_SWIFI_INSTL_TY	;
    public String X_SWIFI_INSTL_MBY	;
    public String X_SWIFI_SVC_SE	;
    public String X_SWIFI_CMCWR	;
    public String X_SWIFI_CNSTC_YEAR	;
    public String X_SWIFI_INOUT_DOOR	;
    public String X_SWIFI_REMARS3	;
    public double LAT;
    public double LNT;
    public String WORK_DTTM	;
    public double distance;

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
