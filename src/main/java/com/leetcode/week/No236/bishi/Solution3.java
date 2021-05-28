package com.leetcode.week.No236.bishi;

import java.io.*;
import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/30 10:27
 */
public class Solution3 {
	/*
		3. ���ı��ļ�input.txt, ÿ�ж���¼��һ���������ƺ�һ����������,
		����: "������,m,n",����,�������Ʋ����ظ�,m,n����������,��m<n,
		���е���������[m,n]�����ᷢ������.
		���д����,���������������x,�������Ƿ�����ĳ�����ж�Ӧ����������,
		�������������Ӧ�ĳ�����,������Բ���.
	 */
	public static void main(String[] args) throws IOException {
		// ��ȡ�ļ�
		InputStream fis = new FileInputStream("src/main/resources/input.data");
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

		Map<Integer, String> cityMap = new HashMap<>(); // ͨ���������ҳ�����
		Map<Integer, Integer> rightMap = new HashMap<>(); // ͨ����������������
		// һ��һ�еĶ�, ��������map��
		String line;
		while ((line = reader.readLine()) != null) {
			String[] strs = line.split(",");
			int left = Integer.parseInt(strs[1]);

			rightMap.put(left, Integer.parseInt(strs[2]));
			cityMap.put(left, strs[0]);
		}

		// ��������ļ��ϱ��һ������õ����� -> nums
		int len = cityMap.keySet().size();
		int[] nums = new int[len];
		int idx = 0;
		for (int num : cityMap.keySet()) {
			nums[idx++] = num;
		}
		Arrays.sort(nums);

		// �ҵ�˼·���ȶ��ֲ���, �ҵ�һ������target���ʵ�������
		// �����ж�targetֵ�Ƿ�Ҳ���ұ�������
		Scanner sc = new Scanner(System.in);
		while (true) {
			int target = sc.nextInt();

			int left = 0; // Ŀ���������
			int lo = 0, hi = len - 1;
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				// �����ǰmid��Ӧ��ֵ����target, ˵��target�պþ���������
				// �����ǰmid�Ķ�Ӧ��ֵС��target, ����midΪ�������һ���mid+1��Ӧ��ֵ��target��, ˵��midΪ������
				// �������ֱ��break
				if (nums[mid] == target || (nums[mid] < target && (mid == len - 1 || nums[mid + 1] > target))) {
					left = mid;
					break;
				} else if (nums[mid] < target) lo = mid + 1;
				else hi = mid - 1;
			}

			// �ж��������Ƿ����Ҫ��
			int right = rightMap.get(nums[left]);
			if (right >= target) {
				// ����������
				String city = cityMap.get(nums[left]);
				System.out.println("your target is in [" + nums[left] + ", " + right + "] and the city is " + city + ".");
			} else {
				// ����������
				System.out.println("your target is not in the areas.");
			}
		}
	}
}
