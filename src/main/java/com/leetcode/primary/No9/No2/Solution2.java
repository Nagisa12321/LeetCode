package com.leetcode.primary.No9.No2;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/14 12:36
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        xor = (xor & 0x55555555) + ((xor >> 1) & 0x55555555);//�ϲ�2λ��
        xor = (xor & 0x33333333) + ((xor >> 2) & 0x33333333);//�ϲ�4λ��
        xor = (xor & 0x0f0f0f0f) + ((xor >> 4) & 0x0f0f0f0f);//�ϲ�8λ��
        xor = (xor & 0x00ff00ff) + ((xor >> 8) & 0x00ff00ff);//�ϲ�16λ��
        xor = (xor & 0x0000ffff) + ((xor >> 16) & 0x0000ffff);//�ϲ�32λ��
        return xor;
    }
}
