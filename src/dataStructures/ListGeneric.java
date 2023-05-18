package dataStructures;

public class ListGeneric<T> {
    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;

    public void enqueue(T data) {
        Node<T> node = new Node<T>(data);
        if (first == null && last == null) {
            this.first = node;
            this.last = node;
            return;
        }

        this.last.next = node;
        this.last = node;
    }

    public T dequeue() {
        Node<T> node = this.first;

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
