package fenbushi.test1;

import java.rmi.registry.Registry;
import java.util.*;
import java.rmi.registry.LocateRegistry;

//剧院所在城市天气状况查询
public class WeatherClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            IWeather stub = (IWeather) registry.lookup("/weather");
            Scanner input = new Scanner(System.in);
            System.out.println("请输入要查询天气的城市名称：");
            String str = input.next();
            String result = stub.getWeather(str);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}