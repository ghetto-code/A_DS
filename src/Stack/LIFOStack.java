package Stack;

public class LIFOStack<T> {
    Node<T> head;
    Node<T> tail;
    protected int count = 0;

    public LIFOStack() {
        tail = null;
        head = null;
    }

    public int size() {
        return this.count;
    }

    public T pop() {
        // ваш код
        Node node = this.head;

        if(this.count > 1) {
            while (node.next != this.tail) {
                node = node.next;
            }
            Node <T> swap= node.next;
            node.next = null;
            this.tail = node;
            this.count--;
            return swap.value;
        } else if (this.count == 1) {
            Node<T> swap = node;
            this.tail = null;
            this.head = null;
            this.count--;
            return swap.value;
        }
        return null;
    }

    public void push(T val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.tail = node;
        } else {
            node.next = this.head;
        }
        this.head = node;
        this.count++;
    }

    public T peek() {
        if(this.count > 0){
            return this.tail.value;
        }
        return  null; // если стек пустой
    }
}


