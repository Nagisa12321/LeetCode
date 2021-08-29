package com.leetcode.meituan.No1;

import java.io.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/27 14:27
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			String str = reader.readLine();
			if (isID(str)) writer.write("Accept\n");
			else writer.write("Wrong\n");
		}

		reader.close();
		writer.close();
	}

	private static boolean isID(String s) {
		char[] chs = s.toCharArray();
		boolean reading = false;
		boolean hasNumber = false;
		boolean hasCharacter = false;
		for (char ch : chs) {
			if (reading) {
				if (isCharacter(ch)) hasCharacter = true;
				else if (isNumber(ch)) hasNumber = true;
				else return false;
			} else {
				if (isCharacter(ch)) reading = true;
				else return false;
			}
		}

		return hasNumber && hasCharacter;
	}

	private static boolean isCharacter(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	private static boolean isNumber(char ch) {
		return ch >= '0' && ch <= '9';
	}
}