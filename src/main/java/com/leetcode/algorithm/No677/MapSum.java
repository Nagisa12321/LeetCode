package com.leetcode.algorithm.No677;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 14:06
 */
public class MapSum {
	private final TrieNode head;

	/** Initialize your data structure here. */
	public MapSum() {
		head = new TrieNode();
	}

	public void insert(String key, int val) {
		TrieNode cur = head;
		char[] chs = key.toCharArray();

		for (char ch : chs) {
			if (cur.trieNodes[ch - 'a'] == null) {
				cur.trieNodes[ch - 'a'] = new TrieNode();
			}
			cur = cur.trieNodes[ch - 'a'];
		}

		cur.val = val;
	}

	public int sum(String prefix) {
		TrieNode cur = head;
		char[] chs = prefix.toCharArray();
		for (char ch : chs) {
			if (cur.trieNodes[ch - 'a'] == null) return 0;
			cur = cur.trieNodes[ch - 'a'];
		}
		return sum(cur);
	}

	private int sum(TrieNode node) {
		int sum = node.val;

		for (int i = 0; i < 26; i++) {
			if (node.trieNodes[i] != null)
				sum += sum(node.trieNodes[i]);
		}

		return sum;
	}


	private static class TrieNode {
		public int val = 0;
		public TrieNode[] trieNodes;

		public TrieNode() {
			trieNodes = new TrieNode[26];
		}
	}
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */