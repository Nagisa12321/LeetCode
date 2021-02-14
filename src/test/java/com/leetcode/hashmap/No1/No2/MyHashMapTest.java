package com.leetcode.hashmap.No1.No2;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        System.out.println(map);
        map.put(1, 1);
        System.out.println(map);
        map.put(770, 2);
        System.out.println(map);
        System.out.println(map.get(770));
        map.remove(770);
        System.out.println(map);
    }
}