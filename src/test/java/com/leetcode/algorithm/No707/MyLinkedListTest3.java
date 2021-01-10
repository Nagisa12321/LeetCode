package com.leetcode.algorithm.No707;

import static org.junit.Assert.*;

public class MyLinkedListTest3 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(2);

        list.deleteAtIndex(1);
        list.addAtHead(2);
        list.addAtHead(7);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(5);
        list.addAtHead(5);
        System.out.println(list.get(5));
        list.deleteAtIndex(6);
        list.deleteAtIndex(4);
    }
}