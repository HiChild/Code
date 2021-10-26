package com.test;

public class Solution2 {

    public static void main(String[] args) {
//        long oneCount = getOneCount("1212121251");
//        String res = help(10, 10);
//        System.out.println(res);
//        long m = minM(10, 10);
//        System.out.println(m);
        int i = NumBetweenKAndN(10, 10);
        System.out.println(i);

    }

    public static int NumBetweenKAndN(int n, int k) {
        if (n < k)
            return 0;
        if (n >= k && n <= 9)
            return 1;

        int i = 1;
        int res = 0;
        while (i < n) {
            int high = n / i;	// 最高位
            res += high * i / 10;

            int nn = n % i * 10 / i;	// 除去最高位的余数
            if (nn == k)	// 余数的最高位等于k
                res += n % i - nn * i / 10;
            if (nn > k)		// 余数的最高位大于k
                res += (i / 10);

            i *= 10;	// 省去pow运算
        }
        return res;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @param k int整型
     * @return long长整型
     */
    public static long minM (int n, int k) {
        int i = 1;
        int step = 0;
        int count = 1;
        int linjie = k - 1;
        int high = 1;
        while (true) {
            if (count >= n) {
                break;
            }
            if (high == linjie) {
                step++;
            }
            count = step * 9 + count;
        }
        return high;
    }

    public static String help (int num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int yu = num % k;
            num = num / k;
            sb.append(yu);

        }
        return sb.toString();
    }

    public static long getOneCount(String num) {
        long count = 0;
        for (char c : num.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
