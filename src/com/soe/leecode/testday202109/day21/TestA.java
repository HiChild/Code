package com.soe.leecode.testday202109.day21;

public class TestA {
    public TestA() {
        System.out.println("A1");
    }

    {
        System.out.println("A2");
    }

    static {
        System.out.println("A3");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}

class HelloB extends TestA {
    public HelloB(){
        System.out.println("B1");
    }

    {
        System.out.println("B2");
    }

    static {
        System.out.println("B3");
    }

}
