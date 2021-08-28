package com.leetcode.algorithm.No1418;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/6 16:43
 */
public class Solution {
	public List<List<String>> displayTable(List<List<String>> orders) {
		TreeMap<Integer, HashMap<String, Integer>> map = new TreeMap<>();
		TreeSet<String> set = new TreeSet<>();

		for (List<String> order : orders) {
			int table = Integer.parseInt(order.get(1));
			String food = order.get(2);
			set.add(food);
			HashMap<String, Integer> tab =
					map.getOrDefault(table, new HashMap<>());
			tab.put(food, tab.getOrDefault(food, 0) + 1);
			map.put(table, tab);
		}
		List<List<String>> res = new ArrayList<>();
		List<String> title = new ArrayList<>();
		title.add("Table");
		title.addAll(set);
		res.add(title);
		for (Map.Entry<Integer, HashMap<String, Integer>> entry : map.entrySet()) {
			List<String> content = new ArrayList<>();
			HashMap<String, Integer> foodMap = entry.getValue();
			content.add(String.valueOf(entry.getKey()));
			for (String food : set) {
				content.add(String.valueOf(foodMap.getOrDefault(food, 0)));
			}
			res.add(content);
		}
		return res;
	}
}