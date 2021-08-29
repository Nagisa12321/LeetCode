package com.leetcode.interview.real;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/22 21:29
 */
public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int t = 0; t < T; t++) {
			int n = scanner.nextInt();
			int[] nums = new int[n];

			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}

			func(nums, n);
		}
	}
	private static boolean canZero;
	private static boolean canOne;

	private static void func(int[] nums, int n) {
		canZero = false;
		canOne = false;

		dfs(new Stack<>(), nums, 0, n);

		System.out.print((canZero ? "1" : "0") + " " + (canOne ? "1" : "0"));
	}

	private static void dfs(Stack<Integer> stack, int[] nums, int idx, int n) {
		if (canOne && canZero)
			return;
		if (idx == n) {
			if (stack.size() == 1) {
				int num = stack.pop();
				if (num == 0) {
					canZero = true;
				} else {
					canOne = true;
				}
				stack.push(num);
			}

			if (stack.size() == 2) {
				int num1 = stack.pop();
				int num2 = stack.pop();

				if (num1 == 0 && num2 == 0)
					canOne = true;
				if (num1 == 1 && num2 == 1)
					canZero = true;

				stack.push(num2);
				stack.push(num1);
			}
			return;
		}


		if (nums[idx] == 1) {
			stack.push(1);
			dfs(stack, nums, idx + 1, n);
			stack.pop();

			if (!stack.isEmpty() && stack.peek() == 1) {
				stack.pop();
				stack.push(0);
				dfs(stack, nums, idx + 1, n);
				stack.pop();
				stack.push(1);
			}
		} else {
			stack.push(0);
			dfs(stack, nums, idx + 1, n);
			stack.pop();

			if (!stack.isEmpty() && stack.peek() == 0) {
				stack.pop();
				stack.push(1);
				dfs(stack, nums, idx + 1, n);
				stack.pop();
				stack.push(0);
			}
		}
	}
}
