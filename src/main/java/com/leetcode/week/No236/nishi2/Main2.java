package com.leetcode.week.No236.nishi2;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/15 11:10
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		// 0 - left, 1 - right
		int[][] robots = new int[T][2];
		int[] helper = new int[T];
		for (int t = 0; t < T; t++) {
			int pos = scanner.nextInt();
			int direct = scanner.next().equals("L") ? 0 : 1;
			robots[t][0] = pos;
			helper[t] = pos;
			robots[t][1] = direct;
		}
		HashMap<Integer, Integer> robotMap = new HashMap<>();
		Arrays.sort(robots, Comparator.comparingInt(arr -> arr[0]));

		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < T; i++) {
			List<int[]> popList = new ArrayList<>();
			boolean find = false;
			while (!stack.isEmpty() && stack.peek()[1] == 1 && robots[i][1] == 0) {
				int[] hand = stack.pop();
				int distance = robots[i][0] - hand[0];
				if (distance % 2 == 0) {
					find = true;
					int time = (distance) / 2;
					robotMap.put(hand[0], time);
					robotMap.put(robots[i][0], time);
					break;
				} else {
					popList.add(hand);
				}
			}
			for (int[] pop : popList)
				stack.push(pop);
			if (!find)
				stack.push(robots[i]);
		}

		for (int i = 0; i < T; i++) {
			System.out.println(robotMap.getOrDefault(helper[i], -1));
		}
	}
}
