package com.interview;

public class Main2 {
    public static void main(String[] args) {
        int k = getK(10, 5, 3, 2);
        System.out.println(k);
    }

    public static int getK(int a, int b, int f, int k) {
        //b能量
        boolean flagZero = true;
        int bMax = b;
        int fCount = 0;
        boolean isCharge = false;
        if (b < f) return -1;
        while (k != 0) {
            int distance = flagZero ? f : a - f;
            if ( b - a < distance) {
                if (b >= distance) {
                    b = bMax;
                    fCount++;
                    isCharge = true;
                }else {
                    return -1;
                }

            }
            int resDistance;
            if (isCharge) {
                resDistance = flagZero ? a - f : f;
            } else {
                resDistance = a;
            }
            b -= resDistance;
            k--;
            flagZero = !flagZero;
        }
        return fCount;
    }
}
