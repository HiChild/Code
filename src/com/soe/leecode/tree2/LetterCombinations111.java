package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations111 {
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
        backtrack(res, digits, new StringBuffer(), map, 0);
        return res;
    }

    private void backtrack(List<String> res, String digits, StringBuffer stringBuffer, Map<Character, String> map, int level) {
        if (level == digits.length()) {
            res.add(new String(stringBuffer));
            return;
        }
        char digit = digits.charAt(level);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            stringBuffer.append(letters.charAt(i));
            backtrack(res, digits, stringBuffer, map, level + 1);
            stringBuffer.deleteCharAt(level);
        }

    }


    public static void main(String[] args) {
        LetterCombinations111 letterCombinations = new LetterCombinations111();
        List<String> strings = letterCombinations.letterCombinations("23");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
