package com.leetcode.algorithm.No860;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/10 12:03
 * @version 1.0
 ************************************************/
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {
                if (five == 0) return false;
                else {
                    ten++;
                    five--;
                }
            } else {
                if (ten != 0) {
                    if (five == 0) return false;
                    else {
                        ten--;
                        five--;
                    }
                } else {
                    if(five < 3) return false;
                    else {
                        five = five - 3;
                    }
                }
            }
        }
        return true;
    }
}
