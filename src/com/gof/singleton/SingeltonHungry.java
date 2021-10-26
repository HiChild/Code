package com.gof.singleton;

public class SingeltonHungry {
    private SingeltonHungry(){}
    private static SingeltonHungry singletonHungry = new SingeltonHungry();

    public static SingeltonHungry getInstance() {
        return singletonHungry;
    }
}
