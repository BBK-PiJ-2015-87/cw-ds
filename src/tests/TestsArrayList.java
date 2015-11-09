package tests;

import impl.ArrayList;

/**
 * Tests for ArrayList.
 *
 * Created by Vladimirs Ivanovs.
 */
public class TestsArrayList {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        printArray(list);

        System.out.println(list.add(0, "Hello"));
        System.out.println(list.add("Vlad"));
        System.out.println(list.add(2, "Anna"));
        System.out.println(list.add(1, "Pete"));
        System.out.println(list.add(4, "Max"));
        System.out.println(list.add(10, "Taxi"));
        System.out.println(list.add(-1, "Taxi"));

        printArray(list);

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");

        printArray(list);

        System.out.println("REMOVED: " + list.remove(0));
        System.out.println("REMOVED: " + list.remove(100));
        System.out.println("REMOVED: " + list.remove(-2));
        System.out.println("REMOVED: " + list.remove(2));
        System.out.println("REMOVED: " + list.remove(4));

        printArray(list);

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
