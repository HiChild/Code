package openclass.sort;

import static openclass.sort.TestUtils.*;

public class Insertion {

    public static void main(String[] args) {

        int[] nums = randNums(5);
        insertionSort(nums);
        print(nums);
    }

    /**
     * 插入排序 每一次将数组中的第i个元素插入到**已经有序**的前i-1个元素中,挪动被插入点以后的数据保证 0..i 已然有序
     * n^2
     * @param nums
     * @return
     *
     */
    public static void insertionSort(int[] nums) {
        if(nums.length == 0) return ;
        for (int i = 1; i <nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //nums[i]  nums[j]
                if(nums[i] < nums[j]) {
                    int t = nums[i];
                    int index = i;
//                    int n = i - j;
//                    while (n-- > 0) {
//                        nums[index] = nums[index - 1];
//                        index--;
//                    }
                    while (index > j) {
                        nums[index] = nums[index - 1];
                        index--;
                    }
                    nums[j] = t;
                }
            }
        }
    }

}
