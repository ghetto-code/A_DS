import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList();
        myLL.find(12);

        for(int i: myLL.getAll()){
            System.out.println(i);
        }

        System.out.println(myLL.count());


    }
}
