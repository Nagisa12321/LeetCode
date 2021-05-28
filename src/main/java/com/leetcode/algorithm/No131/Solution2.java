package com.leetcode.algorithm.No131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/9 13:35
 */
public class Solution2 {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();

		track(s, result, new ArrayList<>());

		return result;
	}

	public void track(String s, List<List<String>> result, List<String> list) {
		if (s.length() == 0) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			if (isReserved(s, i)) {
				String sub_1 = s.substring(i + 1);
				String sub_2 = s.substring(0, i + 1);
				list.add(sub_2);

				track(sub_1, result, list);

				list.remove(list.size() - 1);
			}
		}
	}

	public boolean isReserved(String s, int idx) {
		char[] chs = s.toCharArray();

		for (int i = 0; i <= idx / 2; i++) {
			if (chs[i] != chs[idx - i]) return false;
		}

		return true;
	}
}