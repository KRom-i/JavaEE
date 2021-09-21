package home_work_4;

public class Main {

    public static void main (String[] args) {
        testLinkedList();

//            testLinkedQueue ();
    }

    private static void testLinkedQueue () {

        LinkedQueue<Integer> linkedQueue = new LinkedQueue<> ();

        int i = 20;

        for (int j = 0; j < i; j++) {
            linkedQueue.insert (j + 1);
        }

        for (int j = 0; j < i; j++) {
            System.out.print (linkedQueue.remove () + " ");
        }

        System.out.println ("\n" + linkedQueue.isEmpty ());

    }

    private static void testLinkedList () {

        MyLinkedList<Integer> list = new MyLinkedList<> ();

        for (int i = 0; i < 10; i++) {
            list.insertLast ( i + 1);
        }

        System.out.println (list);

        System.out.println (list.indexOf (1));
        System.out.println (list.indexOf (5));
        System.out.println (list.indexOf (10));
        System.out.println (list.indexOf (13));

    }

}
