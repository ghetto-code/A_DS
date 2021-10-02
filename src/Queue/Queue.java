package Queue;

import java.util.*;

public class Queue<T> {
    protected int size = 0;
    Node<T> head;
    Node<T> tail;
    public Queue() {
        head = null;
        tail = null;
        // инициализация внутреннего хранилища очереди
    }

    public void enqueue(T item) {
        Node node = new Node(item);
        if (this.head == null)
            this.head = node;
        else
            this.tail.next = node;
        this.tail = node;
        this.size++;
        // вставка в хвост
    }

    public T dequeue() {
        if (this.size > 0) {
            Node<T> node = this.head;
            Node swap = node.next;
            this.head = swap;
            this.size--;
            return  node.value;
        }
        return null; // null если очередь пустая
    }

    public int size() {
        return this.size;
    } // размер очереди

}
class Node<T> {
    public Node next;
    T value;
    public Node(T clz) {
        value = clz;
        next = null;
    }
}