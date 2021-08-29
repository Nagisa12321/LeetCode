package com.leetcode.algorithm.No228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/10 15:36
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int left = nums[0];
        int right = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == right + 1) right++;
            else {
                if (left == right) list.add(String.valueOf(left));
                else list.add(left + "->" + right);
                left = nums[i];
                right = nums[i];
            }
        }
        if (left == right) list.add(String.valueOf(left));
        else list.add(left + "->" + right);
        return list;
    }
}
