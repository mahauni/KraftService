package dataStructures;

import javaBeans.Profile;

public class ListProfile {
    private static class Node {
        private final Profile data;
        private Node  next;

        public Node(Profile data) {
            this.data = data;
        }
    }

    private int length = 0;
    private Node first = null;
    private Node last = null;

    public void enqueue(Profile data) {
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

    public Profile dequeue() {
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

    public Profile peak() {
        return this.first.data;
    }

    public Profile last() {
        return this.last.data;
    }

    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    public int length() {
        return this.length;
    }
}
