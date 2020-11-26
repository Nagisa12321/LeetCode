package com.leetcode.algorithm.No5;

/**
 * 采用中间向两边扩散方式，只需一次遍历
 * String操作
 * 擦，如果是偶数回文数的话该方法无法计算。。。%@……#%！@#
 */
public class Solution {
    public String longestPalindrome(String s) {
        //最长扩展长度,以及对应下标
        int MaxHand = 0, MaxIndex = 0;
        //为传进来的串前后增加两个不同的符号，以便遍历
        String tempString = "#" + s + "$";
        //中间下标
        int index = 1;
        //遍历一次数组
        while (index != tempString.length() - 1) {
            //一个暂时的扩展长度
            int hand = 0;
            //对于每个index，累加hand长度，直到不同/超出范围为止
            while (index - hand >= 0 && index + hand <= tempString.length() - 1) {
                //如果相同的话，继续扩展
                if (tempString.charAt(index - hand) == tempString.charAt(index + hand)) {
                    //如果当前hand大于MaxHand，则更新MaxHand和其下标
                    if (hand > MaxHand) {
                        MaxHand = hand;
                        MaxIndex = index;
                    }
                    //继续扩展
                    hand++;
                }
                //如果不同则跳出循环，继续累加index
                else break;
            }
            ++index;
        }
        //返回切割之后的String
        return tempString.substring(MaxIndex - MaxHand, MaxIndex + MaxHand + 1);
    }
}
