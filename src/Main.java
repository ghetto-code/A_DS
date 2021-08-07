public class Main {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList();
        myLL.addInTail(new Node(12));
        myLL.addInTail(new Node(13));
        myLL.addInTail(new Node(13));
        myLL.addInTail(new Node(14));
        myLL.addInTail(new Node(14));
        myLL.removeAll(14);

        for(int i: myLL.getAll()){
            System.out.println(i);
        }

        System.out.println(myLL.count());


    }
}
