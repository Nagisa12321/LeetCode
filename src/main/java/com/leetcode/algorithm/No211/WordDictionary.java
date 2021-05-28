package com.leetcode.algorithm.No211;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 19:33
 */
public class WordDictionary {
	private final TrieNode head;

	/**
	 * Initialize your data structure here.
	 */
	public WordDictionary() {
		head = new TrieNode();
	}

	public void addWord(String word) {
		char[] chs = word.toCharArray();
		TrieNode cur = head;
		for (char ch : chs) {
			if (cur.trieNodes[ch - 'a'] == null) {
				cur.trieNodes[ch - 'a'] = new TrieNode();
			}
			cur = cur.trieNodes[ch - 'a'];
		}
		// 标记结束
		cur.end = true;
	}

	public boolean search(String word) {
		char[] chs = word.toCharArray();
		return search(chs, 0, head);
	}

	private boolean search(char[] chs, int idx, TrieNode node) {
		if (node == null) return false;
		// 遍历完成时候, 判断是否为结束点
		if (idx == chs.length) return node.end;
		char ch = chs[idx];

		if (ch == '.') {
			for (int i = 0; i < 26; i++)
				if (node.trieNodes[i] != null)
					if (search(chs, idx + 1, node.trieNodes[i])) return true;
			return false;
		} else return search(chs, idx + 1, node.trieNodes[ch - 'a']);
	}

	private static class TrieNode {
		public boolean end = false;
		public TrieNode[] trieNodes = new TrieNode[26];
	}

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */