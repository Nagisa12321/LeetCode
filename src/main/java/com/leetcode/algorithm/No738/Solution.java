package com.leetcode.algorithm.No738;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/15 13:09
 * @version 1.0
 ************************************************/
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        int[] nums = new int[10];
        int len = 0;//位数
        while (N != 0) {
            nums[len++] = N % 10;
            N /= 10;
        }
        int a = 11;//不符合要求的第一个下标
        int tmp = nums[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (tmp > nums[i]) {
                a = i;
                break;
            }
            tmp = nums[i];
        }
        if (a == 11) return N;
        while (nums[a] < nums[a + 1] && a != len - 1) {
            a++;
            nums[a]--;
        }
        int ret = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < a)
                ret = ret * 10 + 9;
            else ret = ret * 10 + nums[i];
        }
        return ret;
    }
}
