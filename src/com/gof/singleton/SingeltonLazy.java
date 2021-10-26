package com.gof.singleton;

public class SingeltonLazy {
    private static volatile SingeltonLazy singeltonLazy = null;
    private SingeltonLazy () {}

    public static SingeltonLazy getInstance(){
        if (singeltonLazy == null) {
            synchronized (SingeltonLazy.class) {
                if (null == singeltonLazy) {
                    singeltonLazy = new SingeltonLazy();
                }
            }
        }
        return singeltonLazy;
    }

}
