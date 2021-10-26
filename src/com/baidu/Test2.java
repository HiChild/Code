package com.baidu;

import java.util.*;

/**
 * 数字字符串转化成IP地址
 * 限定语言：Kotlin、Typescript、Python、C++、Groovy、Rust、Java、Go、Scala、Javascript、Ruby、Swift、Php、Python 3
 * 现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
 * 例如：
 * 给出的字符串为"25525522135",
 * 返回["255.255.22.135", "255.255.221.35"]. (顺序没有关系)
 *
 * 数据范围：字符串长度
 * 要求：空间复杂度 ,时间复杂度
 *
 * 注意：ip地址是由四段数字组成的数字序列，格式如 "x.x.x.x"，其中 x 的范围应当是 [0,255]。
 *
 * "25525522135"
 * ["255.255.22.135","255.255.221.35"]
 *
 * "1111"
 * ["1.1.1.1"]
 *
 *
 */

public class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.restoreIpAddresses("25525522135");
    }


    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        Deque<String> path = new ArrayDeque<>(4);
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12) {
            return res;
        }
        dsf(s, len, 0, 0, path, res);
        return res;
    }

    private void dsf(String s, int len, int times, int begin, Deque<String> path, List<String> res) {
        if (len == begin ) {
            if (times == 4) {
                res.add(String.join(".", path));
            }
            return;
        }
        if (len - begin < (4 - times) || len - begin > 3 * (4 - times)) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            if (begin + i >= len) break;
            int num = judgeIfOk(s, begin, begin + i);
            if (num != -1) {
                path.addLast(String.valueOf(num));
                dsf(s, len, times + 1, begin + i + 1, path, res);
                path.removeLast();
            }
        }
    }

    private int judgeIfOk(String s, int l, int r) {
        int len =  r - l + 1;
        //不能以0开头
        if (len > 1 && s.charAt(l) == '0') {
            return -1;
        }
        int res = 0;
        for (int i = l; i <= r; ++i) {
            res = res * 10 + s.charAt(i) - '0';
        }
        if (res > 255) return -1;
        return res;
    }

}
