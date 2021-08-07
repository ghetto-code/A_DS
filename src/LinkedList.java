import java.util.*;

public class LinkedList {
     public Node head;
     public Node tail;

     public LinkedList() {
       head = null;
       tail = null;
     }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find (int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }
    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
     }

     public boolean remove(int _value) {
         try{
             Node prevEl = null;
             Node currentEl = this.head;
             Node nextEl = currentEl.next;
             if (currentEl == null){
                 return false;
             }
             if (currentEl.value == _value && this.count() == 1) {
                 head = null;
                 tail = null;
                 return true;
             }
             while (currentEl != null) {
                 if (currentEl == this.tail) {

                 }
                 if (currentEl.value == _value && currentEl == this.head) {
                     this.head = nextEl;
                     return true;
                 }
                 if (currentEl.value == _value && currentEl != tail) {
                     prevEl.next = nextEl;
                     return true;
                 }
                 if (currentEl.value == _value) {
                     prevEl.next = null;
                     tail = prevEl;
                     return true;
                 }
                 prevEl = currentEl;
                 currentEl = nextEl;
                 nextEl = nextEl.next;
             }
         } catch (NullPointerException e) {

         }

        // здесь будет ваш код удаления одного узла по заданному значению

        return false;
         // если узел был удалён
     }

     public void removeAll(int _value) {
         Node node = this.head;
         while (node != null) {
             if(node.value == _value){
                 this.remove(_value);
             }
             node = node.next;
         }
          // здесь будет ваш код удаления всех узлов по заданному значению
     }

     public void clear() {
      // здесь будет ваш код очистки всего списка
      this.head = null;
      this.tail = null;
     }

     public int count() {
        Node node = this.head;
        int qts = 0;
        while (node != null) {
            qts++;
            node = node.next;
        }
       return qts; // здесь будет ваш код подсчёта количества элементов в списке
     }

     public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
       // здесь будет ваш код вставки узла после заданного
         Node node = this.head;
        if (_nodeAfter == null) {
            this.head = _nodeToInsert;
        } else {
            while (node != null && node != _nodeAfter) {
                node = node.next;
            }
            Node x = node.next;
            node.next = _nodeToInsert;
            _nodeToInsert.next = x;
        }
       // если _nodeAfter = null,
       // добавьте новый элемент первым в списке      
     }
     public boolean isEquals(LinkedList a, LinkedList b) {
         if (a.count() != b.count()) {
             return false;
         } else {
             Node nodeA = a.head;
             Node nodeB = b.head;
             while (nodeA != null && nodeB != null) {
                 if (nodeA.value!=nodeB.value) {
                    return false;
                 }
                 nodeA = nodeA.next;
                 nodeB = nodeB.next;
             }
         }
         return true;
     }
     public ArrayList<Integer> getAll() {
         ArrayList<Integer> integers = new ArrayList<>();
         Node node = this.head;
         while (node != null) {
             integers.add(node.value);
             node = node.next;
         }
         return integers;
     }

}

class Node {
     public int value;
     public Node next;
     public Node(int _value) {
       value = _value;
       next = null;
     }
}

