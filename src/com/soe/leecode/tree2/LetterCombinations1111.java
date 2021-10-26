package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations1111 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> map = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(res, digits, new StringBuffer(), 0, map);
        return res;
    }

    private void backtrack(List<String> res, String digits, StringBuffer stringBuffer, int level, Map<Character, String> map) {
        if (level == digits.length()) {
            res.add(new String(stringBuffer));
            return;
        }
        char digit = digits.charAt(level);
        String str = map.get(digit);
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(str.charAt(i));
            backtrack(res, digits, stringBuffer, level + 1, map);
            stringBuffer.deleteCharAt(level);
        }
    }


    public static void main(String[] args) {
        LetterCombinations1111 letterCombinations = new LetterCombinations1111();
        List<String> strings = letterCombinations.letterCombinations("23");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
