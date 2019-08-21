package fun.oook.joey.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer>map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    map.put(nums1[i],nums1[i]);
                }
            }
        }
        int[] result = new int[map.size()];
        int i = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            result[i++] = iterator.next();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {0, 3, 0};
        int[] a2 = {0, 1, 3};

        int[] re = new Intersection().intersection(a1, a2);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re[i]);
        }
    }
}
