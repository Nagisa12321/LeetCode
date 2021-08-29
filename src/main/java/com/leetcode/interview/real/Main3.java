package com.leetcode.interview.real;


import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int K = scanner.nextInt();

		int[] nums1 = new int[N];
		int[] nums2 = new int[N];
		for (int n = 0; n < N; n++) {
			nums1[n] = scanner.nextInt();
		}
		for (int n = 0; n < N; n++) {
			nums2[n] = scanner.nextInt();
		}

		printfK(nums1, nums2, K, N);
	}

	private static void printfK(int[] nums1, int[] nums2, int K, int N) {
		int[] res = new int[N * N];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res[idx++] = nums1[i] + nums2[j];
			}
		}

		Arrays.sort(res);

		for (int k = 0; k < K; k++) {
			int re = res[N * N - 1 - k];
			if (k == K - 1)
				System.out.print(re);
			else
			System.out.print(re + " ");
		}
	}

	private static void printfK1(int[] nums1, int[] nums2, int K, int N) {
		int[] sub1 = new int[N];
		int[] sub2 = new int[N];

		for (int i = 1; i < N; i++) {
			sub1[i] = nums1[i] - nums1[i - 1];
			sub2[i] = nums2[i] - nums2[i - 1];
		}

		int i1 = N - 1;
		int i2 = N - 1;
		for (int k = 0; k < K; k++) {
			System.out.println(nums1[i1] + nums2[i2]);

			if (i2 == 0 || sub1[i1] < sub2[i2]) {
				i1--;
			} else {
				i2--;
			}
		}
	}
}
