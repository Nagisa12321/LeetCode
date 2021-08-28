package com.leetcode.algorithm.No726;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/5 16:27
 */
public class Solution {
	public String countOfAtoms(String formula) {
		Stack<Object> stack = new Stack<>();
		StringBuilder strBuf = new StringBuilder();
		int numBuf = 0;
		char[] chs = formula.toCharArray();

		// 0: nothing
		// 1: reading name
		// 2: reading number
		// 3: (
		// 4: )
		int state = 0;
		for (char ch : chs) {
			if (ch >= '0' && ch <= '9') {
				if (state == 1) {
					HashMap<String, Integer> map = new HashMap<>();
					map.put(strBuf.toString(), 1);
					stack.push(map);
					strBuf = new StringBuilder();
				}

				numBuf *= 10;
				numBuf += ch - '0';
				state = 2;
			} else if (ch == '(') {
				if (state == 1) {
					HashMap<String, Integer> map = new HashMap<>();
					map.put(strBuf.toString(), 1);
					stack.push(map);
					strBuf = new StringBuilder();
				} else if (state == 2) {
					HashMap<String, Integer> map = new HashMap<>();
					HashMap<String, Integer> tmp = (HashMap<String, Integer>) stack.pop();
					Set<Map.Entry<String, Integer>> entries = tmp.entrySet();
					for (Map.Entry<String, Integer> entry : entries) {
						map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * numBuf);
					}
					stack.push(map);
					numBuf = 0;
				}

				stack.push('(');
				state = 3;
			} else if (ch == ')') {
				if (state == 1) {
					HashMap<String, Integer> map = new HashMap<>();
					map.put(strBuf.toString(), 1);
					stack.push(map);
					strBuf = new StringBuilder();
				} else if (state == 2) {
					HashMap<String, Integer> map = new HashMap<>();
					HashMap<String, Integer> tmp = (HashMap<String, Integer>) stack.pop();
					Set<Map.Entry<String, Integer>> entries = tmp.entrySet();
					for (Map.Entry<String, Integer> entry : entries) {
						map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * numBuf);
					}
					stack.push(map);
					numBuf = 0;
				}

				HashMap<String, Integer> map = new HashMap<>();
				while (!stack.peek().equals('(')) {
					HashMap<String, Integer> tmp = (HashMap<String, Integer>) stack.pop();
					Set<Map.Entry<String, Integer>> entries = tmp.entrySet();
					for (Map.Entry<String, Integer> entry : entries) {
						map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue());
					}
				}
				stack.pop();
				stack.push(map);
				state = 4;
			} else if (Character.isUpperCase(ch)) {
				if (state == 1) {
					HashMap<String, Integer> map = new HashMap<>();
					map.put(strBuf.toString(), 1);
					stack.push(map);
					strBuf = new StringBuilder();
				} else if (state == 2) {
					HashMap<String, Integer> map = new HashMap<>();
					HashMap<String, Integer> tmp = (HashMap<String, Integer>) stack.pop();
					Set<Map.Entry<String, Integer>> entries = tmp.entrySet();
					for (Map.Entry<String, Integer> entry : entries) {
						map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * numBuf);
					}
					stack.push(map);
					numBuf = 0;
				}

				strBuf.append(ch);
				state = 1;
			} else {

				strBuf.append(ch);
				state = 1;
			}
		}
		if (state == 1) {
			HashMap<String, Integer> map = new HashMap<>();
			map.put(strBuf.toString(), 1);
			stack.push(map);
		} else if (state == 2) {
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<String, Integer> tmp = (HashMap<String, Integer>) stack.pop();
			Set<Map.Entry<String, Integer>> entries = tmp.entrySet();
			for (Map.Entry<String, Integer> entry : entries) {
				map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * numBuf);
			}
			stack.push(map);
		}

		HashMap<String, Integer> map = new HashMap<>();
		while (!stack.isEmpty()) {
			HashMap<String, Integer> tmp = (HashMap<String, Integer>) stack.pop();
			Set<Map.Entry<String, Integer>> entries = tmp.entrySet();
			for (Map.Entry<String, Integer> entry : entries) {
				map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue());
			}
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getKey(), o2.getKey()));
		strBuf = new StringBuilder();
		for (Map.Entry<String, Integer> entry : list) {
			strBuf.append(entry.getKey());
			if (entry.getValue() > 1)
				strBuf.append(entry.getValue());
		}
		return strBuf.toString();
	}
}