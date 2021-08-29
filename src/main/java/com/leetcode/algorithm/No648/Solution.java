package com.leetcode.algorithm.No648;

import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 14:46
 */
public class Solution {
	public String replaceWords(List<String> dictionary, String sentence) {
		// 根据 dictionary 创建前缀树, 并且标记结束点
		TireNode head = new TireNode();
		for (String str : dictionary) {
			TireNode cur = head;
			char[] chs = str.toCharArray();

			for (char ch : chs) {
				if (cur.tireNodes[ch - 'a'] == null) {
					cur.tireNodes[ch - 'a'] = new TireNode();
				}
				cur = cur.tireNodes[ch - 'a'];
			}
			// 标记结束点
			cur.end = true;
			cur.word = str;
		}

		String[] strs = sentence.split(" ");
		StringBuilder result = new StringBuilder();
		P:for (int i = 0; i < strs.length; i++) {
			TireNode cur = head;
			char[] chs = strs[i].toCharArray();

			for (char ch : chs) {
				if (cur.end) {
					result.append(cur.word);
					if (i != strs.length - 1) result.append(" ");
					continue P;
				}
				if (cur.tireNodes[ch - 'a'] == null) break;
				cur = cur.tireNodes[ch - 'a'];
			}

			if (cur.end)
				strs[i] = cur.word;

			result.append(strs[i]);
			if (i != strs.length - 1) result.append(" ");
		}
		return result.toString();
	}


	private static class TireNode {
		public boolean end = false;
		public String word = "";
		public TireNode[] tireNodes = new TireNode[26];
	}
}