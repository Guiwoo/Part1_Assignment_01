package Controller;

import Controller.Wifi.Wifi_Entity;
import com.google.gson.*;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

public class Api_Service {
    public List<List<Wifi_Entity>> list;
    public static int totalPage;
    JsonArray[] arr;
    Gson g;
    String API_KEY;
    String BASE_URL;
    public Api_Service(){
        list = new LinkedList<>();
        g = new Gson();
        API_KEY = System.getenv("API_KEY");
        System.out.println("API_KEY is Updated");
        BASE_URL = String.format("http://openapi.seoul.go.kr:8088/%s/json/TbPublicWifiInfo/",API_KEY);
        setTotalPage();
    }
    class API_Runnable implements Runnable{
        int startPage;
        int endPage;
        API_Runnable(int startPage,int endPage){
            this.startPage = startPage;
            this.endPage = endPage;
        }
        public synchronized void tasks(){
            try {
                URL url = new URL(BASE_URL+startPage+"/"+endPage+"/");
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                if(conn.getResponseCode() == 200) {
                    BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
                    String rs = bf.readLine();
                    JsonElement el = JsonParser.parseString(rs);
                    JsonObject object = el.getAsJsonObject();
                    JsonArray wifiArr = (object.get("TbPublicWifiInfo").getAsJsonObject().get("row").getAsJsonArray());
                    arr[(startPage-1)/1000] = wifiArr;
                }
            } catch (ProtocolException e) {
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void run(){
            tasks();
        };

    }
    public List<List<Wifi_Entity>> getData(){
        ThreadGroup tg = new ThreadGroup("g");
        for (int i = 0; i < arr.length; i++) {
            API_Runnable api_runnable = new API_Runnable(i*1000+1,(i+1)*1000);
            Thread thread = new Thread(tg,api_runnable);
            thread.start();
        }

        while(tg.activeCount()>0){}

        for (int i = 0; i < arr.length; i++) {
            List<Wifi_Entity> subList = new LinkedList<>();
            for (int j = 0; j < arr[i].size(); j++) {
                Wifi_Entity w = g.fromJson(arr[i].get(j), Wifi_Entity.class);
                subList.add(w);
            }
            list.add(subList);
        }
        return list;
    }
    public void setTotalPage(){
        try{
            URL url = new URL(BASE_URL+"1/2");
            URLConnection request = url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootobj = root.getAsJsonObject();
            String data = rootobj.get("TbPublicWifiInfo").getAsJsonObject().get("list_total_count").getAsString();
            totalPage = Integer.parseInt(data);
            int rest = totalPage%1000;
            arr = new JsonArray[(totalPage/1000)+1];
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
