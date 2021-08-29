package com.leetcode.interview.real;


import java.util.Scanner;
import java.util.Stack;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int t = 0; t < T; t++) {
			String line = scanner.next();
			System.out.println(times(line));
		}
	}

	private static int times(String line) {
		char[] chs = line.toCharArray();
		Stack<Character> stack = new Stack<>();

		int res = 0;
		for (char ch : chs) {
			if (!stack.isEmpty() && stack.peek() == ch) {
				res++;
				stack.pop();
			}
			else stack.push(ch);
		}

		return res;
	}
}
