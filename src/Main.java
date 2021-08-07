import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList();
        myLL.addInTail(new Node(12));
        myLL.addInTail(new Node(13));
        myLL.addInTail(new Node(13));
        myLL.addInTail(new Node(14));
        myLL.addInTail(new Node(14));

        LinkedList myLL2 = new LinkedList();
        myLL2.addInTail(new Node(1));
        myLL2.addInTail(new Node(2));
        myLL2.addInTail(new Node(3));
        myLL2.addInTail(new Node(4));
        myLL2.addInTail(new Node(0));


        for (Integer x: getSumList(myLL,myLL2)) {
            System.out.println(x);
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
