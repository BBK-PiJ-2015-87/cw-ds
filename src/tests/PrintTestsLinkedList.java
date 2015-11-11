package tests;

import impl.LinkedList;
import impl.Node;

/**
 * Created by vladimirsivanovs on 09/11/2015.
 */
public class PrintTestsLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("ADDED: " + list.add(0, "zero"));
        System.out.println("ADDED: " + list.add("one"));
        System.out.println("ADDED: " + list.add("two"));
        System.out.println("ADDED: " + list.add("three"));
        System.out.println("ADDED: " + list.add(4, "four"));
        System.out.println("ADDED: " + list.add("five"));
        System.out.println("ADDED: " + list.add(0, "first"));

        System.out.println("------------");
        list.printForward();

        System.out.println(list.remove(0));
        System.out.println(list.remove(5));
        System.out.println(list.remove(3));
        System.out.println(list.remove(10));

        System.out.println("------------");
        list.printForward();
        System.out.println("------------");
        list.printBackwards();
    }
}
