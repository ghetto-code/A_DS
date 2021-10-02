//package Stack;
//
//import LinkedList.LinkedList;
//
//public class FILOStack<T> extends LinkedList {
//    public Node<T> head;
//    public Node<T> tail;
//    protected int size;
//
//    public FILOStack() {
//        size = 0;
//        head = null;
//        tail = null;
//    }
//
//    public void push(T val) {
//        Node node = new Node(val);
//
//        if (this.head == null)
//            this.head = node;
//        else
//            this.tail.next = node;
//        this.tail = node;
//    }
//    public T pop() {
//
//
//        return
//    }
//}
//class universalNode<T> {
//    public Node next;
//    T value;
//    public universalNode(T clz) {
//        value = clz;
//        next = null;
//    }
//}