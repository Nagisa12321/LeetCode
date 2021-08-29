package com.leetcode.hashmap.No1.No1;

public class MyHashSetTest {
    public static void main(String[] args) {
        MyHashSet2 set = new MyHashSet2();
        System.out.println(set);
        set.add(1);
        System.out.println(set);
        set.add(2);
        System.out.println(set);
        set.add(770);
        set.add(2);
        System.out.println(set);
        System.out.println(set.contains(770));
        set.add(770);
        System.out.println(set);
    }
}