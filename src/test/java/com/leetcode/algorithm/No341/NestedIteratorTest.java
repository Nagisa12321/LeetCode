package com.leetcode.algorithm.No341;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedIteratorTest {
	@Test
	public void test1() {

		ArrayList<NestedInteger> list = new ArrayList<>();

		NestedIntegerImpl nest1 = new NestedIntegerImpl(1);
		NestedIntegerImpl nest2 = new NestedIntegerImpl(1);

		NestedIntegerImpl list_0 = new NestedIntegerImpl(Arrays.asList(nest1, nest2));
		list.add(list_0);

		NestedIntegerImpl list_1 = new NestedIntegerImpl(2);
		list.add(list_1);

		NestedIntegerImpl list_2 = new NestedIntegerImpl(Arrays.asList(nest1, nest2));
		list.add(list_2);


		NestedIterator iterator = new NestedIterator(list);

		while (iterator.hasNext()) {
			iterator.next();
		}

	}

	@Test
	public void test2() {
		ArrayList<NestedInteger> list = new ArrayList<>();

		NestedIntegerImpl nestedInteger = new NestedIntegerImpl(new ArrayList<>());

		list.add(nestedInteger);

		NestedIterator iterator = new NestedIterator(list);

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}

class NestedIntegerImpl implements NestedInteger {

	private ArrayList<NestedInteger> list = null;
	private int val = 0;
	private boolean isInteger = false;

	public NestedIntegerImpl(int val) {
		isInteger = true;
		this.val = val;
	}

	public NestedIntegerImpl(List<NestedInteger> list) {
		this.list = new ArrayList<>();
		this.list.addAll(list);
	}

	@Override
	public boolean isInteger() {
		return isInteger;
	}

	@Override
	public Integer getInteger() {
		return val;
	}

	@Override
	public List<NestedInteger> getList() {
		return list;
	}
}