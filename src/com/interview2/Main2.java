package com.interview2;

import java.util.*;

public class Main2 {

//    static char[][] test1 = {
//            {'.','.','*','*','.','.'},
//            {'.','.','*','*','.','.'},
//            {'*','*','*','*','*','*'},
//            {'.','.','*','*','.','.'},
//            {'.','.','*','*','.','.'}
//    };

    static char[][] test1 = {
//            {'*','*','*','*'},
//            {'*','*','*','*',},
//            {'*','*','*','*'},

            {'.','.','.','.',},
            {'.','.','.','.',},
            {'.','.','.','.',},
            {'.','.','.','.',},
    };

    static StringBuilder sb = new StringBuilder();
    static int count = Integer.MAX_VALUE;
    static Set<String> set= new HashSet<>();
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        help(target);
        for (String s : set) {
            count = Math.min(count, s.length());
        }
        for (String s : set) {
            if (s.length() == count) {
                res.add(s);
            }
        }
        if (res.size() == 1) System.out.println(res.get(0));
    }

    private static void help(String sTarget) {
        char[] target = sTarget.toCharArray();
        int n = target.length;
        if (n == 1)  {
            return;
        }
        for (int i = 1; i < n; ++i) {
            if (target[i] == 'b' && target[i - 1] == 'a') {
                String ans1 = getAns(target, i);
                String ans2 = getAns(target, i - 1);
                set.add(ans1);
                set.add(ans2);
                help(ans1);
                help(ans2);
            }
        }
    }

    private static String getAns(char[] target, int idx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length; ++i) {
            if (i == idx) continue;
            sb.append(target[i]);
        }
        return sb.toString();
    }


}
