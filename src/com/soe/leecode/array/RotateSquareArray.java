package com.soe.leecode.array;

public class RotateSquareArray {
    static int[][] testArray = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
    };

    public static void main(String[] args) {
        printArray(testArray);
    }

    public static void printArray(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }


    //逆时针旋转 90 度
    //列 = 行
    //行 = n - 1 - 列(j);  n表示总行数
    public static void rotate90(int[][] nums) {

    }
    public static void rotate180(int[][] nums) {

    }
    public static void rotate270(int[][] nums) {

    }

}
