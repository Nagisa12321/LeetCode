package com.leetcode.linkedList.No1;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        a.addAtHead(7);
        a.addAtHead(2);
        a.addAtHead(1);
        a.addAtIndex(3,0);
        a.deleteAtIndex(2);
        a.addAtHead(6);
        a.addAtTail(4);
        System.out.println(a.get(4));
    }
}