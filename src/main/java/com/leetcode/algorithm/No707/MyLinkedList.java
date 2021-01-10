package com.leetcode.algorithm.No707;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/28 19:45
 * @version 1.0
 ************************************************/
public class MyLinkedList {
    private Node head;
    private Node tail;
    public int len;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= 0 && index < len) {
            Node tmp = head;
            for (int i = 0; i < index; i++) tmp = tmp.next;
            return tmp.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            Node node = new Node(val);
            node.next = head;
            head.prev = node;
            head = head.prev;
        }
        len++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            Node node = new Node(val);
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        len++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) addAtHead(val);
        else if (index == len) addAtTail(val);
        else if (index > 0 && index < len) {
            Node tmp = head;
            for (int i = 0; i < index - 1; i++) tmp = tmp.next;
            Node tmp1 = tmp.next;
            Node node = new Node(val);
            tmp.next = node;
            node.prev = tmp;
            node.next = tmp1;
            tmp1.prev = node;
            len++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head != null) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
                len--;
            }
        } else if (index == len - 1) {
            if (head == null) ;
            else if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
                len--;
            }
        } else if (index > 0 && index < len - 1) {
            Node tmp = head;
            for (int i = 0; i < index - 1; i++) tmp = tmp.next;
            if (tmp.next.next == null) tmp.next = null;
            else {
                Node tmp1 = tmp.next.next;
                tmp.next = tmp1;
                tmp1.prev = tmp;
            }
            len--;
        }
    }

    public static class Node {
        public Node next;
        public Node prev;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node node = head;
        while (node != null) {
            if (node.next == null) builder.append(node.val).append("]");
            else builder.append(node.val).append(", ");
            node = node.next;
        }
        return builder.toString();
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