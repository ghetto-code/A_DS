package Deque;

public class Main {
    public static void main(String[] args){
        Deque<Integer> deque = new Deque<Integer>();

        deque.addFront(12);
        deque.addFront(13);
        deque.addFront(14);

        Node node = deque.head;
        while (node != null){
            System.out.println(node.value);
            node = node.next;
        }
        deque.removeTail();
        deque.removeTail();

        Node node2 = deque.tail;
        while (node2 != null){
            System.out.println(node2.value);
            node2 = node2.prev;
        }


    }
}
