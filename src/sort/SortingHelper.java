package sort;

import sort.selctsort.SelectionSort;

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

        long startTime = System.nanoTime();
        switch (sortName) {
            case "SelectionSort":
                SelectionSort.sort(arr);
            default:
        }
        long endTime = System.nanoTime();
        System.out.println();
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException("SelectionSort failed");
        }
        double time = (endTime - startTime) / 1000_000_000.0;
        System.out.printf("%s , n = %d : %f s%n", sortName, arr.length, time);
        System.out.println();
    }
}
