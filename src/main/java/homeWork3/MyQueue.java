package homeWork3;

import java.util.Arrays;

import static java.util.Objects.isNull;

public class MyQueue<T> {

    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private final int INCREASE = 2;
    private int begin;
    private int end;

    public MyQueue (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object [capacity];
    }

    public MyQueue () {
        list = (T[]) new Object [DEFAULT_CAPACITY];
    }

    public T peekFront(){
        if (isEmpty ()){
            throw new RuntimeException ("Queue is empty");
        }
        return list[begin];
    }

    public void insert(T item){
        if (isFull ()){
//            Расширение массива
            increaseСapacity ();
        }
        size++;
        list[end] = item;
        end = nextIndex (end);
    }

    private void increaseСapacity () {

        if (begin == end && begin > 0){

            T[] tempBegin = Arrays.copyOfRange (list, begin, list.length);
            T[] tempEnd = Arrays.copyOfRange (list, 0, begin);

            list = Arrays.copyOf (tempBegin, getNewSize());
            System.arraycopy(tempEnd, 0, list, tempBegin.length, tempEnd.length);

            begin = 0;

        } else {
            list = Arrays.copyOf (list, getNewSize());
        }
        end = size;
    }

    private int getNewSize(){
        return (size * INCREASE) + 1;
    }

    public T remove(){
        T temp = peekFront ();
        size--;
        list[begin] = null;
        begin = nextIndex (begin);
        return temp;
    }

    private int nextIndex(int index){
        return (index + 1) % list.length;
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


    @Override
    public String toString () {

        String str = String.format ("Demo - length: %s / size: %s / begin: %s / end: %s //",
                list.length, size, begin, end);

        StringBuilder sb = new StringBuilder ();

        for (T t : list) {
            if (!isNull (t)){
                sb.append (t.toString ()).append (", ");
            } else {
                sb.append ("null, ");
            }

        }

        return str + " list = [ " + sb.toString () + "]";
    }


}
