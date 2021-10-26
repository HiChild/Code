package openclass.sort;
import static openclass.sort.TestUtils.*;
public class QuickSort {

    public static void main(String[] args) {
        int[] test = randNums(100);
        sort(test);
        print(test);
    }

    public static void sort (int[] arr) {
        quickSort(arr,0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
//        swap(arr, begin, begin+(int)((end-begin+1)*Math.random()) ); //随机化
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int[] arr, int begin, int end) {
        int pivot = end, counter = begin; //counter is the number of times of switch
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[i]; arr[i] = arr[counter]; arr[counter] = temp;
                counter++;
            }
        }
        int temp = arr[pivot]; arr[pivot] = arr[counter]; arr[counter] = temp;
        return counter;
    }


    public static void swap(int arr[],int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
