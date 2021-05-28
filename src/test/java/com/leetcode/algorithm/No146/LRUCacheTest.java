package com.leetcode.algorithm.No146;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class LRUCacheTest {
	@Test
	public void test1() {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(2, 1);
		lruCache.put(1, 1);
		lruCache.put(2, 3);
		lruCache.put(4, 1);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(2));

	}
}