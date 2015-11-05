package impl;

import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class ArrayList implements List {

    /**
     * The array where all elements are stored.
     */
    private ReturnObject[] elements;


    public ArrayList(int size) {
        elements = new ReturnObject[size];
    }

    public ArrayList() {
        this(20);
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ReturnObject get(int index) {
        return elements[index];
    }

    @Override
    public ReturnObject remove(int index) {
        return null;
    }

    @Override
    public ReturnObject add(int index, Object item) {
        return null;
    }

    @Override
    public ReturnObject add(Object item) {
        return null;
    }
}
