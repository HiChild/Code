package com.soe.leecode.testday202109.day21;

public class Test2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                second();
            }
        };
        t.start();
        System.out.println("first");
    }
    static void second() {
        System.out.println("ssss");
    }
}
