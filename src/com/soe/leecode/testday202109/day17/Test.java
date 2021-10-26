package com.soe.leecode.testday202109.day17;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "asdfghjk";
        char[] chars = s.toCharArray();
        System.out.println("chars - > " + chars);
        System.out.println("toString() -> " + chars.toString());
        System.out.println("Arrays.toString() -> " + Arrays.toString(chars));
        System.out.println("String.valueOf() -> " + String.valueOf(chars));
        System.out.println("String() -> " + new String(chars));
    }
}
