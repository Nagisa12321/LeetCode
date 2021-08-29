package com.leetcode.algorithm.No401;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/21 10:08
 */
public class Solution {
	public List<String> readBinaryWatch(int turnedOn) {
		List<String> list = new ArrayList<>();
		trace(list, turnedOn, 0, 0, 0, 0);
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] split = o1.split(":");
				int num1a = Integer.parseInt(split[0]);
				int num1b = Integer.parseInt(split[1]);

				split = o2.split(":");
				int num2a = Integer.parseInt(split[0]);
				int num2b = Integer.parseInt(split[1]);
				if (num2a != num1a) return num1a - num2a;
				return num1b - num2b;
			}
		});
		return list;
	}

	private void trace(List<String> list, int turnedOn, int realTurn, int hour, int minute, int idx) {
		if (realTurn == turnedOn) {
			if (hour <= 12 && minute < 60) {
				String time = hour + ":";
				if (minute < 10) time += "0";
				time += String.valueOf(minute);
				list.add(time);
			}
			return;
		}
		for (int i = idx; i < 10; i++) {
			if (i < 4)
				hour += 1 << i;
			else
				minute += 1 << (i - 4);
			trace(list, turnedOn, realTurn + 1, hour, minute, i + 1);
			if (i < 4)
				hour -= 1 << i;
			else
				minute -= 1 << (i - 4);
		}
	}
}