package Queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue("part");
        queue.enqueue("part2");
        queue.enqueue(3);
        System.out.println(queue.size);
        System.out.println(queue.dequeue());
        System.out.println(queue.size);
        System.out.println(queue.dequeue());
        System.out.println(queue.size);
        System.out.println(queue.dequeue());
        System.out.println(queue.size);
        System.out.println(queue.dequeue());
    }
}
