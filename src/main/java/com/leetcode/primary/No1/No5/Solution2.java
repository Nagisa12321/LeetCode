package com.leetcode.primary.No1.No5;

/**
 * @神算法 ： 异或
 */
public class Solution2 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i : nums)
            ans ^= i;
        return ans;
    }
}
