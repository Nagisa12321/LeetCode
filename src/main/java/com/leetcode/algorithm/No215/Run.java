package com.leetcode.algorithm.No215;

public class Run {
    public static void main(String[] args){
        int[] testArrays = {3,2,1,5,6,4};
//        int[] testArrays = {3,2,3,1,2,4,5,5,6};
        Solution theSolution = new Solution();
        System.out.println(theSolution.findKthLargest(testArrays,4));
    }
}
