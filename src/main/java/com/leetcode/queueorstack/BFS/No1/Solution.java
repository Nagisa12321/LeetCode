package com.leetcode.queueorstack.BFS.No1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/2 11:29
 */
public class Solution {
	public int openLock(String[] deadends, String target) {
		Queue<String> queue = new LinkedList<>();
		HashSet<String> used = new HashSet<>();
		HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
		if (dead.contains("0000")) return -1;
		int step = 0;

		used.add("0000");
		queue.offer("0000");

		while (!queue.isEmpty()) {
			step++;

			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(target)) return step - 1;

				char[] chs = cur.toCharArray();
				char ch0 = chs[0];
				char ch1 = chs[1];
				char ch2 = chs[2];
				char ch3 = chs[3];

				String str0 = new String(new char[]{ch0 == '0' ? '9' : (char) (ch0 - 1), ch1, ch2, ch3});
				String str1 = new String(new char[]{ch0 == '9' ? '0' : (char) (ch0 + 1), ch1, ch2, ch3});
				String str2 = new String(new char[]{ch0, ch1 == '0' ? '9' : (char) (ch1 - 1), ch2, ch3});
				String str3 = new String(new char[]{ch0, ch1 == '9' ? '0' : (char) (ch1 + 1), ch2, ch3});
				String str4 = new String(new char[]{ch0, ch1, ch2 == '0' ? '9' : (char) (ch2 - 1), ch3});
				String str5 = new String(new char[]{ch0, ch1, ch2 == '9' ? '0' : (char) (ch2 + 1), ch3});
				String str6 = new String(new char[]{ch0, ch1, ch2, ch3 == '0' ? '9' : (char) (ch3 - 1)});
				String str7 = new String(new char[]{ch0, ch1, ch2, ch3 == '9' ? '0' : (char) (ch3 + 1)});

				String[] strings = {str0, str1, str2, str3, str4, str5, str6, str7};

				for (String s : strings) {
					if (!used.contains(s) && !dead.contains(s)) {
						queue.offer(s);
						used.add(s);
					}
				}

			}
		}

		return -1;
	}
}