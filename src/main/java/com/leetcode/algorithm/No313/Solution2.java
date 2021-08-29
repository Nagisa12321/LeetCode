package com.leetcode.algorithm.No313;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/14 9:07
 */
public class Solution2 {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int len = primes.length;
		int dp[] = new int[n];
		dp[0] = 1;
		/*����һ��˼·��dp[i]������ǵ�i����������*/
        /*index[i]��ʾ����primes����ĵ�i������һ����Ҫ��˵�����dp�е�λ�ã�
        �������룬����ÿ��primes��˵�����Ƕ���Ҫ��dp���Ѿ�������Ľ������㣬
        Ȼ��ȡ��С���Ǹ���Ϊ�µ�dpԪ��
        ����indexʵ���ϱ�ʾ����������Ѿ���dp�е��ĸ�λ�ý���ˣ���һ��λ�õ������Ƕ��� */
		int index[] = new int[len];
		/*���ܴ����ظ��ĳ����������أ���Ҫ��forѭ�������break�������е������+1*/
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			/*�����Ա�һ��ֵ���ҳ���С�ģ�*/
			for (int j = 0; j < len; j++) {
				if (min > primes[j] * dp[index[j]]) {
					min = primes[j] * dp[index[j]];//����ط����ǵ�ǰ����������Ҫ��ϵ�dp
				}
			}
			dp[i] = min;
			/*�Ǹ�����Ҫ����dp������indexҪ��1�������һ��λ
			 * ��������ظ���ֵ��Ҳ����˵��ͬ����������ˣ��ó�����ͬ�Ľ���ˣ�
			 * ���ǾͰ��⼸��λ�ö�+1�������Ϳ��Ա�������ظ���ֵ�ˡ�
			 * �����룬�������ҵ��˶�Ӧ��������index��������1֮���break������ô�������Ҳ���������������
			 * �´�ѭ����ʱ���Ʊػ������ظ�����������һ��dp����Ϊ������϶�Ҫ����һ������С
			 * ����������forѭ���в�Ҫ��break��*/
			for (int j = 0; j < len; j++) {
				if (min == primes[j] * dp[index[j]]) {
					index[j]++;
				}
			}

		}
		return dp[n - 1];
	}
}