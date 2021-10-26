package com.soe.leecode.testday202109.day21;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b= 0.9f - 0.8f;
        boolean res1 = a == b;
        Float x = Float.valueOf(a);
        Float y = Float.valueOf(b);
        boolean res2= x.equals(y);
        System.out.println(res1);
        System.out.println(res2);
    }
    class MyTest {
        public void teset() {

        }
    }
}
