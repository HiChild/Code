package fenbushi.test1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class WeatherImpl extends UnicastRemoteObject implements IWeather {
    public WeatherImpl() throws RemoteException {
    }

    public String getWeather(String city) {
        String Weather = new String(city);
        boolean status1 = Weather.contains("北京");
        boolean status2 = Weather.contains("上海");
        if (status1) {
            return city + " 今日晴朗，气温21°，适合观影。";
        } else if (status2) {
            return city + " 今日中到大雨，气温15°，不适合观影。";
        } else {
            return city + " 今日气象信息暂未更新。";
        }
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("/weather", new WeatherImpl());
//            System.out.println("服务对象已绑定至注册表...");
            System.out.println("绑定服务对象到注册表失败...");
        } catch (Exception e) {
            System.out.println("绑定服务对象到注册表失败...");
        }
    }
}