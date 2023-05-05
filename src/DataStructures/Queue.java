package DataStructures;

import JavaBeans.Problem;

public class Queue {
    private static class Node {
        private final Problem data;
        private Node  next;

        public Node(Problem data) {
            this.data = data;
        }
    }

    private Node first = null;
    private Node last = null;

    public void enqueue(Problem data) {
        Node node = new Node(data);
        if (first == null && last == null) {
            this.first = node;
            this.last = node;
        }

        this.last.next = node;
        this.last = node;
    }

    public Problem dequeue() {
        Node node = this.first;

        if (this.first == null && this.last == null) {
            return null;
        }

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
}
