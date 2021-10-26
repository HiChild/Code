package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis1111 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res,0,0,n,"");
        return res;
    }

    private void dfs(List<String> res, int left, int right, int n,String str) {
        if (left == n && right == n) res.add(str);

        if (left < n) dfs(res, left+1, right, n, str+"(");
        if (right < left) dfs(res, left, right+1, n, str+")");
    }


}
