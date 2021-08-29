package com.leetcode.algorithm.No1239;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/20 16:50
 */
public class Solution {
	private int res;

	public int maxLength(List<String> arr) {
		res = 0;
		trace(arr, 0, "");
		return res;
	}

	private void trace(List<String> arr, int idx, String str) {
		if (isWordOnly(str)) {
			res = Math.max(res, str.length());
		}
		for (int i = idx; i < arr.size(); i++) {
			String tmp = str + arr.get(i);
			trace(arr, i + 1, tmp);
		}
	}

	private boolean isWordOnly(String str) {
		if (str.equals("")) return false;
		char[] chs = str.toCharArray();
		int[] map = new int[26];
		for (char ch : chs) {
			map[ch - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (map[i] > 1) return false;
		}
		return true;
	}
}