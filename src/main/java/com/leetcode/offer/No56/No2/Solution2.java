package com.leetcode.offer.No56.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/29 10:44
 */
public class Solution2 {
	public int singleNumber(int[] nums) {
		// �������ֵĶ�������ʽ�����ڳ������ε����֣��� ������λ ���ֵĴ������� 33 �ı�����
		// ��ˣ�ͳ���������ֵĸ�������λ�� 11 �ĳ��ִ��������� 33 ���࣬�����Ϊֻ����һ�ε����֡�
		int[] times = new int[32];

		for (int num : nums) {
			for (int i = 0; i < 32; i++) {
				times[31 - i] += (num >> i) & 1;
			}
		}

		for (int i = 0; i < 32; i++)
			times[i] %= 3;

		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			result += times[i];
		}

		return result;
	}
}
