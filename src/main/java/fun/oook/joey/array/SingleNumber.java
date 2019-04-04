package fun.oook.joey.array;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。 找出那个只出现了一次的元素。 你的算法应该具有线性时间复杂度。
 * 你可以不使用额外空间来实现吗？ 示例 1: 输入: [2,2,1] 输出: 1
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[length - 1] != nums[length - 2])
            return nums[length - 1];
        for (int i = 1; i < length - 1; i++) {
            if (nums[i - 1] != nums[i] && nums[i + 1] != nums[i])
                return nums[i];
        }
        return 0;
    }

    public int singleNumber_2(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};

        SingleNumber singleNumber = new SingleNumber();
        int num = singleNumber.singleNumber_2(nums);

        System.out.println(num);
    }
}