package fenbushi.test1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IWeather extends Remote {
    public String getWeather(String city) throws RemoteException;
}