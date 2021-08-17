package LinkedList2;

import java.util.ArrayList;

import LinkedList.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedList2Test {

    // Пустой список

    LinkedList2 testLinkedListZERO = new LinkedList2();

    // Список с одним элементом

    LinkedList2 testLinkedListONE = new LinkedList2();
    Node firstNodeOne = new Node(23);

    // Список с несколькими элементами

    LinkedList2 testLinkedListFULL = new LinkedList2();
    Node firstNodeFull = new Node(23);
    Node secondNodeFull = new Node(24);
    Node thirdNodeFull = new Node(25);
    Node fourthNodeFull = new Node(23);
    Node fifthNodeFull = new Node(28);
    Node sixNodeFull = new Node(23);
    Node seventhNodeFull = new Node(23);
    Node eighthNodeFull = new Node(27);

    // Узлы для проверки

    // для пустого списка

    Node insertNodeZero = new Node(5);

    // для списка с одним узлом

    Node insertNodeOne = new Node(5);

    // для списка с несколькими узлами

    Node insertNodeFull = new Node(5);


    // Перед каждым тестом заполняем списки узлами

    @BeforeEach
    public void createTestNodes() {
        testLinkedListFULL.addInTail(firstNodeFull);
        testLinkedListFULL.addInTail(secondNodeFull);
        testLinkedListFULL.addInTail(thirdNodeFull);
        testLinkedListFULL.addInTail(fourthNodeFull);
        testLinkedListFULL.addInTail(fifthNodeFull);
        testLinkedListFULL.addInTail(sixNodeFull);
        testLinkedListFULL.addInTail(seventhNodeFull);
        testLinkedListFULL.addInTail(eighthNodeFull);

        testLinkedListONE.addInTail(firstNodeOne);
    }


    @Test
    @DisplayName("Function 'find'")
    void findTest() {
        assertEquals(testLinkedListONE.find(23), firstNodeOne);
        assertEquals(testLinkedListFULL.find(23), firstNodeFull);
        assertNull(testLinkedListZERO.find(23));
    }

    @Test
    @DisplayName("Function 'findAll'")
    void findAllTest() {

        ArrayList<Node> firstRes = new ArrayList<>();
        firstRes.add(firstNodeOne);
        ArrayList<Node> secondRes = new ArrayList<>();
        secondRes.add(firstNodeFull);
        secondRes.add(seventhNodeFull);
        secondRes.add(sixNodeFull);
        secondRes.add(fourthNodeFull);

        ArrayList<Node> thirdRes = new ArrayList<>();

        assertEquals(testLinkedListONE.findAll(23), firstRes);
        assertEquals(testLinkedListFULL.findAll(23), secondRes);
        assertEquals(testLinkedListZERO.findAll(23), thirdRes);
    }

    @Test
    @DisplayName("Function 'remove'")
    void remove() {

        LinkedList2 oneRes = new LinkedList2();

        LinkedList2 fullRes = new LinkedList2();
        fullRes.addInTail(secondNodeFull);
        fullRes.addInTail(thirdNodeFull);
        fullRes.addInTail(fourthNodeFull);
        fullRes.addInTail(fifthNodeFull);
        fullRes.addInTail(sixNodeFull);
        fullRes.addInTail(seventhNodeFull);

        LinkedList2 zeroRes = new LinkedList2();

        testLinkedListONE.remove(23);
        Node oneHead = testLinkedListONE.head;
        Node oneHeadRes = oneRes.head;
        while (oneHead != null && oneHeadRes != null) {
            assertEquals(oneHead, oneHeadRes);
            oneHead = oneHead.next;
            oneHeadRes = oneHeadRes.next;

        }
        assertTrue(oneHead == null && oneHeadRes == null);

        testLinkedListZERO.remove(23);
        Node zeroHead = testLinkedListZERO.head;
        Node zeroHeadRes = oneRes.head;
        while (zeroHead != null && zeroHeadRes != null) {
            assertEquals(zeroHead, zeroHeadRes);
            zeroHead = zeroHead.next;
            zeroHeadRes = zeroHeadRes.next;

        }
        assertTrue(zeroHead == null && zeroHeadRes == null);


        testLinkedListFULL.remove(23);
        Node fullHead = testLinkedListFULL.head;
        Node fullHeadRes = fullRes.head;
        while (fullHead != null && fullHeadRes != null) {
            assertEquals(fullHead, fullHeadRes);
            fullHead = fullHead.next;
            fullHeadRes = fullHeadRes.next;

        }
        assertTrue(fullHead == null && fullHeadRes == null);
    }

    @Test
    @DisplayName("Function 'removeAll'")
    void removeAll() {
        LinkedList2 oneRes = new LinkedList2();

        LinkedList2 fullRes = new LinkedList2();
        fullRes.addInTail(secondNodeFull);
        fullRes.addInTail(thirdNodeFull);
        fullRes.addInTail(fifthNodeFull);
        fullRes.addInTail(eighthNodeFull);


        LinkedList2 zeroRes = new LinkedList2();


        testLinkedListONE.removeAll(23);
        Node oneHead = testLinkedListONE.head;
        Node oneHeadRes = oneRes.head;
        while (oneHead != null && oneHeadRes != null) {
            assertEquals(oneHead, oneHeadRes);
            oneHead = oneHead.next;
            oneHeadRes = oneHeadRes.next;

        }
        assertTrue(oneHead == null && oneHeadRes == null);

        testLinkedListZERO.removeAll(23);
        Node zeroHead = testLinkedListZERO.head;
        Node zeroHeadRes = oneRes.head;
        while (zeroHead != null && zeroHeadRes != null) {
            assertEquals(zeroHead, zeroHeadRes);
            zeroHead = zeroHead.next;
            zeroHeadRes = zeroHeadRes.next;

        }
        assertTrue(zeroHead == null && zeroHeadRes == null);


        testLinkedListFULL.removeAll(23);
        Node fullHead = testLinkedListFULL.head;
        Node fullHeadRes = fullRes.head;
        while (fullHead != null && fullHeadRes != null) {
            assertEquals(fullHead, fullHeadRes);
            fullHead = fullHead.next;
            fullHeadRes = fullHeadRes.next;

        }
        assertTrue(fullHead == null && fullHeadRes == null);


    }

    @Test
    @DisplayName("Function 'clear'")
    void clear() {

        testLinkedListFULL.clear();
        testLinkedListONE.clear();
        testLinkedListZERO.clear();

        assertNull(testLinkedListZERO.head);
        assertNull(testLinkedListZERO.tail);
        assertNull(testLinkedListFULL.head);
        assertNull(testLinkedListFULL.tail);
        assertNull(testLinkedListONE.head);
        assertNull(testLinkedListONE.tail);
    }

    @Test
    @DisplayName("Function 'count'")
    void count() {
        assertEquals(testLinkedListZERO.count(),0);
        assertEquals(testLinkedListONE.count(),1);
        assertEquals(testLinkedListFULL.count(),8);
    }
    @Test
    @DisplayName("Function 'insertAfter'")
    void insertAfter() {
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
        thirdRes.add(fifthNodeFull);
        thirdRes.add(sixNodeFull);
        thirdRes.add(seventhNodeFull);
        thirdRes.add(eighthNodeFull);

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