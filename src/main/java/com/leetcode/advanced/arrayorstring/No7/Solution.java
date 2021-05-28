package com.leetcode.advanced.arrayorstring.No7;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/24 12:58
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int max = 1;

        // id[] 用于索引节点 sz[] 用于统计出现次数
        int[] id = new int[len];
        int[] sz = new int[len];

        for (int i = 0; i < len; i++) {
            // 存入map之中
            map.put(nums[i], i);

            // 初始化id[], sz[]
            id[i] = i;
            sz[i] = 1;
        }

        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) != i) continue;

            int idx = -1;
            // 是否有相邻数字出现?
            if (map.containsKey(nums[i] - 1))
                idx = map.get(nums[i] - 1);
            /*else if (map.containsKey(nums[i] + 1))
                idx = map.get(nums[i] + 1);*/

            // 如果存在相应比nums[i] 大1或者小1的数字
            if (idx != -1) {

                // 重新定义索引
                id[i] = idx;

                // 计算大小
                int tmp = idx;
                while (id[tmp] != tmp)
                    tmp = id[tmp];
                sz[tmp] += sz[i];

                // 记录最大值
                max = Math.max(max, sz[tmp]);
            }
        }

        return max;
    }
}