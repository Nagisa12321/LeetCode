package com.leetcode.algorithm.No71;

public class Run {
    public static void main(String[] args){
        Solution2 theSolution = new Solution2();
//        String testString = "/home//foo/";
        String testString = "/..hidden";
//        String testString = "/a//b////c/d//././/..";
//        String testString = "/home//foo/";

        System.out.println(theSolution.simplifyPath(testString));
    }
}
