package com.leetcode.primary.No5.No2;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/1 17:10
 * @version 1.0
 ************************************************/
public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}