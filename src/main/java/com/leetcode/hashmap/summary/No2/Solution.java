package com.leetcode.hashmap.summary.No2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 10:34
 */

// ����ʱ������
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = D.length;
        var queue = new LinkedList<Integer>();

        // ����������(����֮��Ϊ���ٿ���������)
        for (int k : D) queue.offer(-k);
        // ��������֮�Ͷ��ٿ���������
        for (int i = 0; i < len; i++) {
            int tmp = queue.poll();
            for (int j = 0; j < len; j++) {
                queue.offer(tmp - C[j]);
            }
        }
        // ����һ����֮�Ͷ��ٿ�����������
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