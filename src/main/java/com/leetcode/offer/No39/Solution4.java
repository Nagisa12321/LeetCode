package com.leetcode.offer.No39;

import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 10:06
 */
public class Solution4 {
    public int majorityElement(int[] nums) {

        Random random = new Random();
        while (true) {
            /*
            返回从此随机数生成器的序列中提取的伪随机，
            均匀分布的值在0（包括）和指定值（不包括）之间的int值。
            nextInt的一般合同是伪随机生成并返回指定范围内的一个int值。
            所有bound可能的int值以（近似）相等的概率产生。
             */
            int test = random.nextInt(nums.length);
            int times = 0;
            for (int num : nums) {
                if (num == nums[test]) times++;
                if (times >= nums.length / 2) return nums[test];
            }
        }
    }
}
