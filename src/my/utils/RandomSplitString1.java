package my.utils;

import java.util.Set;

public class RandomSplitString1 {
    /**
     * 对s1进行一次划分，生成使得划分后的两个子字符串不为空的所有结果
     * @param s1
     */
    private static void splitString(String s1) {
        if (s1.length() == 1) return; //传入字符串必须大于等于2
        //对字符串进行划分 很有用
        int start = 0, end = s1.length(); //包头不包尾 划分字符串为 [start,mid),[mid,end) end为字符串长度
        //mid必须保证两端元素非空，只能取start + 1 to end - 1之间的值
        for (int mid = start + 1; mid < end ; ++mid) {
            String subLeft = s1.substring(start,mid);
            String subRight = s1.substring(mid,end);
            System.out.println("subL  " + subLeft);
            System.out.println("subR  " + subRight);
        }
    }
}
