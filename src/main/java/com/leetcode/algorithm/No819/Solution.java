package com.leetcode.algorithm.No819;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/21 13:49
 */
public class Solution {
	public String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> set = new HashSet<>();
		HashMap<String, Integer> map = new HashMap<>();
		Collections.addAll(set, banned);
		boolean reading = false;
		int max = 0;
		String result = "";

		StringBuilder builder = new StringBuilder();
		char[] chs = paragraph.toCharArray();
		for (char ch : chs) {
			// Îª×ÖÄ¸
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				reading = true;
				builder.append(Character.toLowerCase(ch));
			} else {
				if (reading) {
					reading = false;
					String tmp = builder.toString();
					if (!set.contains(tmp)) {
						int newVal = map.getOrDefault(tmp, 0) + 1;
						if (newVal > max) {
							result = tmp;
							max = newVal;
						}
						map.put(tmp, newVal);
					}
					builder = new StringBuilder();
				}
			}

		}

		if (reading) {
			String tmp = builder.toString();
			if (!set.contains(tmp)) {
				int newVal = map.getOrDefault(tmp, 0) + 1;
				if (newVal > max) {
					result = tmp;
				}
				map.put(tmp, newVal);
			}
		}

		return result;
	}
}