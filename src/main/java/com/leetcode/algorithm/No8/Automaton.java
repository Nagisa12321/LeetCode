package com.leetcode.algorithm.No8;

import java.util.HashMap;
import java.util.Map;

public class Automaton {
    public final int INT_MAX = (int) (Math.pow(2, 31) - 1);
    public final int INT_MIN = (int) (-Math.pow(2, 31));
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<>() {{
        put("start", new String[]{"start", "signed", "in_num", "end"});
        put("signed", new String[]{"end", "end", "in_num", "end"});
        put("in_num", new String[]{"end", "end", "in_num", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_num".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) INT_MAX) : Math.max
                    ((long) INT_MIN, ans);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }

    }

    private int get_col(char c) {
        if (c == ' ')
            return 0;
        if (c == '+' || c == '-')
            return 1;
        if (Character.isDigit(c))
            return 2;
        else return 3;
    }
}
