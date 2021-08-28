package com.leetcode.intermediate.No10.No2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/18 11:12
 */
public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<Integer, List<String>> map = new HashMap<>();
		for (String word : strs) {
			char[] chs = word.toCharArray();
			int[] arr = new int[26];
			for (char ch : chs) {
				arr[ch - 'a']++;
			}
			if (!map.containsKey(Arrays.hashCode(arr)))
				map.put(Arrays.hashCode(arr), new ArrayList<>());
			map.get(Arrays.hashCode(arr)).add(word);
		}
		return new ArrayList<>(map.values());
	}
}