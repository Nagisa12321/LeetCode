package com.leetcode.week.No236.nishi2;

import java.util.Scanner;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/15 10:05
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int t = 0; t < T; t++) {
			int num = scanner.nextInt();
			int[] arr = new int[num];
			for (int n = 0; n < num; n++) {
				arr[n] = scanner.nextInt();
			}

			int[] map = new int[num];
			boolean can = true;
			for (int i = 0; i < num; i++) {
				if (arr[i] > num || arr[i] < 1) {
					can = false;
					break;
				}
				map[arr[i] - 1]++;
			}
			if (can)
				for (int i = 0; i < num; i++) {
					if (map[i] != 1) {
						can = false;
						break;
					}
				}
			System.out.println(can ? "Yes" : "No");
		}
	}
}
