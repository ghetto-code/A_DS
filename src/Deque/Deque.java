package Deque;
import java.util.*;

public class Deque<T> {
    public Node head;
    public Node tail;
    public int count;

    public Deque() {
        // инициализация внутреннего хранилища
        count = 0;
        head = null;
        tail = null;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }
    public void addFront(T item) {
        // добавление в голову

        Node<T> node = new Node<T>(item);
        if (head == null) {
            this.tail = node;
            this.tail.next = null;
            this.tail.prev = null;
        } else {
            this.head.prev = node;
            node.next = this.head;
        }
        this.head = node;
        this.count++;
    }

    public void addTail(T item) {
        // добавление в хвост

        Node<T> node = new Node<T>(item);
        if (head == null) {
            this.head = node;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
        this.count++;
    }

    public T removeFront() {
        // удаление из головы

        if (this.count == 0) {
            return null;
        } else if (this.count > 0) {
            Node node = this.head;
            if (this.count == 1) {
                this.clear();
                this.count--;
                return (T) node.value;
            }
            Node swap = node.next;
            this.head = swap;
            swap.prev = null;
            this.count--;
            return (T) node.value;
        }
        return null;

    }

    public T removeTail() {
        // удаление из хвоста

        if (this.count == 0) {
         return null;
        } else if (this.count > 0) {
            Node node = this.tail;
            if(this.count == 1){
                this.count--;
                this.clear();
                return (T) node.value;
            }

            Node swap = node.prev;
            this.tail = swap;
            this.count--;
            return (T) node.value;
        }
        return null;
    }

    public int size() {
        return this.count; // размер очереди
    }
}
class Node<T> {
    public Node next;
    public Node prev;
    T value;
    public Node(T clz) {
        value = clz;
        next = null;
        prev = null;
    }
}