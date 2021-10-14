package DynArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;


public class DynArrayTest {

    DynArray<Integer> dynArrayNotFull = new DynArray<Integer>(Integer.class);
    DynArray<Integer> dynArrayFull = new DynArray<Integer>(Integer.class);
    DynArray<Integer> dynArraySuperFull = new DynArray<Integer>(Integer.class);


    @BeforeEach
    public void createTestNodes() {

        for (int i = 1; i < 13; i ++) {
            dynArrayNotFull.append(i);
        }

        for (int i = 1; i < 17; i ++) {
            dynArrayFull.append(i);
        }
        for (int i = 1; i < 19; i ++) {
            dynArraySuperFull.append(i);
        }
    }

    @Test
    @DisplayName("Function 'insert'")
    void insertTest() {
        dynArrayNotFull.insert(13,12);
        dynArrayFull.insert(17,16);

        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

        for (int i = 0; i < dynArrayNotFull.count; i ++) {
            Assertions.assertEquals(arr1[i], dynArrayNotFull.getItem(i));
        }
        Assertions.assertEquals(arr1.length, dynArrayNotFull.count);
        Assertions.assertEquals(16, dynArrayNotFull.capacity);
        for (int i = 0; i < dynArrayFull.count; i ++) {
            Assertions.assertEquals(arr2[i], dynArrayFull.getItem(i));
        }
        Assertions.assertEquals(arr2.length, dynArrayFull.count);
        Assertions.assertEquals(32,dynArrayFull.capacity);

        boolean fls = false;
        try {
            dynArrayNotFull.insert(666,55);
        } catch (ArrayIndexOutOfBoundsException e) {
            fls = true;
        }
        Assertions.assertTrue(fls);
    }

    @Test
    @DisplayName("Function 'remove'")
    void removeTest() {

        dynArraySuperFull.remove(18);
        dynArraySuperFull.remove(17);
        int [] arr = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        for (int i = 0; i < dynArraySuperFull.count; i ++) {
            Assertions.assertEquals(dynArraySuperFull.getItem(i),arr[i]);
        }
        Assertions.assertEquals(32,dynArraySuperFull.capacity);
        dynArraySuperFull.remove(16);
        int [] arr2 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        for (int i = 0; i < dynArraySuperFull.count; i ++) {
            Assertions.assertEquals(dynArraySuperFull.getItem(i),arr2[i]);
        }
        Assertions.assertEquals(21,dynArraySuperFull.capacity);

        boolean fls = false;
        try {
            dynArrayNotFull.remove(55);
        } catch (ArrayIndexOutOfBoundsException e) {
            fls = true;
        }
        Assertions.assertTrue(fls);

    }


}
