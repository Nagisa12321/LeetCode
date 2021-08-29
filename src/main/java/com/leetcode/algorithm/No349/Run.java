package com.leetcode.algorithm.No349;

public class Run {
    public static void main(String[] args) {
        Solution theSolution = new Solution();
        int[] test1 = {1,2,2,1};
        int[] test2 = {2,2};
        for (int i : theSolution.intersection(test1, test2))
            System.out.println(i);
    }
}
