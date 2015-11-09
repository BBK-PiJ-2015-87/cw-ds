package tests;

import impl.LinkedList;
import impl.ListNode;

/**
 * Created by vladimirsivanovs on 09/11/2015.
 */
public class TestsLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();


        System.out.println("ADDED: " + list.add("zero"));
        System.out.println("ADDED: " + list.add(1, "one"));
        System.out.println("ADDED: " + list.add(1, "two"));
        System.out.println("ADDED: " + list.add(1, "three"));
        System.out.println("ADDED: " + list.add(1, "four"));
        System.out.println("ADDED: " + list.add(1, "five"));

//        System.out.println("ADDED: " + list.add("one"));
//        System.out.println("ADDED: " + list.add("two"));
//        System.out.println("ADDED: " + list.add("three"));
//        System.out.println("ADDED: " + list.add("four"));
//        System.out.println("ADDED: " + list.add("five"));


        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println(list.size());

    }
}
