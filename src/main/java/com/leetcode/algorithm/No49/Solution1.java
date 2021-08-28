package com.leetcode.algorithm.No49;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/28 9:49
 */
public class Solution1 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<MagicStr, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			MagicStr ms = new MagicStr(strs[i]);
			if (!map.containsKey(ms))
				map.put(ms, new ArrayList<>());
			map.get(ms).add(strs[i]);
		}
		return new ArrayList<>(map.values());
	}

	static class MagicStr {
		String str;

		public MagicStr(String str) {
			this.str = str;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof MagicStr)) return false;
			MagicStr magicStr = (MagicStr) o;
			return magicStr.hashCode() == hashCode();
		}

		public int hashCode() {
			byte[] bytes = str.getBytes();
			int[] map = new int[26];
			for (int i = 0; i < bytes.length; i++) {
				map[bytes[i] - 'a']++;
			}
			return Arrays.hashCode(map);
		}
	}
}