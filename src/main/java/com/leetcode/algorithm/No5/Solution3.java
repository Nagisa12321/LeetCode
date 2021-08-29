package com.leetcode.algorithm.No5;

/**
 * 采用双指针 (该方法不可取，还是要两重遍历)
 */
public class Solution3 {
    /**
     *
     * @param theString
     * @return 是否为回文串
     */
    public boolean isRound(String theString) {
        StringBuilder theBuffer = new StringBuilder(theString);
        return theBuffer.toString().equals(theBuffer.reverse().toString());
    }

    public String longestPalindrome(String s) {
        //双指针
        int left = 0, right = 0;
        //串长度
        int MaxLength = 0;
        //要返回的串
        String newString = null;
        //如果right指针没到右边的话，继续循环
        while (right != s.length()) {
            //如果是回文子串，且长度更长，则更新newStr
            if (isRound(s.substring(left, right)) && s.substring(left, right).length() > MaxLength) {
                MaxLength = s.substring(left, right).length();
                newString = s.substring(left,right);
            }
            //如果不是回文子串，则左指针+1
            if(!isRound(s.substring(left,right)))
                left++;
            right++;
        }
        return newString;
    }
}
