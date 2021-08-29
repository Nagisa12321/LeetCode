package com.leetcode.week.No236.bishi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/30 10:14
 */
public class Solution2 {

	/*
		2. 有二进制文件input.data,将其每一个字节都视为一个无符号整数,
		编写代码,找出其中出现次数最多的整数,输出其数值和出现次数,编程语言不限.
	 */

	public static void main(String[] args) throws IOException {
		// 读取文件
		InputStream fis = new FileInputStream("input.data");

		// 用来统计的map
		int[] map = new int[256];

		// 一边read一边统计
		// fis输入流读到 -1 为文件结束符
		int data;
		while ((data = fis.read()) != -1) {
			map[data]++;
		}

		// 统计值和出现次数
		int times = 0; // 出现次数
		int res = 0; // 值
		for (int i = 0; i < 256; i++) {
			if (map[i] > times) {
				times = map[i];
				res = i;
			}
		}

		// 输出值和出现次数
		System.out.println("[value: " + res + ", appear times: " + times + "]");
	}

}
