package sort.selectiontsort;

import linearsearch.ArrayGenerator;
import sort.SortingHelper;

import java.util.ArrayList;
import java.util.Stack;

public class SelectionSort {


    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //选择arr[i...n)中最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            SortingHelper.swap(arr, i, minIndex);
        }
    }


    public static void main(String[] args) {
//        Student[] students = {
//                new Student("Alice",98),
//                new Student("Bobo",100),
//                new Student("Charles",66)
//        };
//        SelectionSort.sort(students);
//        for (Student student : students) {
//            System.out.println("student = " + student);
//        }
//        System.out.println();

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }
    }
}
