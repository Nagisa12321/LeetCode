package com.leetcode.linkedlist.No1;

public class MyLinkedList2Test {
    public static void main(String[] args) {
        MyLinkedList2 a = new MyLinkedList2();
        a.addAtHead(0);
        a.addAtIndex(1, 4);
        a.addAtTail(8);
        a.addAtHead(5);
        a.addAtIndex(4, 3);
        a.addAtTail(0);
        a.addAtTail(5);
        a.addAtIndex(6, 3);
        a.deleteAtIndex(7);
        a.deleteAtIndex(5);
        a.addAtTail(4);
        System.out.println(a);
    }
}