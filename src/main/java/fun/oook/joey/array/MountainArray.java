package fun.oook.joey.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 山脉数组的峰顶索引
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class MountainArray {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i]) {
                return --i;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int later = 0;
        while (A[later] < A[++later]) {
        }
        return --later;
    }

    public int peakIndexInMountainArray3(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if ((A[mid] > A[mid + 1]) && A[mid] > A[mid - 1]) {
                return mid;
            } else if ((A[mid] > A[mid + 1]) && A[mid] < A[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        int index = new MountainArray().peakIndexInMountainArray3(arr);
        System.out.println(index);
//        Comparator<Integer> comparator = Comparator.reverseOrder();
//        Arrays.sort(arr, comparator);

        System.out.println(String.format("10 ^ 6 = %d", 10 ^ 6));
    }
}
