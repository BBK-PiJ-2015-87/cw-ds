package tests;

import impl.ArrayList;
import impl.FunctionalArrayList;
import interfaces.FunctionalList;

/**
 * Tests for FunctionalArrayList.
 *
 * Created by Vladimirs Ivanovs.
 */
public class TestsFunctionalArrayList {
    public static void main(String[] args) {
        FunctionalArrayList list = new FunctionalArrayList();
        FunctionalArrayList list1 = (FunctionalArrayList)list.rest();
        printArray(list1);
        System.out.println("HEAD: " + list1.head());

        list.add("One");
        list.add(2);
        list.add('3');
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.remove(0);
        list.remove(100);
        list.remove(-2);
        list.remove(2);
        list.remove(4);

        printArray(list);

        System.out.println("HEAD list: " + list.head());

        FunctionalArrayList list2 = (FunctionalArrayList)list.rest();

        printArray(list2);

        System.out.println("HEAD list2: " + list2.head());

        FunctionalArrayList list3 = new FunctionalArrayList();
        FunctionalArrayList list4 = (FunctionalArrayList) list3.rest();
        System.out.println("HEAD 4: " + list4.head());
        printArray(list4);

    }

    public static void printArray(ArrayList list) {
        for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("SIZE: " + list.size());
        System.out.println("CAPACITY: " + list.getCapacity());
        System.out.println("------------------");
        System.out.println();
    }
}
