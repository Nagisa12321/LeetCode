package com.leetcode.algorithm.No341;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/23 13:37
 */

import java.util.*;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {

	private final Stack<Iterator<NestedInteger>> itr_stack;

	public NestedIterator(List<NestedInteger> nestedList) {
		itr_stack = new Stack<>();
		Iterator<NestedInteger> nowIterator = nestedList.iterator();
		itr_stack.push(nowIterator);
	}


	@Override
	public Integer next() {
		return itr_stack.peek().next().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!itr_stack.isEmpty()) {
			Iterator<NestedInteger> topItr = itr_stack.peek();
			if (!topItr.hasNext()) {
				itr_stack.pop();
				continue;
			}

			NestedInteger nest = topItr.next();
			if (nest.isInteger()) {
				ArrayList<NestedInteger> list = new ArrayList<>(Collections.singletonList(nest));
				itr_stack.push(list.iterator());
				return true;
			}
			itr_stack.push(nest.getList().iterator());
		}
		return false;
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
