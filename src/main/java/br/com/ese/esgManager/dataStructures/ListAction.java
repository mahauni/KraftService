package br.com.ese.esgManager.dataStructures;

import br.com.ese.esgManager.javaBeans.jbAction;

public class ListAction {
    private static class Node {
        private final jbAction data;
        private Node next;

        public Node(jbAction data) {
            this.data = data;
        }
    }

    private int length = 0;
    private Node first = null;
    private Node last = null;

    public void enqueue(jbAction data) {
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

    public jbAction dequeue() {
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

    public jbAction peak() {
        return this.first.data;
    }

    public jbAction last() {
        return this.last.data;
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
