package fun.oook.joey.array;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1: 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2]
 * <p>
 * 说明： 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 我们可以不考虑输出结果的顺序。
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (Integer num : nums1) {
            if (map1.containsKey(num))
                map1.replace(num, map1.get(num) + 1);
            else
                map1.put(num, 1);
        }

        List<Integer> intersection = new ArrayList<Integer>();
        for (Integer num : nums2) {
            if (map1.containsKey(num) && map1.get(num) > 0) {
                intersection.add(num);
                map1.replace(num, map1.get(num) - 1);
            }
        }

        int[] ret = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            ret[i] = intersection.get(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};

        Intersect intersect = new Intersect();
        int[] in = intersect.intersect(nums1, nums2);

        System.out.println(Arrays.toString(in));
    }
}