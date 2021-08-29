package com.leetcode.algorithm.No981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/10 8:39
 */
public class TimeMap {
	private HashMap<String, TreeMap<Integer, String>> map;
	/** Initialize your data structure here. */
	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key))
			map.put(key, new TreeMap<>());
		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";
		Map.Entry<Integer,String> entry = map.get(key).floorEntry(timestamp);
		return entry == null ? "" : entry.getValue();
	}
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */