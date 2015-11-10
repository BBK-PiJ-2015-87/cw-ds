package impl;

import interfaces.ErrorMessage;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by Vladimirs Ivanovs on 05/11/2015.
 */
public class ArrayList implements List {

    /**
     * The array where all elements are stored. Default size of this array is 5.
     */
    protected Object[] elements;

    protected int size = 0;

    private static final int DEFAULT_CAPACITY = 5;

    /**
     * Constructs list of a given size
     *
     * @param capacity of the array list. Default is 5 elements.
     */
    public ArrayList(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        elements = new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ReturnObject get(int index) {
        if(isEmpty()) return returnEmptyStructureError();

        if (!isIndexValid(index, size)) {
            return returnOutOfBoundsError();
        } else {
            return returnSuccess(elements[index]);
        }
    }

    @Override
    public ReturnObject remove(int index) {
        if(isEmpty()) return returnEmptyStructureError();
        if (!isIndexValid(index, size)) {
            return returnOutOfBoundsError();
        }

        Object result = elements[index];

        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size] = null;
        size--;
        return returnSuccess(result);
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (!isIndexValid(index, size + 1)) {
            return returnOutOfBoundsError();
        } else if (item == null) {
            return returnInvalidArgumentError();
        }

        doubleSize();

        //move elements of the array to the right by 1
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        return addElement(index, item);
    }

    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return returnInvalidArgumentError();
        }
        doubleSize();
        return addElement(size, item);
    }

    /**
     * Adds element to the array, increments size by 1 and return wrapper object.
     *
     * @param index position of insertion
     * @param item Object to be inserted
     * @return inserted object with no Error
     */
    private ReturnObject addElement(int index, Object item) {
        elements[index] = item;
        size++;
        return returnSuccess(item);
    }

    /**
     * Checks if index is a valid number.
     *
     * @param index to check
     * @param max maximal possible value of provided index
     * @return true if valid, false otherwise
     */
    public boolean isIndexValid(int index, int max) {
        if (index < 0 || index >= max) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Increases the size of the array to a provided size
     *
     * @param newSize size of a new array
     */
    private void increaseSize(int newSize) {
        Object[] tmp = new Object[newSize];
        for (int i = 0; i < size; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
//        System.out.println("DEBUG: Increased array" );
    }

    /**
     * Double size of the array is full.
     */
    private void doubleSize() {
        int capacity = elements.length;
        if (size == capacity) {
//            System.out.println("DEBUG: Doubled the size");
            increaseSize(elements.length * 2);
        }
    }

    /**
     * Returns wrapper object with Index Out of Bounds error message.
     *
     * @return
     */
    protected ReturnObject returnOutOfBoundsError() {
        return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
    }

    /**
     * Returns wrapper object with Empty Source error message.
     *
     * @return
     */
    protected ReturnObject returnEmptyStructureError() {
        return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE, null);
    }

    /**
     * Returns wrapper object with Invalid Argument error message.
     *
     * @return
     */
    protected ReturnObject returnInvalidArgumentError() {
        return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT, null);
    }

    /**
     * Returns wrapper object with no error message.
     *
     * @param object to be returned within wrapper object
     * @return
     */
    protected ReturnObject returnSuccess(Object object) {
        return new ReturnObjectImpl(ErrorMessage.NO_ERROR, object);
    }

    /**
     * Returns capacity of the array list. For test purposes.
     *
     * @return array length
     */
    public int getCapacity() {
        return elements.length;
    }

}
