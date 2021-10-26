package com.soe.leecode.math;

public class Calculate {

    public static void main(String[] args) {
        test();
    }

    public static void  test() {
        Calculate calculate = new Calculate();
        calculate.calculate("3+2*2");
    }

    public int calculate(String s) {
        int i = 0;
        return parseExpr(s, i);
    }

    public int parseExpr(String s, int i) {
        char op = '+';
        long left = 0, right = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                long n = parseNum(s, i);
                switch (op) {
                    case '+' : left += right; right = n; break;
                    case '-' : left += right; right = -n; break;
                    case '*' : right *= n; break;
                    case '/' : right /= n; break;
                }

                op = s.charAt(i);

            }
            i++;
        }
        return (int)(left + right);
    }

    long parseNum(String s, int i) {
        long n = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            n = n * 10 + (s.charAt(i++) - '0');
        }
        return n;
    }
}
