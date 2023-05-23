package dataStructures;

import javaBeans.URL;

public class ListUrl {
    private static class Node {
        private final URL data;
        private Node  next;

        public Node(URL data) {
            this.data = data;
        }
    }

    private int length = 0;
    private Node first = null;
    private Node last = null;

    public void enqueue(URL data) {
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

    public URL dequeue() {
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

    public URL peak() {
        return this.first.data;
    }

    public URL last() {
        return this.last.data;
    }

    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    public int length() {
        return this.length;
    }
}
