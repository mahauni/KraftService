package dataStructures;

import javaBeans.Action;

public class ListAction {
    private static class Node {
        private final Action data;
        private Node next;

        public Node(Action data) {
            this.data = data;
        }
    }

    private int length = 0;
    private Node first = null;
    private Node last = null;

    public void enqueue(Action data) {
        Node node = new Node(data);
        this.length += 1;
        if (first == null && last == null) {
            this.first = node;
            this.last = node;
            return;
        }

        this.last.next = node;
        this.last = node;
    }

    public Action dequeue() {
        Node node = this.first;

        if (this.first == null && this.last == null) {
            return null;
        }

        this.length -= 1;

        if (this.first == this.last) {
            this.first = null;
            this.last = null;
            return node.data;
        }

        assert this.first != null;
        this.first = this.first.next;
        node.next = null;

        return node.data;
    }

    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    public int length() {
        return this.length;
    }

    public void printActions() {
        Node curr = first;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
