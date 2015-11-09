package tests;

import impl.LinkedList;
import impl.Node;

/**
 * Created by vladimirsivanovs on 09/11/2015.
 */
public class TestsLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("ADDED: " + list.add(0, "HEAD"));
        System.out.println("ADDED: " + list.add("zero"));
        System.out.println("ADDED: " + list.add("one"));
        System.out.println("ADDED: " + list.add("two"));
        System.out.println("ADDED: " + list.add("three"));
        System.out.println("ADDED: " + list.add("four"));
        System.out.println("ADDED: " + list.add(6, "five"));
        System.out.println("ADDED: " + list.add(6, "six"));
        System.out.println("ADDED: " + list.add(10, "ERROR"));
        System.out.println("ADDED: " + list.add(0, "TAIL"));

        list.printForward();
        System.out.println("------------");
        list.printBackwards();
    }
}
