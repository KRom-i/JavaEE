package homeWork3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private final int INCREASE = 2;

    public MyStack (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object [capacity];
    }

    public MyStack () {
        list = (T[]) new Object [DEFAULT_CAPACITY];
    }

    public T peek(){
        if (isEmpty ()){
            throw new EmptyStackException ();
        }
        return list[size - 1];
    }

    public void push(T item){
        if (isFull ()){
//          Расширение масcива
            increaseСapacity ();
        }
        list[size] = item;
        size++;
    }

    private void increaseСapacity () {
        list = Arrays.copyOf (list, getNewSize());
    }

    private int getNewSize(){
        return (size * INCREASE) + 1;
    }

    public T pop(){
        T temp = peek ();
        size--;
        list[size] = null;
        return temp;
    }

    public int size () {
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == list.length;
    }
}
