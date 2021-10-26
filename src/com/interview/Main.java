package com.interview;




import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr1 = new String[n];
        String[] arr2 = new String[n];
        for (int i = 0; i < n; ++i) {
            arr1[i] = scanner.next();
            arr2[i] = scanner.next();
        }
        for (int i = 0; i < n; ++i) {
            int res = getNum(arr1[i], arr2[i]);
            System.out.println(res);
        }
//        int res = getNum("00000000000000000000000000011111","00000000000000000000000000000111");
//        System.out.println(res);
    }

    private static int getNum(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] res = new char[32];
        char c = 0;
        for (int i = 31; i >= 0; --i) {
            int num1 = chars1[i] - '0';
            int num2 = chars2[i] - '0';
            int subRes = c + num1 + num2;
            switch (subRes) {
                case 0:
                    res[i] = '0';
                    c = 0;
                    break;
                case 1:
                    res[i] = '1';
                    c = 0;
                    break;
                case 2:
                    res[i] = '0';
                    c = 1;
                    break;
                case 3:
                    res[i] = '1';
                    c = 1;
                    break;
            }
        }
        String a = new String(res);
        if (a.equals("11111111111111111111111111111111")) return -Integer.MAX_VALUE;
        int signal = res[0];

        int num = 0;
        for (int i = 1; i < 32; ++i) {
            if (res[i] == '1') {
                int e = 31 - i;
                num += (int)Math.pow(2, e);
            }
        }
        if (signal == 1)  {
            num = 0 - num;
        }
        return num;
    }
}
