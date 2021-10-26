package com.soe.leecode.mathTest;

public class GCDTest {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lmc (int a, int b) {
        return b * a / gcd(a , b);
    }
}
