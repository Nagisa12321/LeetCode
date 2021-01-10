package com.leetcode.algorithm.No131;

import java.util.ArrayList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/19 20:22
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        track(list, tmp, s);
        return list;
    }

    public void track(List<List<String>> list, List<String> tmp, String s) {
        if (s.equals("")) {
            list.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String tmp1 = s.substring(0, i);
            if (isReserve(tmp1)) {
                tmp.add(tmp1);
                track(list, tmp, s.substring(i));
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isReserve(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        return true;
    }
}