package openclass.sort;
import java.util.Arrays;

import static openclass.sort.TestUtils.*;


public  class Merge {
    public static void main(String[] args) {
        int[] res = randNums(5);
        mergeSort(res);
        print(res);
    }

    /**
     * nlogn
     * @param res
     */
    public static void mergeSort(int[] res) {
        if (res.length == 1) return ;
        int begin = 0;
        int length = res.length;
        int[] left = Arrays.copyOfRange(res,begin,length/2);
        int[] right = Arrays.copyOfRange(res,length/2,length);
        mergeSort(left);
        mergeSort((right));

        int index = begin; // if it doesn't work try "int index = 0;"
        int lCur = index;
        int rCur = index;
        while(index < length) {
            if(rCur >= right.length) {
                res[index++] = left[lCur++];
            }else if(lCur >= left.length) {
                res[index++] = right[rCur++];
            }else {
                res[index++] = right[rCur] < left[lCur] ? right[rCur++] : left[lCur++];
            }
        }
    }
}
