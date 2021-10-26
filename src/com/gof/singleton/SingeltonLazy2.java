package com.gof.singleton;

public class SingeltonLazy2 {
    private static volatile SingeltonLazy2 singeltonLazy2 = null;
    private SingeltonLazy2() {}

    public static SingeltonLazy2 getInstance() {
        if (null == singeltonLazy2) {
            synchronized(SingeltonLazy2.class) {
                if (null == singeltonLazy2) {
                    singeltonLazy2 = new SingeltonLazy2();
                }
            }
        }
        return  singeltonLazy2;
    }
}
