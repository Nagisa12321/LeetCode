package com.leetcode.intermediate.No1.No1;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2020/12/31 11:29
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int idx = BinarySearch(nums, -nums[i] - nums[j], j + 1);
                if (idx > j) {
                    var tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[idx]);
                    if (set.add(tmp)) list.add(tmp);
                }
            }
        }
        return list;
    }

    public int BinarySearch(int[] nums, int key, int lo) {
        /*int lo = 0;*/
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == key) return mid;
            else if (key < nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
}