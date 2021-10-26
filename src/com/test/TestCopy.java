package com.test;


import java.util.Arrays;

public class TestCopy {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        Integer[] b = Arrays.copyOf(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println();
        for (int i : b) {
            System.out.println(i);
        }
    }
}
