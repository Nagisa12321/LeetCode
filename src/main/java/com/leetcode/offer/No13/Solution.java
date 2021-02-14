package com.leetcode.offer.No13;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/11 10:12
 */
public class Solution {
    public int movingCount(int m, int n, int k) {
        return movingCount(m, n, 0, 0, k, new HashSet<>());
    }

    // ��(x, y) �����߼���
    public int movingCount(int m, int n, int x, int y, int k, HashSet<Integer> set) {
        // xyԽ��
        if (x == m || y == n) return 0;
            // > k
        else if (bitSum(x, y) > k) return 0;

        // ����set�з�ֹ�ظ�
        set.add(x * 173 + y);


        return 1 +
                (set.contains((x + 1) * 173 + y) ? 0 : movingCount(m, n, x + 1, y, k, set)) +
                (set.contains(x * 173 + y + 1) ? 0 : movingCount(m, n, x, y + 1, k, set));
    }

    public int bitSum(int x, int y) {
        int sum = 0;

        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }

        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }

        return sum;
    }
}