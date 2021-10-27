package sort.selctsort;

import linearsearch.ArrayGenerator;
import sort.SortingHelper;

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
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int j, int minIndex) {
        E temp = arr[j];
        arr[j] = arr[minIndex];
        arr[minIndex] = temp;
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
