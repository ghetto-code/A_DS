package DynArray;
import java.lang.reflect.Array;

public class DynArray<T> {
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);
        count = 0;
        makeArray(16);
    }



    public void makeArray(int new_capacity) {
        // array = (T[]) Array.newInstance(this.clazz, new_capacity);
        T[] arr;
        if (new_capacity < 16) {
            new_capacity = 16;
        }
        arr = (T[]) Array.newInstance(this.clazz, new_capacity);
        this.capacity = new_capacity;
        for (int i = 0; i < this.count; i++) {
            arr[i] = array[i];
        }
        this.array = arr;
    }

    public T getItem(int index) {
        if (0 <= index && index < this.count) {
            return this.array[index];
        }
        throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
    }

    public void append(T itm) {
        if (this.count + 1 > this.capacity) {
            this.makeArray(this.count * 2);
        }
        this.array[this.count] = itm;
        this.count++;
    }

    public void insert(T itm, int index) {
        if (index > this.count || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        if (this.count == 0 || index == this.count) {
           append(itm);
        } else {
            if (this.count == this.capacity) {
                this.makeArray(this.capacity * 2);
            }
            for (int i = this.count + 1; i > index; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.array[index] = itm;
            this.count ++;
        }
    }

    public void remove(int index) {
        if (this.count == 0) {
            throw new ArrayIndexOutOfBoundsException("Попытка удаления из пустого массива");
        }
        if (index > this.count || index < 0) {
           throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        if (index + 1 == this.count) {
           this.array[index] = null;
        } else {
            for (int i = index; i < this.count; i ++){
                this.array[i] = this.array[i + 1];
            }
        }

        if (this.count - 1 < this.capacity / 2) {
            int new_capacity = (int) (this.capacity / 1.5);
            this.makeArray(new_capacity);
        }
        this.count--;
    }

}
class Node {
    public int value;
    public Node(int _value) {
        value = _value;
    }
}