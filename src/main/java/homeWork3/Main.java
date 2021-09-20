package homeWork3;

import java.util.Random;

public class Main {

    public static void main (String[] args) {
//        testStack();
//        testStackBracket();

//        testQueue();

//        testPriorityQueue();

//        System.out.println (revers ("123456789"));

//        testDeque();
    }

//    DEQUE
    private static void testDeque () {

        MyDeque<Integer> deque = new MyDeque<> ();

        int a = 5;

        for (int i = 0; i < a; i++) {
            deque.insertLeft (i + 1);
        }

        for (int i = 0; i < a; i++) {
            System.out.print (deque.removeLeft () + " ");
        }
    }

//    STRING REVERS
    private static String revers(String str){

        char[] chars = str.toCharArray ();

        MyStack<Character> stack = new MyStack<> ();

        for (char c : chars) {
            stack.push (c);
        }

        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop ();
        }

        return String.valueOf (chars);
    }

//    PRIORITY QUEUE
    private static void testPriorityQueue () {

        int a = 25;

        MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<> ();

        for (int i = 0; i < a; i++) {
            priorityQueue.insert (new Random ().nextInt (100));
        }

        for (int j = 0; j < a; j++) {
            System.out.print(priorityQueue.remove () + " ");
        }
    }

//    QUEUE
    private static void testQueue () {

        MyQueue<String> queue = new MyQueue<> (2);

        //        ---------------------------------------------------------------------

        System.out.println (queue); // list = [ null, null, ]

        queue.insert ("A-1");
        System.out.println (queue); // list = [ A-1, null, ]

        queue.insert ("A-2");
        System.out.println (queue); // list = [ A-1, A-2, ]

        queue.insert ("A-3");
        System.out.println (queue); // list = [ A-1, A-2, A-3, null, null, ]

        //        ---------------------------------------------------------------------

        int y = 2;

        System.out.print("REMOVE - [" + y + "] "); // REMOVE - [2] A-1 A-2

        for (int j = 0; j < y; j++) {
            System.out.print(queue.remove () + " ");
        }

        System.out.println ();


        //        ---------------------------------------------------------------------

        queue.insert ("B-1");
        System.out.println (queue); // list = [ null, null, A-3, B-1, null, ]

        queue.insert ("B-2");
        System.out.println (queue); // list = [ null, null, A-3, B-1, B-2, ]

        queue.insert ("B-3");
        System.out.println (queue); // list = [ B-3, null, A-3, B-1, B-2, ]


        queue.insert ("C-1");
        System.out.println (queue); // list = [ B-3, C-1, A-3, B-1, B-2, ]

        //        ---------------------------------------------------------------------

        queue.insert ("C-2");
        System.out.println (queue); // list = [ A-3, B-1, B-2, B-3, C-1, C-2, null, null, null, null, null, ]

        queue.insert ("C-3");
        System.out.println (queue); // list = [ A-3, B-1, B-2, B-3, C-1, C-2, C-3, null, null, null, null, ]

        //        ---------------------------------------------------------------------

        y = queue.size ();

        System.out.print("REMOVE - [" + y + "] ");   // REMOVE - [7] A-3 B-1 B-2 B-3 C-1 C-2 C-3

        for (int j = 0; j < y; j++) {
            System.out.print(queue.remove () + " ");
        }

        //        ---------------------------------------------------------------------

        System.out.println (queue); // list = [ null, null, null, null, null, null, null, null, null, null, null, ]


    }

//    STACK
    private static void testStackBracket () {
        Expression e = new Expression ("{}+()+[]");
        System.out.println (e.checkBracket ());

        e = new Expression ("{}+()+[");
        System.out.println (e.checkBracket ());

        e = new Expression ("{+()+[]");
        System.out.println (e.checkBracket ());
    }

    private static void testStack(){

        int i = 25;

        MyStack<Integer> stack = new MyStack<> ();

        for (int j = 0; j < i; j++) {
            stack.push (j + 1);
        }

        for (int j = 0; j < i; j++) {
            System.out.print(stack.pop () + " ");
        }
    }
}
