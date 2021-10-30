package sort.mergesort;

import linearsearch.ArrayGenerator;
import sort.SortingHelper;
import sort.insertionsort.InsertionSort;

import java.util.Arrays;


public class MergeSort {

    private MergeSort() {
    }

    /**
     * 自顶向下
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) return;
//        if (r - l <= 15) {
//            //小规模的数据使用 O(n) 插入排序 优化
//            InsertionSort.sort(arr, l, r);
//            return;
//        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    /**
     * merge arr[l,mid) arr[mid+1,r]
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) < 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    /**
     * 自底向上
     */
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        //遍历合并数组的长度sz,从1开始
        for (int sz = 1; sz < n; sz += sz) {
            //计算合并的位子
            // arr[i,i+sz)  arr[i+sz,Math.min[i+sz+sz,n-1)
            for (int i = 0; i + sz < n; i = i + sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
            }
        }

    }

    /**
     * 自底向上(使用了插入排序优化)
     */
    public static <E extends Comparable<E>> void sortBUWithInsertS(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        //对arr[i,i+16)进行插入排序，i+=16;
        for (int i = 0; i < n; i += 16) {
            InsertionSort.sort(arr, i, Math.min(i + 15, n - 1));
        }
        //遍历合并数组的长度sz,从1开始
        for (int sz = 16; sz < n; sz += sz) {
            //计算合并的位子
            // arr[i,i+sz)  arr[i+sz,Math.min[i+sz+sz,n-1)
            for (int i = 0; i + sz < n; i = i + sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
            }
        }

    }


    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(1000000, 1000000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSortBu", arr1);
        SortingHelper.sortTest("sortBUWithInsertS", arr2);
    }
}
