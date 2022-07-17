package Controller.Wifi;

import Controller.Api_Service;
import Controller.Db_Handler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Wifi_Service extends Db_Handler {
    public void main(){
        this.createTables();
        createWifi();
    }
    private void createWifi(){
        init();
        Api_Service a = new Api_Service();
        List<List<Wifi_Entity>> list = a.getData();
        String sql = Wifi_Utility.CREATE_WIFI;
        try{
            connection.setAutoCommit(false);
            for (int i = 0; i < list.size(); i++) {
                PreparedStatement prep = connection.prepareStatement(sql);
                for (int j = 0; j < list.get(i).size(); j++) {
                    Wifi_Entity w = list.get(i).get(j);
                    prep.setString(1,w.X_SWIFI_MGR_NO);
                    prep.setString(2,w.X_SWIFI_WRDOFC);
                    prep.setString(3,w.X_SWIFI_MAIN_NM);
                    prep.setString(4,w.X_SWIFI_ADRES1);
                    prep.setString(5,w.X_SWIFI_ADRES2);
                    prep.setString(6,w.X_SWIFI_INSTL_FLOOR);
                    prep.setString(7,w.X_SWIFI_INSTL_TY);
                    prep.setString(8,w.X_SWIFI_INSTL_MBY);
                    prep.setString(9,w.X_SWIFI_SVC_SE);
                    prep.setString(10,w.X_SWIFI_CMCWR);
                    prep.setString(11,w.X_SWIFI_CNSTC_YEAR);
                    prep.setString(12,w.X_SWIFI_INOUT_DOOR);
                    prep.setString(13,w.X_SWIFI_REMARS3);
                    prep.setDouble(14,w.LNT);
                    prep.setDouble(15,w.LAT);
                    prep.setString(16,w.WORK_DTTM);
                    prep.addBatch();
                }
                prep.executeBatch();
                connection.commit();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        close(this.connection);
    }
    public List<Wifi_Entity> getNearBy(double lat,double lnt){
        List<Wifi_Entity> rs = new LinkedList<>();
        String sql = "SELECT  round(6371 * acos( cos( radians(LAT) )\n" +
                "                               * cos( radians("+ lat +") )\n" +
                "                               * cos( radians( "+ lnt +" ) - radians(LNT) )\n" +
                "                               + sin( radians(LAT) ) * sin( radians( "+ lat +  ") ) ), 4) as distance,*\n" +
                "from WIFI\n" +
                "order by distance\n" +
                "limit 20";

        init();
        try{
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet result = p.executeQuery();
            while(result.next()){
                Wifi_Entity w = new Wifi_Entity(
                        result.getString("X_SWIFI_MGR_NO"),
                        result.getString("X_SWIFI_WRDOFC"),
                        result.getString("X_SWIFI_MAIN_NM"),
                        result.getString("X_SWIFI_ADRES1"),
                        result.getString("X_SWIFI_ADRES2"),
                        result.getString("X_SWIFI_INSTL_FLOOR"),
                        result.getString("X_SWIFI_INSTL_TY"),
                        result.getString("X_SWIFI_INSTL_MBY"),
                        result.getString("X_SWIFI_SVC_SE"),
                        result.getString("X_SWIFI_CMCWR"),
                        result.getString("X_SWIFI_CNSTC_YEAR"),
                        result.getString("X_SWIFI_INOUT_DOOR"),
                        result.getString("X_SWIFI_REMARS3"),
                        result.getDouble("LAT"),
                        result.getDouble("LNT"),
                        result.getString("WORK_DTTM")
                );
                w.setDistance(result.getDouble("distance"));
                rs.add(w);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        close(this.connection);
        return rs;
    }
    public void createHistory(double lat,double lnt){
        String sql2 = "insert or replace into wifi_history ("+
                " LAT," +
                " LNT ," +
                " DATE "+
                ") values (?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String s = now.now().toString().substring(0,19);
        init();
        try{
            PreparedStatement p2 = connection.prepareStatement(sql2);
            p2.setDouble(1,lat);
            p2.setDouble(2,lnt);
            p2.setString(3,s);

            p2.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        close(this.connection);
    }
}
