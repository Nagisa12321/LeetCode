package com.leetcode.algorithm.No316;

import java.util.HashSet;
import java.util.Stack;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/20 12:52
 * @version 1.0
 ************************************************/
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++)
            map[s.charAt(i) - 'a']++;
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                set.add(s.charAt(i));
            } else {
                while (!stack.isEmpty() && stack.peek() > s.charAt(i)) {
                    if (map[stack.peek() - 'a'] > 0 && !set.contains(s.charAt(i))) {
                        set.remove(stack.peek());
                        stack.pop();
                    } else break;
                }
                if (set.add(s.charAt(i)))
                    stack.push(s.charAt(i));
            }
            map[s.charAt(i) - 'a']--;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}