import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList();
        myLL.addInTail(new Node(12));
        myLL.addInTail(new Node(13));
        Node x = new Node(666);
        myLL.addInTail(x);
        myLL.addInTail(new Node(13));
        myLL.addInTail(new Node(14));
        myLL.addInTail(new Node(14));
        myLL.insertAfter(x,new Node(777));

        Node c = myLL.head;
        while (c!=null){
            System.out.println(c.value);
            c = c.next;
        }



    }


    public static ArrayList<Integer> getSumList(LinkedList a, LinkedList b) {
        ArrayList<Integer> result  = new ArrayList<>();
        if (a.count() == b.count()) {
            Node forA = a.head;
            Node forB = b.head;
            while (forA != null && forB != null) {
                result.add(forA.value + forB.value);
                forA = forA.next;
                forB = forB.next;
            }
        }

        return result;
    }
}
