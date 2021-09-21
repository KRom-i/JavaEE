package home_work_4;

public class LinkedQueue<T> {
    private MyLinkedList<T> list;

    public LinkedQueue () {
        this.list = new MyLinkedList<> ();
    }

    public T peekFront(){
        if (isEmpty()) {
            throw new RuntimeException("LinkedQueue is empty");
        }
        return list.getFirst ();
    }

    public T remove(){
        if (isEmpty()) {
            throw new RuntimeException("LinkedQueue is empty");
        }
        return list.removeFirst ();
    }

    public void insert(T item){
        list.insertLast (item);
    }

    public boolean isEmpty () {
        return list.isEmpty ();
    }


}
