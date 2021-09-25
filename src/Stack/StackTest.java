package Stack;
import java.util.ArrayList;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {
    Stack testStackZERO = new Stack();

    // Список с одним элементом

    Stack testStackONE = new Stack();
    int firstOne = 1;
    // Список с несколькими элементами

    Stack testStackFULL = new Stack();
    int firstFull = 1;
    int secondFull = 2;
    int thirdFull = 3;
    int fourthFull = 4;

    // Узлы для проверки:

        // для пустого списка

    int insertZero = 5;

        // для списка с одним узлом

    int insertOne = 5;

        // для списка с несколькими узлами

    int insertFull = 5;
    @BeforeEach
    public void createTestNodes() {
        testStackONE.push(firstOne);

        testStackFULL.push(firstFull);
        testStackFULL.push(secondFull);
        testStackFULL.push(thirdFull);
        testStackFULL.push(fourthFull);
    }

    @Test
    @DisplayName("Function 'push'")
    void pushTest() {
        ArrayList<Integer> zeroRes = new ArrayList<>();
        zeroRes.add(insertZero);

        ArrayList<Integer> oneRes = new ArrayList<>();
        oneRes.add(firstOne);
        oneRes.add(insertOne);

        ArrayList<Integer> fullRes = new ArrayList<>();
        fullRes.add(firstFull);
        fullRes.add(secondFull);
        fullRes.add(thirdFull);
        fullRes.add(fourthFull);
        fullRes.add(insertFull);

        testStackZERO.push(insertZero);
        testStackONE.push(insertOne);
        testStackFULL.push(insertFull);

        Node zeroHead = testStackZERO.head;
        int countZ = 0;
        while (countZ < zeroRes.size() && zeroHead != null) {
            assertEquals(zeroHead.value,zeroRes.get(countZ));
            zeroHead = zeroHead.next;
            countZ++;
        }

        Node oneHead = testStackONE.head;
        int countO = 0;
        while (countO < oneRes.size() && oneHead != null ) {
            assertEquals(oneHead.value,oneRes.get(countO));
            oneHead = oneHead.next;
            countO++;
        }
        Node fullHead = testStackFULL.head;
        int countF = 0;
        while (countF < fullRes.size() && fullHead != null ) {
            assertEquals(fullHead.value,fullRes.get(countF));
            fullHead = fullHead.next;
            countF++;
        }

    }

    @Test
    @DisplayName("Function 'pop'")
    void popTest() {

        ArrayList<Integer> fullRes = new ArrayList<>();
        fullRes.add(firstFull);
        fullRes.add(secondFull);
        fullRes.add(thirdFull);

        assertEquals(testStackZERO.pop(),null);

        testStackONE.pop();
        assertEquals(testStackONE.pop(),null);

        testStackFULL.pop();
        Node fullHead = testStackFULL.head;
        int countF = 0;
        while (countF < fullRes.size() && fullHead != null ) {
            assertEquals(fullHead.value,fullRes.get(countF));
            fullHead = fullHead.next;
            countF++;
        }
    }

    @Test
    @DisplayName("Function 'size'")
    void sizeTest() {
        assertEquals(testStackZERO.size(),0);
        assertEquals(testStackONE.size(),1);
        assertEquals(testStackFULL.size(),4);
    }

    @Test
    @DisplayName("Function 'peek'")
    void peekTest() {
        assertNull(testStackZERO.peek());
        assertEquals(testStackONE.peek(),1);
        assertEquals(testStackFULL.peek(),4);
    }
}
