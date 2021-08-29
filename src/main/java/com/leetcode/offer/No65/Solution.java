package com.leetcode.offer.No65;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/28 17:09
 */
public class Solution {
	public int add(int a, int b) {
		if (b >= 0)
			for (int i = 0; i < b; i++)
				a++;
		else
			for (int i = 0; i < -b; i++)
				a--;
		return a;
	}
}
