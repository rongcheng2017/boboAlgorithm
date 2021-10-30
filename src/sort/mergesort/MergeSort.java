package sort.mergesort;

import linearsearch.ArrayGenerator;
import sort.SortingHelper;

import java.util.Arrays;


public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        mergeSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * merge arr[l,mid) arr[mid+1,r]
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(10, 10);
        SortingHelper.sortTest("MergeSort", arr);
    }
}
