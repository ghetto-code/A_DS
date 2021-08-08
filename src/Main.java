import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList();

        Node firstNodeForInsert = new Node(12);
        Node secondNodeForInsert = new Node(13);
        Node thirdNodeForInsert = new Node(14);
        Node fourthNodeForInsert = new Node(15);


        myLL.insertAfter(null, firstNodeForInsert);
        myLL.insertAfter(firstNodeForInsert,secondNodeForInsert);
        myLL.insertAfter(secondNodeForInsert,thirdNodeForInsert);
        myLL.insertAfter(secondNodeForInsert,fourthNodeForInsert);


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
