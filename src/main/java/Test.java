import Controller.Api_Service;
import Controller.Db_Handler;
import Controller.Wifi.Wifi_Service;
import Controller.Wifi_History.Wifi_History_Service;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        Db_Handler d = new Db_Handler();
        d.tableInitalize();
    }
}
