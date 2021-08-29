package com.leetcode.algorithm.No208;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
	@Test
	public void test1() {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("app");

		System.out.println(trie);
	}

}