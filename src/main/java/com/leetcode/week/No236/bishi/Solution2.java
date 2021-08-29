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
		2. �ж������ļ�input.data,����ÿһ���ֽڶ���Ϊһ���޷�������,
		��д����,�ҳ����г��ִ�����������,�������ֵ�ͳ��ִ���,������Բ���.
	 */

	public static void main(String[] args) throws IOException {
		// ��ȡ�ļ�
		InputStream fis = new FileInputStream("input.data");

		// ����ͳ�Ƶ�map
		int[] map = new int[256];

		// һ��readһ��ͳ��
		// fis���������� -1 Ϊ�ļ�������
		int data;
		while ((data = fis.read()) != -1) {
			map[data]++;
		}

		// ͳ��ֵ�ͳ��ִ���
		int times = 0; // ���ִ���
		int res = 0; // ֵ
		for (int i = 0; i < 256; i++) {
			if (map[i] > times) {
				times = map[i];
				res = i;
			}
		}

		// ���ֵ�ͳ��ִ���
		System.out.println("[value: " + res + ", appear times: " + times + "]");
	}

}
