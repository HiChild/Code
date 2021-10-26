package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis1111 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generator(0, 0, n, "");
        return res;
    }

    private void generator(int left, int right, int n, String s) {
        if (left == n && right == n) res.add(s);
        if (left < n) generator(left + 1, right, n, s + "(");
        if (left > right) generator(left, right + 1, n, s + ")");
    }


    public static void main(String[] args) {
        GenerateParenthesis1111 generateParenthesis1 = new GenerateParenthesis1111();
        generateParenthesis1.generateParenthesis(3);
    }
}
