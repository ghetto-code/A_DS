import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    LinkedList testLinkedListZERO = new LinkedList();
    LinkedList testLinkedListFULL = new LinkedList();
    LinkedList testLinkedListONE = new LinkedList();

    Node insertNodeOne = new Node(5);
    Node insertNodeFull = new Node(5);
    Node insertNodeZero = new Node(5);

    Node firstNodeOne = new Node(23);
    Node firstNodeFull = new Node(23);
    Node secondNodeFull = new Node(24);
    Node thirdNodeFull = new Node(25);
    Node fourthNodeFull = new Node(26);
    Node fifthNodeFull = new Node(23);
    Node sixNodeFull = new Node(23);
    Node seventhNodeFull = new Node(23);

    @BeforeEach
    public void createTestNodes() {

        testLinkedListFULL.addInTail(firstNodeFull);
        testLinkedListFULL.addInTail(secondNodeFull);
        testLinkedListFULL.addInTail(thirdNodeFull);
        testLinkedListFULL.addInTail(fourthNodeFull);
        testLinkedListONE.addInTail(firstNodeOne);
    }

    @Test
    @DisplayName("Function 'getAll'")
    void getAllTest() {
        ArrayList<Integer> testFULL = new ArrayList<>();
        testFULL.add(23);
        testFULL.add(24);
        testFULL.add(25);
        testFULL.add(26);
        ArrayList<Integer> testONE = new ArrayList<>();
        testONE.add(23);
        ArrayList<Integer> testZERO = new ArrayList<>();
        assertEquals(testFULL,testLinkedListFULL.getAll());
        assertEquals(testONE,testLinkedListONE.getAll());
        assertEquals(testZERO,testLinkedListZERO.getAll());
    }

    @Test
    @DisplayName("Function 'count'")
    void countTest() {
        assertEquals(4,testLinkedListFULL.count());
        assertEquals(1,testLinkedListONE.count());
        assertEquals(0,testLinkedListZERO.count());
    }

    @Test
    @DisplayName("Function 'clear'")
    void clearTest() {
        LinkedList linkedList = new LinkedList();
        testLinkedListZERO.clear();
        testLinkedListFULL.clear();
        testLinkedListONE.clear();
        assertEquals(linkedList.head,testLinkedListZERO.head);
        assertEquals(linkedList.tail,testLinkedListZERO.tail);
        assertEquals(linkedList.head,testLinkedListONE.head);
        assertEquals(linkedList.tail,testLinkedListONE.tail);
        assertEquals(linkedList.head,testLinkedListFULL.head);
        assertEquals(linkedList.tail,testLinkedListFULL.tail);
    }

    @Test
    @DisplayName("Function 'remove'")
    void removeTest() {
        LinkedList listOne = new LinkedList();
        LinkedList listTwo = new LinkedList();

        Node secondNodeFull = new Node(24);
        Node thirdNodeFull = new Node(25);
        Node fourthNodeFull = new Node(26);


        listTwo.addInTail(secondNodeFull);
        listTwo.addInTail(thirdNodeFull);
        listTwo.addInTail(fourthNodeFull);

        testLinkedListONE.remove(23);
        testLinkedListFULL.remove(23);
        testLinkedListZERO.remove(23);

        Node nodeA = listTwo.head;
        Node nodeB = testLinkedListFULL.head;
        boolean result = true;

        while (nodeA != null && nodeB != null) {
            if (nodeA.value != nodeB.value) {
                result = false;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        Node nodeC = testLinkedListONE.head;
        Node nodeD = listOne.head;
        while (nodeC != null && nodeD != null) {
            if (nodeC.value != nodeD.value) {
                result = false;
            }
            nodeC = nodeC.next;
            nodeD = nodeD.next;
        }
        Node nodeE = testLinkedListZERO.head;
        Node nodeF = listOne.head;
        while (nodeE != null && nodeF != null) {
            if (nodeE.value != nodeF.value) {
                result = false;
            }
            nodeE = nodeE.next;
            nodeF = nodeF.next;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Function 'removeAll'")
    void removeAllTest() {
        LinkedList listOne = new LinkedList();
        LinkedList listTwo = new LinkedList();
        LinkedList listThree = new LinkedList();

        Node firstNodeFull = new Node(23);
        Node secondNodeFull = new Node(24);
        Node thirdNodeFull = new Node(25);
        Node fourthNodeFull = new Node(26);

        Node remove_1 = new Node(5);
        Node remove_2 = new Node(5);
        Node remove_3 = new Node(5);
        Node remove_4 = new Node(5);
        Node remove_5 = new Node(5);
        Node remove_6 = new Node(5);
        Node remove_7 = new Node(5);

        listOne.addInTail(remove_7);

        listTwo.addInTail(remove_1);
        listTwo.addInTail(remove_2);
        listTwo.addInTail(firstNodeFull);
        listTwo.addInTail(secondNodeFull);
        listTwo.addInTail(remove_3);
        listTwo.addInTail(remove_4);
        listTwo.addInTail(thirdNodeFull);
        listTwo.addInTail(fourthNodeFull);
        listTwo.addInTail(remove_5);
        listTwo.addInTail(remove_6);


        listOne.removeAll(5);
        listTwo.removeAll(5);
        listThree.removeAll(5);

        Node nodeA = listTwo.head;
        Node nodeB = testLinkedListFULL.head;

        boolean result = true;

        while (nodeA != null && nodeB != null) {
            if (nodeA.value != nodeB.value) {
                result = false;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        Node nodeC = testLinkedListONE.head;
        Node nodeD = listOne.head;
        while (nodeC != null && nodeD != null) {
            if (nodeC.value != nodeD.value) {
                result = false;
            }
            nodeC = nodeC.next;
            nodeD = nodeD.next;
        }

        Node nodeE = testLinkedListZERO.head;
        Node nodeF = listThree.head;
        while (nodeE != null && nodeF != null) {
            if (nodeE.value != nodeF.value) {
                result = false;
            }
            nodeE = nodeE.next;
            nodeF = nodeF.next;
        }
        assertTrue(result);
    }

    @Test
    @DisplayName("Function 'find'")
    void findTest() {
        assertEquals(testLinkedListONE.find(23), firstNodeOne);
        assertEquals(testLinkedListFULL.find(23),firstNodeFull);
        assertNull(testLinkedListZERO.find(23));
    }

    @Test
    @DisplayName("Function 'findAll'")
    void findAllTest() {

        ArrayList<Node> firstRes = new ArrayList<>();
        firstRes.add(firstNodeOne);
        ArrayList<Node> secondRes = new ArrayList<>();
        secondRes.add(firstNodeFull);
        secondRes.add(fifthNodeFull);
        secondRes.add(sixNodeFull);
        secondRes.add(seventhNodeFull);
        testLinkedListFULL.addInTail(fifthNodeFull);
        testLinkedListFULL.addInTail(sixNodeFull);
        testLinkedListFULL.addInTail(seventhNodeFull);
        ArrayList<Node> thirdRes = new ArrayList<>();

        assertEquals(testLinkedListONE.findAll(23),firstRes);
        assertEquals(testLinkedListFULL.findAll(23),secondRes);
        assertEquals(testLinkedListZERO.findAll(23),thirdRes);



    }
    @Test
    @DisplayName("Function 'insertAfter'")
    void insertAfterTest() {
        ArrayList<Node> firstRes = new ArrayList<>();
        ArrayList<Node> secRes = new ArrayList<>();
        firstRes.add(firstNodeOne);
        firstRes.add(insertNodeOne);
        testLinkedListONE.insertAfter(firstNodeOne, insertNodeOne);
        Node x = testLinkedListONE.head;
        while (x != null){
            secRes.add(x);
            x = x.next;
        }
        assertEquals(secRes, firstRes);

        ArrayList<Node> thirdRes = new ArrayList<>();
        ArrayList<Node> fourthRes = new ArrayList<>();
        thirdRes.add(firstNodeFull);
        thirdRes.add(secondNodeFull);
        thirdRes.add(thirdNodeFull);
        thirdRes.add(insertNodeFull);
        thirdRes.add(fourthNodeFull);

        testLinkedListFULL.insertAfter(thirdNodeFull, insertNodeFull);
        Node z = testLinkedListFULL.head;
        while (z != null){
            fourthRes.add(z);
            z = z.next;
        }
        assertEquals(thirdRes, fourthRes);

        testLinkedListZERO.clear();
        ArrayList<Node> fifthRes = new ArrayList<>();
        ArrayList<Node> sixRes = new ArrayList<>();
        fifthRes.add(insertNodeZero);
        testLinkedListZERO.insertAfter(null, insertNodeZero);
        Node i = testLinkedListZERO.head;
        while (i != null){
            sixRes.add(i);
            i = i.next;
        }
        assertEquals(fifthRes, sixRes);
    }
}
