package com.leetcode.algorithm.No752;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/25 9:06
 */
public class Solution {
	public int openLock(String[] deadends, String target) {
		HashSet<String> set = new HashSet<>();
		for (String s : deadends) {
			if (s.equals("0000")) return -1;
			set.add(s);
		}
		Queue<String> queue = new LinkedList<>();
		queue.offer("0000");
		set.add("0000");
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				if (str.equals(target)) return step;
				String[] strs = nextStr(str);
				for (String s : strs) {
					if (set.contains(s))
						continue;
					queue.offer(s);
					set.add(s);
				}
			}
			step++;
		}
		return -1;
	}

	private String[] nextStr(String s) {
		String[] strs = new String[8];
		char[] chs = s.toCharArray();
		for (int i = 0; i < 8; i++) {
			// strs[i] = i % 2 == 0 ?
			//         new String((chs[i / 2] - '0' + 1) % 10 + '0') :
			//         new String((chs[i / 2] - '0' + 10 - 1) % 10 - '0');
			if (i % 2 == 0) {
				char tmp = chs[i / 2];
				chs[i / 2] = (char) ((chs[i / 2] - '0' + 1) % 10 + '0');
				strs[i] = new String(chs);
				chs[i / 2] = tmp;
			} else {
				char tmp = chs[i / 2];
				chs[i / 2] = (char) ((chs[i / 2] - '0' + 10 - 1) % 10 + '0');
				strs[i] = new String(chs);
				chs[i / 2] = tmp;
			}
		}
		return strs;
	}
}