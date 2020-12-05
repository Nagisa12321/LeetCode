package com.leetcode.algorithm.No392;

/************************************************
 * @description ֱ��ɨ��t�����t�к�s��ͬԪ����sǰ��һ��
 *              ����ж�s�Ƿ����꼴��
 * @author jtchen
 * @date 2020/12/4 11:00
 * @version 1.0
 ************************************************/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int a = 0, b = 0;
        while (b != t.length())
            if (a == s.length()) return true;
            else if (s.charAt(a) == t.charAt(b++)) a++;
        return a == s.length();
    }
}
