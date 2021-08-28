package com.leetcode.algorithm.No1969;

import java.math.BigInteger;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/20 22:30
 */
public class Solution {
	public int minNonZeroProduct(int p) {
		int tmp = ((int) Math.pow(2, p) - 1);
		long res = tmp;
//		for (int i = 0; i < tmp / 2; i++) {
//			res *= tmp - 1;
//			res %= ((int) Math.pow(10, 9) + 7);
//		}
		long pow = qpow(tmp - 1, tmp / 2);

		return (int) (res * pow % ((int) Math.pow(10, 9) + 7));
	}

	private long qpow(long x, long n){
		int MOD = ((int) Math.pow(10, 9) + 7);
		x %= MOD;
		long res = 1L;
		while (n > 0)
		{
			if ((n & 1) != 0 )
				res = (res * x) % MOD;
			x = (x * x) % MOD;
			n >>= 1;
		}
		return res;
	}

	private long mypower(long num, int pow) {
		if (pow == 0)
			return 1;
		if (pow == 1)
			return num;
		int a = pow / 2;
		int b = pow - a;

		long x = mypower(num, a);
		long y = mypower(num, b);
		return x * y % ((int) Math.pow(10, 9) + 7);
	}
}