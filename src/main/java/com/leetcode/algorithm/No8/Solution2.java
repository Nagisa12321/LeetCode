package com.leetcode.algorithm.No8;

/**
 * @利用有限自动机来完成
 * @详情参考 https://leetcode-cn.com/problems/string-to-integer-atoi/
 * solution/san-chong-fang-fa-zheng-chang-bian-li-you-xian-zhu/
 */
public class Solution2 {
    public int myAtoi(String s) {
        Automaton theAutomaton = new Automaton();
        int length = s.length();
        for(int i = 0;i < length;i++){
            theAutomaton.get(s.charAt(i));
        }
        return (int)(theAutomaton.sign * theAutomaton.ans);
    }
}
