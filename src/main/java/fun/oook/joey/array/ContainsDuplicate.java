/*
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。
 * 如果数组中每个元素都不相同，则返回 false。
 */
package fun.oook.joey.array;

import java.util.Arrays;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        ContainsDuplicate judge = new ContainsDuplicate();
        boolean containsDuplicate = judge.containsDuplicate(nums);
        System.out.println(containsDuplicate);
    }
}