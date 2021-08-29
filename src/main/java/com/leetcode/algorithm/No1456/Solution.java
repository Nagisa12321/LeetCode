package com.leetcode.algorithm.No1456;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/20 18:31
 */
public class Solution {
    public int maxVowels(String s, int k) {
        char[] chs = s.toCharArray();
        int num = 0;

        for (int i = 0; i < k; i++)
            if (isAEIOU(chs[i])) num++;
        int max = num;

        int left = 0, right = k - 1;

        while (right != chs.length - 1) {
            if (isAEIOU(chs[left])) num--;
            left++;
            right++;
            if (isAEIOU(chs[right])) num++;

            max = Math.max(num, max);
        }

        return max;
    }

    public boolean isAEIOU (char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}