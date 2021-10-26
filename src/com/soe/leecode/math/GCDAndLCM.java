package com.soe.leecode.math;

/**
 * greatest common divisor得两个数的最大公因数
 * 辗转相除法
 */
/**
 * least common multiple, lcm,最小公倍数
 * 辗转相除法
 */

import java.util.Arrays;

/**
 * 扩展欧几里得算法（extended gcd）在求得 a 和 b 最大公因数的同
 * 时，也得到它们的系数 x 和 y，从而使 ax + by = gcd(a, b)。
 */
public class GCDAndLCM {
    public static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm (int a, int b) {
        return b * a / gcd(a , b);
    }
    public static int xGCD(int a, int b, Int x, Int y) {
        if (b == 0) {
            x.vaule = 1; y.vaule = 0;
            return a;
        }
        Int x1 = new Int();
        Int y1 = new Int();
        int gcd = xGCD(b, a % b, x1, y1);
        x = y1; y = new Int(x1.vaule - (a / b) * y1.vaule);
        return gcd;
    }

    public static void main(String[] args) {
        int gcd = gcd(2, 3);
        System.out.println("gcd ->" + gcd);
        Int x = new Int();
        Int y = new Int();
        int res = xGCD(2,3,new Int(),new Int());
        System.out.println(res + " "+ x.vaule +" " +y.vaule);
    }
    /**
     * java无指针 用指针比较方便
     */
    static class Int {
        int vaule;
        public Int(){};
        public Int(int v) {
            this.vaule = v;
        }
    }

}
