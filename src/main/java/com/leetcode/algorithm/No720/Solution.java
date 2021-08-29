package com.leetcode.algorithm.No720;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/22 14:07
 */
public class Solution {
	private int maxDeep = 0;
	private String result = "";
	public String longestWord(String[] words) {
		TireNode head = new TireNode();
		head.isWord = true;
		head.word = "";

		for (String word : words) {
			char[] chs = word.toCharArray();
			TireNode cur = head;

			for (char ch : chs) {
				if (cur.tireNodes[ch - 'a'] == null)
					cur.tireNodes[ch - 'a'] = new TireNode();
				cur = cur.tireNodes[ch - 'a'];
			}

			cur.isWord = true;
			cur.word = word;
		}

		dfs(head, 0);

		return result;
	}

	public void dfs(TireNode node, int deep) {
		if (node == null || !node.isWord) return;
		if (deep == maxDeep) {
			if (node.word.compareTo(result) > 0)
				result = node.word;
		} else if (deep > maxDeep) {
			result = node.word;
			maxDeep = deep;
		}

		for (int i = 0; i < 26; i++) {
			dfs(node.tireNodes[i], deep + 1);
		}
	}

	private static class TireNode {
		public TireNode[] tireNodes = new TireNode[26];
		public boolean isWord = false;
		public String word;
	}
}