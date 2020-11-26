package com.leetcode.primary.No2.No8;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/11/24 11:13
 * @version 1.0
 ************************************************/
public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 0;i < n - 1;++i){
            str = nextStr(str);
        }
        return str;
    }

    public String nextStr(String str) {
        char ch = str.charAt(0);
        StringBuilder builder = new StringBuilder();
        int num = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (ch == str.charAt(i)) {
                ++num;
            } else {
                builder.append(num).append(ch);
                ch = str.charAt(i--);
                num = 0;
            }
        }
        builder.append(num).append(ch);
        return builder.toString();
    }

}
