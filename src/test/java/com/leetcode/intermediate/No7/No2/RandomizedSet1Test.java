package com.leetcode.intermediate.No7.No2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedSet1Test {

    RandomizedSet1 set1 = new RandomizedSet1();

    @Test
    public void remove() {
        set1.remove(3);
        System.out.println("remove: " + set1);
    }

    @Test
    public void getRandom() {
        System.out.println(set1.getRandom());
    }

    @Before
    public void setUp() throws Exception {
        set1.insert(1);
        set1.insert(2);
        set1.insert(3);
        set1.insert(4);
        set1.insert(5);
        System.out.println("init: " + set1);
    }

    public static void main(String[] args) {
        RandomizedSet1 set1 = new RandomizedSet1();
        System.out.println(set1);
        System.out.println(set1.remove(0));
        System.out.println(set1);
        System.out.println(set1.remove(0));
        System.out.println(set1);
        System.out.println(set1.insert(0));
        System.out.println(set1);
        System.out.println(set1.getRandom());
        System.out.println(set1);
        System.out.println(set1.remove(0));
        System.out.println(set1);
        System.out.println(set1.insert(0));
        System.out.println(set1);
    }
}