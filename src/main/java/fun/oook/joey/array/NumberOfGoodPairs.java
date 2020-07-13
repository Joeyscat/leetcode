package fun.oook.joey.array;

/*
给你一个整数数组 nums 。
如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
返回好数对的数目。

示例 1：
输入：nums = [1,2,3,1,1,3]
输出：4
解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
示例 2：
输入：nums = [1,1,1,1]
输出：6
解释：数组中的每组数字都是好数对
示例 3：
输入：nums = [1,2,3]
输出：0

提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
 */

/**
 * @author zhouyu
 */
public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int pairCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    pairCount++;
                }
            }
        }

        return pairCount;
    }

    public int numIdenticalPairs1(int[] nums) {
        int[] numCounts = new int[101];
        for (int num : nums) {
            numCounts[num]++;
        }

        int pairCount = 0;
        for (int value : numCounts) {
            if (value >= 2) {
                pairCount += ((value * (value - 1)) >> 1);
            }
        }

        return pairCount;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 1, 1, 3};
        int i = new NumberOfGoodPairs().numIdenticalPairs1(arr);

        assert i == 4;
    }
}
