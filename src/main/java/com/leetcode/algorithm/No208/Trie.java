package com.leetcode.algorithm.No208;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 16:58
 */
public class Trie {

	private final TrieNode head;

	/**
	 * Initialize your data structure here.
	 */
	public Trie() {
		head = new TrieNode();
	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		char[] chs = word.toCharArray();

		TrieNode cur = head;
		for (char ch : chs) {
			if (cur.trieNodes[ch - 'a'] == null) {
				cur.trieNodes[ch - 'a'] = new TrieNode();
			}
			cur = cur.trieNodes[ch - 'a'];
		}
		cur.isEnd = true;
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		char[] chs = word.toCharArray();

		TrieNode cur = head;
		for (char ch : chs) {
			if (cur.trieNodes[ch - 'a'] == null) return false;

			cur = cur.trieNodes[ch - 'a'];
		}


		return cur.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		char[] chs = prefix.toCharArray();

		TrieNode cur = head;
		for (char ch : chs) {
			if (cur.trieNodes[ch - 'a'] == null) return false;

			cur = cur.trieNodes[ch - 'a'];
		}

		return true;
	}

	private static class TrieNode {
		boolean isEnd = false;
		public TrieNode[] trieNodes = new TrieNode[26];
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
