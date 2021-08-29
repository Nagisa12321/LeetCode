package com.leetcode.offer.No38;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/13 22:24
 */
public class Solution2 {

    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        traverse(0, list, s.toCharArray());

        return list.toArray(String[]::new);
    }

    public void traverse(int idx, Set<String> res, char[] chs) {
        if (idx == chs.length - 1) {
            res.add(String.copyValueOf(chs));
            return;
        }

        for (int i = idx; i < chs.length; i++) {
            swap(idx, i, chs);
            traverse(idx + 1, res, chs);
            swap(idx, i, chs);
        }
    }

    public void swap(int i, int j, char[] chs) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
