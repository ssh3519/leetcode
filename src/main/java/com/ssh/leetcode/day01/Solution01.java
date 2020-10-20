package com.ssh.leetcode.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description 两数之和
 * @author: ssh
 * @Date: 2020/10/20 14:08
 */
public class Solution01 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = twoSum2(nums, 9);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 暴力枚举
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
