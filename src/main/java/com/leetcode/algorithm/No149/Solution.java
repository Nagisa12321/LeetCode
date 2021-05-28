package com.leetcode.algorithm.No149;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 14:19
 */
public class Solution {
	public int maxPoints(int[][] points) {
		int len = points.length;
		HashMap<Pair, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				int x_1 = points[i][0];
				int x_2 = points[j][0];
				int y_1 = points[i][1];
				int y_2 = points[j][1];

				double k, b;
				if (x_1 == x_2) {
					k = Double.MAX_VALUE;
					b = x_1;
				} else {
					k = (double) (y_1 - y_2) / (x_1 - x_2);
					b = (double) (x_1 * y_2 - x_2 * y_1) / (x_1 - x_2);
				}

				Pair pair = new Pair(k, b);
				int tmp = map.getOrDefault(pair, 0) + 1;
				map.put(pair, tmp);
				max = Math.max(tmp, max);
			}
		}

		return (int) (Math.sqrt((2 * max) + (double) (1 / 4)) + 0.5) + 1;
	}


	private static class Pair {
		double k;
		double b;

		public Pair(double k, double b) {
			this.k = k;
			this.b = b;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Pair)) return false;
			Pair pair = (Pair) o;
			return Double.compare(pair.k, k) == 0 && Double.compare(pair.b, b) == 0;
		}

		@Override
		public int hashCode() {
			return Objects.hash(k, b);
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Pair{");
			sb.append("k=").append(k);
			sb.append(", b=").append(b);
			sb.append('}');
			return sb.toString();
		}
	}
}