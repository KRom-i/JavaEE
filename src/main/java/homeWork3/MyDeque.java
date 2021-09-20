package homeWork3;

public class MyDeque<T> {

    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private final int INCREASE = 2;
    private int begin;
    private int end;

    public MyDeque (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object [capacity];
    }

    public MyDeque () {
        list = (T[]) new Object [DEFAULT_CAPACITY];
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertRight(T item) {
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }
        size++;
        begin = prevIndex(begin);
        list[begin] = item;
    }

    public T removeRight() {
        T temp = peekRight();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeLeft() {
        T temp = peekLeft();
        size--;
        end = prevIndex(end);
        list[end] = null;
        return temp;
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return list[begin];
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return list[prevIndex(end)];
    }


    private int nextIndex(int index){
        return (index + 1) % list.length;
    }

    private int prevIndex(int index){
        return (list.length + index - 1) % list.length;
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
