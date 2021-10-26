package com.interview;

public class Main7 {
    public static void main(String[] args) {
        int mask = getMask("aceg");
        System.out.println(mask);
    }

    public static int getMask(String string) {
        int mask = 0;
        for (char ch : string.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }
        return mask;
    }
}
