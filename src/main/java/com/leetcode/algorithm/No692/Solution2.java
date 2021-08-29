package com.leetcode.algorithm.No692;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/20 9:51
 */
public class Solution2 {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}

		// 每次poll都是出现次数最少的那个
		PriorityQueue<String> pq = new PriorityQueue<>(k, (word1, word2) -> {
			int tmp = map.get(word2) - map.get(word1);
			if (tmp != 0) return tmp;
			return String.CASE_INSENSITIVE_ORDER.compare(word1, word2);
		});

		for (String word : map.keySet()) {
			pq.offer(word);
		}

		return new ArrayList<>(pq);
	}
}
