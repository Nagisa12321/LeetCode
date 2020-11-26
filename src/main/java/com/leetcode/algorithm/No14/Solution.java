
package com.leetcode.algorithm.No14;

/**
 * @althor Jt Chen
 * @方法 Hashmap 先遍历String数组第一个元素并存在hashMap中，之后数组与第一个做比较
 **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        } else if (strs.length == 0) {
            return "";
        } else {
            //求出最短串，并且作为theSameChar的初始值
            int theSameCharacter = strs[0].length();
            for (String str : strs) {
                theSameCharacter = Math.min(str.length(), theSameCharacter);
            }
            //遍历String[] ，以确定theSameCharacter的最终大小
            for (int i = 0; i < strs.length-1; i++) {
                int temp = 0;
                for (int j = 0; j < theSameCharacter; j++) {
                    if (strs[i].charAt(j) == strs[0].charAt(j))
                        temp++;
                    else break;
                }
                theSameCharacter = Math.min(theSameCharacter, temp);
            }
            //构造返回的String
            StringBuilder theString = new StringBuilder();
            for (int i = 0; i < theSameCharacter; i++) {
                theString.append(strs[0].charAt(i));
            }
            return theString.toString();
        }
    }
}
