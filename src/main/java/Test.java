import Controller.Api_Service;
import Controller.Db_Handler;
import Controller.Wifi.Wifi_Service;

public class Test {
    public static void main(String[] args) {
        Wifi_Service w = new Wifi_Service();
//        Api_Service a = new Api_Service();
        w.createWifi();
        /**
         * 37.5544069
         * 126.8998666
         * */
    }
}
