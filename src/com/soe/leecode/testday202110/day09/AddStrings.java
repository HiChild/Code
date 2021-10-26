package com.soe.leecode.testday202110.day09;


public class AddStrings {

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        String s = addStrings.addStrings("199", "99");
        System.out.println(s);
    }

    public String addStrings(String num1, String num2) {
        String str1 = new StringBuilder(num1).reverse().toString();
        String str2 = new StringBuilder(num2).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int c = 0;
        int i = 0, j = 0;
        for (; i < str1.length() && j < str2.length(); ++i, ++j) {
            int char1 = str1.charAt(i) - '0';
            int char2 = str2.charAt(j) - '0';
            int res = char1 + char2 + c;
            if (res < 10) {
                c = 0;
            } else {
                c = 1;
                res %= 10;
            }
            sb.append(res);
        }
        if (i == str1.length()) {
            while (j < str2.length()) {
                int res = (str2.charAt(j++) - '0') + c;
                if (res == 10) {
                    res = 0;
                    c = 1;
                }else {
                    c = 0;
                }
                sb.append(res);
            }
        } else {
            while (i < str1.length()) {
                int res = (str1.charAt(i++) - '0') + c;
                if (res == 10) {
                    res = 0;
                    c = 1;
                }else {
                    c = 0;
                }
                sb.append(res);
            }
        }
        if (c == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
