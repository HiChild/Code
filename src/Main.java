import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        int k = sc.nextInt();
        while( k-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            reserveNum(nums, l, r);
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void reserveNum(int[] nums, int l, int r) {
        l = l - 1;
        r = r - 1;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
