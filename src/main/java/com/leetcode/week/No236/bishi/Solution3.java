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
		3. 有文本文件input.txt, 每行都记录了一个城市名称和一个数字区段,
		形如: "城市名,m,n",其中,城市名称不会重复,m,n都是正整数,且m<n,
		所有的数字区间[m,n]都不会发生交叠.
		请编写代码,对输入的任意整数x,查找其是否命中某个城市对应的数字区间,
		如命中则输出对应的城市名,编程语言不限.
	 */
	public static void main(String[] args) throws IOException {
		// 读取文件
		InputStream fis = new FileInputStream("src/main/resources/input.data");
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

		Map<Integer, String> cityMap = new HashMap<>(); // 通过左区间找城市名
		Map<Integer, Integer> rightMap = new HashMap<>(); // 通过左区间找右区间
		// 一行一行的读, 存在两个map中
		String line;
		while ((line = reader.readLine()) != null) {
			String[] strs = line.split(",");
			int left = Integer.parseInt(strs[1]);

			rightMap.put(left, Integer.parseInt(strs[2]));
			cityMap.put(left, strs[0]);
		}

		// 将左区间的集合变成一个排序好的数组 -> nums
		int len = cityMap.keySet().size();
		int[] nums = new int[len];
		int idx = 0;
		for (int num : cityMap.keySet()) {
			nums[idx++] = num;
		}
		Arrays.sort(nums);

		// 我的思路是先二分查找, 找到一个对于target合适的左区间
		// 接着判断target值是否也在右边区间内
		Scanner sc = new Scanner(System.in);
		while (true) {
			int target = sc.nextInt();

			int left = 0; // 目标的左区间
			int lo = 0, hi = len - 1;
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				// 如果当前mid对应的值就是target, 说明target刚好就是左区间
				// 如果当前mid的对应的值小于target, 而且mid为数组最右或者mid+1对应的值比target大, 说明mid为左区间
				// 两种情况直接break
				if (nums[mid] == target || (nums[mid] < target && (mid == len - 1 || nums[mid + 1] > target))) {
					left = mid;
					break;
				} else if (nums[mid] < target) lo = mid + 1;
				else hi = mid - 1;
			}

			// 判断右区间是否符合要求
			int right = rightMap.get(nums[left]);
			if (right >= target) {
				// 存在区间内
				String city = cityMap.get(nums[left]);
				System.out.println("your target is in [" + nums[left] + ", " + right + "] and the city is " + city + ".");
			} else {
				// 不在区间内
				System.out.println("your target is not in the areas.");
			}
		}
	}
}
