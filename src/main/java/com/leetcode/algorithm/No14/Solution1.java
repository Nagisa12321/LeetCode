package com.leetcode.algorithm.No14;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/17 14:04
 */
public class Solution1 {
	public String longestCommonPrefix(String[] strs) {
		int len = strs.length;
		Tire root = new Tire();
		for (int i = 0; i < len; i++) {
			char[] chs = strs[i].toCharArray();

			Tire cur = root;
			for (char ch : chs) {
				if (cur.children[ch - 'a'] == null)
					cur.children[ch - 'a'] = new Tire();
				cur.times[ch - 'a'] += 1;
				cur = cur.children[ch - 'a'];
			}
		}

		StringBuilder builder = new StringBuilder();
		Tire cur = root;
		while (true) {
			int child = 0;
			int childIdx = 0;
			for (int i = 0; i < 26; i++)
				if (cur.children[i] != null) {
					child++;
					childIdx = i;
				}
			if (child != 1 || cur.times[childIdx] != len)
				break;
			else
				builder.append((char) (childIdx + 'a'));
			cur = cur.children[childIdx];
		}

		return builder.toString();
	}

	static class Tire {
		Tire[] children;
		int[] times;
		public Tire() {
			children = new Tire[26];
			times = new int[26];
		}
	}
}