package com.leetcode.algorithm.No767;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/27 9:14
 */
public class Solution {
	public String reorganizeString(String S) {
		char[] chs = S.toCharArray();
		int len = chs.length;

		int[] map = new int[26];
		for (char ch : chs) map[ch - 'a']++;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		for (int i = 0; i < 26; i++) {
			if (map[i] != 0) {
				pq.offer(new int[]{map[i], i});
			}

			if (map[i] > len / 2) {
				if (map[i] == len / 2 + 1) {
					if (len % 2 == 1) continue;
					else return "";
				} else return "";
			}
		}
		int idx = 0;
		for (int i = 0; i < len; i += 2) {
			if (pq.peek()[0] == 0) pq.poll();
			chs[i] = (char) (pq.peek()[1] + 'a');
			pq.peek()[0]--;
		}
		for (int i = 1; i < len; i += 2) {

			if (pq.peek()[0] == 0) pq.poll();
			chs[i] = (char) (pq.peek()[1] + 'a');
			pq.peek()[0]--;
		}

		return new String(chs);
	}
}