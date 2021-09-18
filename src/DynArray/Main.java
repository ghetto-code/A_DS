package DynArray;

public class Main {


    public static void main(String[] args) {
        DynArray<Integer> dynArrayNotFull = new DynArray<Integer>(Integer.class);
        DynArray<Integer> dynArrayFull = new DynArray<Integer>(Integer.class);

//        for (int i = 1; i < 13; i ++) {
//            dynArrayNotFull.append(i);
//        }
        for (int i = 1; i < 16; i ++) {
            dynArrayFull.append(i);
        }

//        for (int i = 0; i < dynArrayNotFull.count; i ++) {
//            System.out.println(dynArrayNotFull.getItem(i));
//        }

        for (int i = 0; i < dynArrayFull.count; i ++) {
            System.out.println(dynArrayFull.getItem(i));
        }
        dynArrayFull.insert(16,15);
        System.out.println();
        System.out.println(dynArrayFull.capacity);
        System.out.println(dynArrayFull.count);
        dynArrayFull.insert(16,15);
        for (int i = 0; i < dynArrayFull.count; i ++) {
            System.out.println(dynArrayFull.getItem(i));
        }
        System.out.println();
        System.out.println(dynArrayFull.capacity);
        System.out.println(dynArrayFull.count);


    }

}
