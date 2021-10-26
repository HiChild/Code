package openclass.sort;
import static openclass.sort.TestUtils.*;
public class TestQuickAndMerge {
    public static void main(String[] args) {
        int[] res = randNums(100000000);
        long start1 = System.currentTimeMillis();
        QuickSort.sort(res);
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        Merge.mergeSort(res);
        long end2 = System.currentTimeMillis();
        System.out.println("QuickSort runtime is : --->"+ (end1 - start1));
        System.out.println("mergeSort runtime is : --->"+ (end2 - start2));
    }
}
