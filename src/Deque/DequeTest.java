package Deque;
import LinkedList2.LinkedList2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.util.LinkedList;


public class DequeTest {
    // Пустой список

    Deque testDequeZERO = new Deque();

    // Список с одним элементом

    Deque testDequeONE = new Deque();
    String firstStrOne = "FirstStringOne";

    // Список с несколькими элементами

    Deque testDequeFULL = new Deque();
    String firstStrFull = "FirstStringFull";
    String secondStrFull = "SecondStringFull";
    String thirdStrFull = "ThirdStringFull";

    // для пустого дека
    String insertZero = "insertZero";

    // для дека с одним узлом
    String insertOne = "insertOne";

    // для дека с несколькими узлами
    String insertFull = "insertFull";


    @BeforeEach
    public void before() {
        testDequeONE.addTail(firstStrOne);
        testDequeFULL.addTail(firstStrFull);
        testDequeFULL.addTail(secondStrFull);
    }


    @Test
    @DisplayName("addTailTest")
    public void addTailTest() {
        testDequeZERO.addTail(insertZero);
        Assertions.assertEquals(testDequeONE.count,1);
        Node nodeZero = testDequeZERO.head;
        Assertions.assertEquals(nodeZero.value, insertZero);

        testDequeONE.addTail(insertOne);
        Assertions.assertEquals(testDequeONE.count, 2);
        Node nodeOne = testDequeONE.head;
        Assertions.assertEquals(nodeOne.value, firstStrOne);
        nodeOne = nodeOne.next;
        Assertions.assertEquals(nodeOne.value, insertOne);

        testDequeFULL.addTail(insertFull);
        Assertions.assertEquals(testDequeFULL.count, 3);
        Node nodeFull = testDequeFULL.head;
        Assertions.assertEquals(nodeFull.value,firstStrFull);
        nodeFull = nodeFull.next;
        Assertions.assertEquals(nodeFull.value,secondStrFull);
        nodeFull = nodeFull.next;
        Assertions.assertEquals(nodeFull.value,insertFull);

    }

    @Test
    @DisplayName("addFrontTest")
    public void addFrontTest() {
        testDequeZERO.addFront(insertZero);
        Assertions.assertEquals(testDequeONE.count,1);
        Node nodeZero = testDequeZERO.tail;
        Assertions.assertEquals(nodeZero.value, insertZero);

        testDequeONE.addFront(insertOne);
        Assertions.assertEquals(testDequeONE.count, 2);
        Node nodeOne = testDequeONE.tail;
        Assertions.assertEquals(nodeOne.value, firstStrOne);
        nodeOne = nodeOne.prev;
        Assertions.assertEquals(nodeOne.value, insertOne);

        testDequeFULL.addFront(insertFull);
        Assertions.assertEquals(testDequeFULL.count, 3);
        Node nodeFull = testDequeFULL.tail;
        Assertions.assertEquals(nodeFull.value,secondStrFull);
        nodeFull = nodeFull.prev;
        Assertions.assertEquals(nodeFull.value,firstStrFull);
        nodeFull = nodeFull.prev;
        Assertions.assertEquals(nodeFull.value,insertFull);
    }

    @Test
    @DisplayName("removeFrontTest")
    public void removeFrontTest() {
        Assertions.assertNull(testDequeZERO.removeFront());

        Assertions.assertEquals(testDequeONE.removeFront(), firstStrOne);
        Assertions.assertEquals(testDequeONE.count, 0);
        Assertions.assertNull(testDequeONE.head);
        Assertions.assertNull(testDequeONE.tail);

        Assertions.assertEquals(testDequeFULL.removeFront(), firstStrFull);
        Assertions.assertEquals(testDequeFULL.count, 1);
        Assertions.assertEquals(testDequeFULL.head.value, secondStrFull);
        Assertions.assertEquals(testDequeFULL.tail.value, secondStrFull);
    }
    @Test
    @DisplayName("removeTailTest")
    public void removeTailTest() {
        Assertions.assertNull(testDequeZERO.removeTail());

        Assertions.assertEquals(testDequeONE.removeTail(), firstStrOne);
        Assertions.assertEquals(testDequeONE.count, 0);
        Assertions.assertNull(testDequeONE.head);
        Assertions.assertNull(testDequeONE.tail);

        Assertions.assertEquals(testDequeFULL.removeTail(), secondStrFull);
        Assertions.assertEquals(testDequeFULL.count, 1);
        Assertions.assertEquals(testDequeFULL.head.value, firstStrFull);
        Assertions.assertEquals(testDequeFULL.tail.value, firstStrFull);
    }





}
