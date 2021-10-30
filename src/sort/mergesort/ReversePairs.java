package sort.mergesort;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) return 0;
        int count = 0;
        int mid = l + (r - l) / 2;
        count += mergeSort(arr, l, mid, temp);
        count += mergeSort(arr, mid + 1, r, temp);
        /**
         * 比较时不要使用两数相减，因为会int越界(-2147483647)
         */
        if (arr[mid] > arr[mid + 1]) {
            count += merge(arr, l, mid, r, temp);
        }
        return count;
    }

    /**
     * merge arr[l,mid) arr[mid+1,r]
     */
    private int merge(int[] arr, int l, int mid, int r, int[] temp) {
        int count = 0;
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                count = count + (mid - i + 1);
                arr[k] = temp[j];
                j++;
            }
        }
        System.out.println("count: " + count);

        return count;
    }
}
