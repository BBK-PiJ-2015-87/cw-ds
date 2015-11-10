package tests;

import impl.LinkedList;
import impl.Node;

/**
 * Created by vladimirsivanovs on 09/11/2015.
 */
public class TestsLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        java.util.LinkedList list2 = new java.util.LinkedList();
        list2.remove(1);

        System.out.println("ADDED: " + list.add("zero"));
        System.out.println("ADDED: " + list.add("one"));
        System.out.println("ADDED: " + list.add("two"));
        System.out.println("ADDED: " + list.add("three"));
        System.out.println("ADDED: " + list.add("four"));
        System.out.println("ADDED: " + list.add("five"));
        System.out.println("ADDED: " + list.add(7, "six"));

        list.printForward();
        System.out.println("------------");
        list.printBackwards();
    }
}
