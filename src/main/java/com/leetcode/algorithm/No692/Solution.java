package com.leetcode.algorithm.No692;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/20 9:44
 */
public class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}
		// 先按字母排序, 再按出现次数排序
		List<String> tmp = new ArrayList<>(map.keySet());
		tmp.sort(String.CASE_INSENSITIVE_ORDER);
		tmp.sort((word1, word2) -> {
			return map.get(word2) - map.get(word1);
		});

		List<String> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(tmp.get(i));
		}

		return res;
	}
}