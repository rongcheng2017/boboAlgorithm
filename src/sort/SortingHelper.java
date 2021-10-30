package sort;

import sort.insertionsort.InsertionSort;
import sort.mergesort.MergeSort;
import sort.selectiontsort.SelectionSort;

import java.util.Stack;


public class SortingHelper {
    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }


    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        int preSum = 0;
        for (E e : arr) {
            preSum += e.hashCode();
        }

        long startTime = System.nanoTime();
        switch (sortName) {
            case "SelectionSort":
                SelectionSort.sort(arr);
            case "InsertionSort":
                InsertionSort.sort(arr);
            case "InsertionSortPro":
                InsertionSort.sortPro(arr);
            case "MergeSort":
                MergeSort.sort(arr);
            default:
        }
        long endTime = System.nanoTime();
        System.out.println();

        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("SelectionSort failed");
        }
        int sum = 0;
        for (E e : arr) {
            sum += e.hashCode();
        }
        if (sum != preSum) {
            throw new RuntimeException("arr has changed failed");
        }

        double time = (endTime - startTime) / 1000_000_000.0;
        System.out.printf("%s , n = %d : %f s%n", sortName, arr.length, time);
        System.out.println();
    }

    public static <E> void swap(E[] arr, int j, int minIndex) {
        E temp = arr[j];
        arr[j] = arr[minIndex];
        arr[minIndex] = temp;
    }

}
