package openclass.sort;

import java.util.Random;

public class TestUtils {
    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static int[] randNums(int n) {
        int[] res = new int[n];
        Random random = new Random(25);
        while (--n >= 0) {
            res[n] = random.nextInt(Integer.MAX_VALUE);
        }
        return res;
    }
}
