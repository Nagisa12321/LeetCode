package com.leetcode.algorithm.No341;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/23 13:37
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class NestedIterator1 implements Iterator<Integer> {

	private final Iterator<Integer> itr;
	private final ArrayList<Integer> list;

	public NestedIterator1(List<NestedInteger> nestedList) {
		list = new ArrayList<>();
		dfs(nestedList);
		itr = list.iterator();
	}


	@Override
	public Integer next() {
		return itr.next();
	}

	@Override
	public boolean hasNext() {
		return itr.hasNext();
	}

	public void dfs(List<NestedInteger> list) {
		if (list.isEmpty()) return;

		for (NestedInteger nest : list) {
			if (nest.isInteger()) {
				this.list.add(nest.getInteger());
			} else {
				dfs(nest.getList());
			}
		}

	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
