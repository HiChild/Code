package com.datastructure.sparsearray;

import java.io.*;

public class StoreSparseArray {
    public static void main(String[] args) {
        //创建一个表示棋盘的二维数组 11 *11
        //1表示黑子 2表示白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

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
        int count = 0; //非零元素的个数
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

        //将稀疏矩阵写入文件
        try (FileOutputStream fs =  new FileOutputStream("D:/workspace/Code/src/com/datastructure/sparsearray/map.data");
             BufferedOutputStream bos = new BufferedOutputStream(fs);){
            int flag = 0;
            for (int[] ints : chessArr2) {
                flag++;
                for (int anInt : ints) {
                    bos.write((String.valueOf(anInt) + "\t").getBytes());
                }
                if (flag == chessArr2.length) break;
                bos.write("\n".getBytes());
            }
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常发生了");
        }


        //从文件中读出稀疏矩阵
        StringBuilder sb =new StringBuilder();
        try(FileReader fr = new FileReader("D:/workspace/Code/src/com/datastructure/sparsearray/map.data");
                BufferedReader br = new BufferedReader(fr);){
            String line = br.readLine();
            while (line!=null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String arr = new String(sb);
        String[] s = arr.split("\n");
        int[][] chessArr4 = new int[3][3];
        int i = 0;
        for (String s1 : s) {
            String[] split = s1.split("\t");
            int index = 0;
            for (int j = 0; j < 3; j++) {
                chessArr4[i][j] = Integer.parseInt(split[index++]);
            }
            i++;

        }

        for (int[] ints : chessArr4) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }
}
