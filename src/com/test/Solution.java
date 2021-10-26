package com.test;

import java.util.Arrays;

public class Solution {

    static String  test = "1001";

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.maxLexicographical(test);
        System.out.println(s);
    }

    public String maxLexicographical (String num) {
        // write code here
        boolean isArrayZero = false;
        boolean isArrayOne = false;
        char[]  charNum = num.toCharArray();
        for (int i = 0; i < charNum.length && !isArrayZero; ++i) {
            if (charNum[i] == '0') {
                for (int j = i; j < charNum.length; ++j) {
                    if (charNum[j] == '0') {
                        charNum[j] = '1';
                    }else{
                        isArrayZero = true;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
//        sb.append("\"");
        for (char c : charNum) {
            sb.append(c);
        }
//        sb.append("\"");
        return sb.toString();
    }
}
