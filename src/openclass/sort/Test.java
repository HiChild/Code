package openclass.sort;
import static openclass.sort.TestUtils.*;

public class Test {

    /*
    simple is 100000
        insertionSort runtime is : --->2703
        mergeSort runtime is : --->32

        insertionSort runtime is : --->2703
        mergeSort runtime is : --->31
    simple is 1000000
        insertionSort runtime is : --->421103
        mergeSort runtime is : --->109

        insertionSort runtime is : --->575002
        mergeSort runtime is : --->110

     */
    public static void main(String[] args) {
        int[] res = randNums(1000000);
        long start1 = System.currentTimeMillis();
        Insertion.insertionSort(res);
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        Merge.mergeSort(res);
        long end2 = System.currentTimeMillis();
        System.out.println("insertionSort runtime is : --->"+ (end1 - start1));
        System.out.println("mergeSort runtime is : --->"+ (end2 - start2));
    }
}


