package com.leetcode.hashmap.summary.No2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 10:34
 */

// 超出时间限制
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = D.length;
        var queue = new LinkedList<Integer>();

        // 计算三个数(三数之和为多少可满足需求)
        for (int k : D) queue.offer(-k);
        // 计算两数之和多少可满足需求
        for (int i = 0; i < len; i++) {
            int tmp = queue.poll();
            for (int j = 0; j < len; j++) {
                queue.offer(tmp - C[j]);
            }
        }
        // 计算一个数之和多少可以满足需求
        for (int i = 0; i < len * len; i++) {
            int tmp = queue.poll();
            for (int j = 0; j < len; j++)
                queue.offer(tmp - B[j]);
        }

        int num = 0;

        Integer[] integers = queue.toArray(Integer[]::new);
        Arrays.sort(integers);
        for (int i = 0; i < len; i++) {
            int tmp = A[i];

            int lo = 0, hi = integers.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (integers[mid] == tmp && (mid == 0 || integers[mid - 1] < tmp)) {
                    int tmp1= mid;
                    while (tmp1 < integers.length && integers[tmp1].equals(integers[mid])) {
                        num++;
                        tmp1++;
                    }
                    break;
                } else if (integers[mid] < tmp) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return num;
    }
}