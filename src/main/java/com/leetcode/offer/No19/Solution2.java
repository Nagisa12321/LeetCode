package com.leetcode.offer.No19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/17 13:40
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        char[] chs = s.toCharArray();
        State state = buildState(p);
        return isMatch(chs, 0, state);
    }

    public boolean isMatch(char[] chs, int idx, State state) {
        if (idx == chs.length) return true;

        char ch = chs[idx];
        if (state.map.containsKey(ch) || state.map.containsKey('.')) {
            List<State> states = state.map.get(ch) == null ? state.map.get('.') : state.map.get(ch);
            for (State state1 : states) {
                if (isMatch(chs, idx + 1, state1)) return true;
            }
            return false;
        } else return false;
    }

    public State buildState(String p) {
        char[] chs = p.toCharArray();

        // ³õÌ¬
        State state = new State(false, 0);

        State current = state;

        int num = 1;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '*') {
                State tmp = current.parent;

                if (i == chs.length - 1) tmp.isEnd = true;

                List<State> states = tmp.map.get(chs[i - 1]);
                states.remove(states.size() - 1);
                tmp.addState(chs[i - 1], tmp);
            } else {
                State tmpstate;
                if (i == chs.length - 1) {
                    tmpstate = new State(true, num++);
                } else tmpstate = new State(false, num++);
                current.addState(chs[i], tmpstate);

                tmpstate.parent = current;
                current = tmpstate;
            }
        }
        return state;
    }

    public static class State {
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("State{");
            sb.append("num=").append(num);
            sb.append(", isEnd=").append(isEnd);
            sb.append(", map=").append(map);
            sb.append('}');
            return sb.toString();
        }

        public int num;
        public boolean isEnd;
        public HashMap<Character, List<State>> map;
        public State parent;

        public State(boolean isEnd, int num) {
            map = new HashMap<>();
            this.isEnd = isEnd;
        }

        public void addState(char ch, State state) {
            if (map.containsKey(ch)) {
                List<State> states = map.get(ch);
                states.add(state);
            } else {
                ArrayList<State> list = new ArrayList<>();
                list.add(state);
                map.put(ch, list);
            }
        }
    }
}