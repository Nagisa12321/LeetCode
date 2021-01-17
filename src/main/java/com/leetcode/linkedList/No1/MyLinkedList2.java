package com.leetcode.linkedList.No1;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/11/28 13:35
 * @version 1.0
 ************************************************/
public class MyLinkedList2 {
    static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > length - 1) return -1;
        Node tmp = head;
        for (int i = 0; i < index; ++i) {
            tmp = tmp.next;
        }
        return tmp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            length++;
        } else {
            Node newhead = new Node(val);
            newhead.next = head;
            head = newhead;
            length++;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) return;
        if (index == 0) addAtHead(val);
        if (index == length) addAtTail(val);
        else {
            Node tmp = head;
            for (int i = 0; i < index - 1; ++i) {
                tmp = tmp.next;
            }
            Node node = new Node(val);
            node.next = tmp.next;
            tmp.next = node;
            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > length - 1) return;
        if (index == 0) head = head.next;
        else {
            Node tmp = head;
            for (int i = 0; i < index - 1; ++i) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            if (index == length - 1) tail = tmp;
        }
        length--;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node tmp = head;
        while (tmp != null) {
            stringBuilder.append(tmp.val + ", ");
            tmp = tmp.next;
        }
        stringBuilder.append("\b\b ]");
        return stringBuilder.toString();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

