package com.leetcode.algorithm.No345;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/25 15:16
 */
public class Solution2 extends Solution {
	@Override
	public String reverseVowels(String s) {
		char[] chs = s.toCharArray();

		int left = 0, right = chs.length - 1;

		while (true) {
			while (left < chs.length && !isAEIOU(chs[left]))
				left++;
			while (right >= 0 && !isAEIOU(chs[right]))
				right--;

			if (left >= right) break;
			swap(left, right, chs);
			left++;
			right--;
		}

		return new String(chs);
	}

	private void swap(int left, int right, char[] chs) {
		char tmp = chs[left];
		chs[left] = chs[right];
		chs[right] = tmp;
	}

	private boolean isAEIOU(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
				c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
}
