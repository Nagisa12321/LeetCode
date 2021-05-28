package com.leetcode.week.No236.mianshi;

import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/7 21:19
 */
public class Solution1 {

	// 0, 1, 2, 3, 4
	public int rdm4() {
		// [0, 1)
		double random = Math.random();
		return (int) (random * 5); // [0, 5)
	}

	// 0, 1, 2, 3, 4, 5, 6, 7
	public int rdm6() {
		int result;
		do { result = rdm4() * 5 + rdm4(); }
		while (result > 20);
		return result / 3;
	}


	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		int zero = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		for (int i = 0; i < 200000; i++) {
			int i1 = solution1.rdm6();
			if (i1 == 0) zero++;
			if (i1 == 1) one++;
			if (i1 == 2) two++;
			if (i1 == 3) three++;
			if (i1 == 4) four++;
			if (i1 == 5) five++;
			if (i1 == 6) six++;
		}
		System.out.println(zero);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);
		System.out.println(six);
	}
}
