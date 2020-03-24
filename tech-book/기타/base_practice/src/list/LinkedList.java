package list;

import java.util.Comparator;

/**
 * LinkedList
 */

class Node {
    Object data;
    Node next;

    Node(Object data) {
        this.data = data;
        this.next = null;
    }

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

}

public class LinkedList {

    private Node head;
    private Node crnt;

    public LinkedList() {
        head = crnt = null;
    }

    public Object search(Object input, Comparator<? super Object> c) {
        Node ptr = head;

        while (ptr != null) {
            if (c.compare(input, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void addFirst(Object input) {
        Node ptr = head;
        head = crnt = new Node(input, ptr);
    }

    public void addLast(Object input) {
        if (head == null) {
            addFirst(input);
        } else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;

            }
            ptr.next = crnt = new Node(input, null);
        }

    }

    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node ptr = head;
                Node pre = head;

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node("헤드");
        ll.head.next = new Node("첫번째", null);
    }

}