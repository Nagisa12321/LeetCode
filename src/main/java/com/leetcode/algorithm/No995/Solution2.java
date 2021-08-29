package com.leetcode.algorithm.No995;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/23 11:33
 */
public class Solution2 {
    /*
        ��ʱ�������:
        �� N ��ʾ���� A �ĳ��ȡ���ֱ��ģ���������̣����ӶȽ����� O(NK) �ġ�����Ż��أ�
        ���ǲ�ȥ��ת���֣�����ͳ��ÿ��������Ҫ��ת�Ĵ���������һ�η�ת�������൱�ڰ����������������ֵķ�ת������ 1��
     */
    public int minKBitFlips(int[] A, int K) {
        int len = A.length;
        int[] reserve = new int[len];
        int times = 0;
        for (int i = 0; i <= len - K; i++) {
            if (A[i] == 0) {
                int first_zero = reverse(A, i, K);
                times++;

            }
        }

        for (int i = len - K + 1; i < len; i++) {
            if (A[i] == 0) return -1;
        }

        return times;
    }

    public int reverse(int[] A, int left, int K) {

        return left;
    }
}
