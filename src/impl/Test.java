package impl;

import interfaces.ErrorMessage;

import java.util.*;
import java.util.ArrayList;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class Test {
    public static void main(String[] args) {
        String [] array = {"hello", "vlad"};
        String [] array2 = {};
        java.util.ArrayList list = new ArrayList();
        System.out.println(list.size());
        System.out.println(ErrorMessage.EMPTY_STRUCTURE==ErrorMessage.EMPTY_STRUCTURE);
        System.out.println(ErrorMessage.NO_ERROR);

        array[1] = "Pete";
        for (String s : array) {
            System.out.println(s);
        }

        System.out.println(Integer.MAX_VALUE/2 - 20);
    }
}
