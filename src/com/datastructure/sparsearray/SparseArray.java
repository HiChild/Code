package com.datastructure.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个表示棋盘的二维数组 11 *11
        //1表示黑子 2表示白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出
        System.out.println("输出原始数组");
        for (int[] arr : chessArr1) {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        //将原始数组转 -》稀疏数组
        int sum = 0;
        for (int[] arr : chessArr1) {
            for (int i : arr) {
                if (i != 0) sum++;
            }
        }
        int[][] chessArr2 = new int[sum + 1][3];
        chessArr2[0][0] = chessArr1.length;
        chessArr2[0][1] = chessArr1[0].length;
        chessArr2[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chessArr2[0][0]; i++) {
            for (int j = 0; j < chessArr2[0][1]; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    chessArr2[count][0] = i;
                    chessArr2[count][1] = j;
                    chessArr2[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int[] ints : chessArr2) {
            System.out.println(ints[0] + "\t"+ints[1]+"\t"+ints[2]);
        }

        //将稀疏数组 -》 原始数组
        int[][] chessArr3 =new int[chessArr2[0][0]][chessArr2[0][1]];
        int flag = 0;
        for (int[] ints : chessArr2) {
            flag++;
            if (flag==1) continue;
            chessArr3[ints[0]][ints[1]] = ints[2];
        }

        //原始数组
        System.out.println("输出原始数组");
        for (int[] ints : chessArr3) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
