package com.leetcode.binarysearchtree.No3.No1;

import com.leetcode.binarysearchtree.No3.No2.Solution;
import com.leetcode.binarysearchtree.No3.No2.Solution2;
import org.junit.Test;

import static org.junit.Assert.*;

public class KthLargestTest {

	@Test
	public void test1() {
		KthLargest kth = new KthLargest(3, new int[]{4, 5, 8, 2});


		System.out.println(kth.add(3));
		System.out.println(kth.add(5));
		System.out.println(kth.add(10));
		System.out.println(kth.add(9));
		System.out.println(kth.add(4));


	}
}