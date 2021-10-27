package sort.insertionsort;

import linearsearch.ArrayGenerator;
import sort.SortingHelper;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {
    }


    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                SortingHelper.swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 使用平移替代 交换 ，交换是三步。
     */
    public static <E extends Comparable<E>> void sortPro(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            int j = i;
            for (; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10, 100, 1000, 10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("InsertionSortPro", arr2);
        }
    }
}
