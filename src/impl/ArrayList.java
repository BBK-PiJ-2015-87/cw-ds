package impl;

import interfaces.ErrorMessage;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by Vladimirs Ivanovs on 05/11/2015.
 */
public class ArrayList implements List {

    /**
     * The array where all elements are stored. Default size of this array is 20.
     */
    private Object[] elements;

    private int size;

    /**
     * Constructs list of a given size
     *
     * @param size of the array list. Default is 20 elements.
     */
    public ArrayList(int size) {
        elements = new Object[size];
        this.size = size;
    }

    public ArrayList() {
        this(20);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ReturnObject get(int index) {
        if (!isIndexValid(index)) {
            return returnOutOfBoundsError();
        } else {
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR, elements[index]);
        }
    }

    @Override
    public ReturnObject remove(int index) {
        return null;
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (!isIndexValid(index)) {
            return returnOutOfBoundsError();
        } else if (item == null) {
            return returnInvalidArgumentError();
        } else {
            elements[index] = item;
            return returnSuccess(item);
        }
    }

    @Override
    public ReturnObject add(Object item) {
        return null;
    }

    /**
     * @param index
     * @return
     */
    private boolean isIndexValid(int index) {
        if (index < 0 || index >= elements.length) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return
     */
    private int getLastElementPosition() {
        int position = 0;
        while (elements[position] != null) {
            position++;
        }
        return position;
    }

    /**
     * @return
     */
    private ReturnObject returnOutOfBoundsError() {
        return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
    }

    /**
     * @return
     */
    private ReturnObject returnEmptyStructureError() {
        return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE, null);
    }

    /**
     * @return
     */
    private ReturnObject returnInvalidArgumentError() {
        return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT, null);
    }

    /**
     * @param object
     * @return
     */
    private ReturnObject returnSuccess(Object object) {
        return new ReturnObjectImpl(ErrorMessage.NO_ERROR, object);
    }

    /**
     *
     */
    private void increaseSize() {
        Object[] tmp = elements;
        int newSize = (size < (Integer.MAX_VALUE/2 - 20))? size*2 : Integer.MAX_VALUE-20;
        if (size < 5) {
            elements = new Object[10];
        } else if (elements[size/2] != null) {
            elements = new Object[newSize];
        }
        copyArrayElements(tmp, elements);
    }

    /**
     * @param src
     * @param dest
     */
    private void copyArrayElements(Object[] src, Object[] dest) {
        int iter = src.length;
        while (iter > 0) {
            dest[iter] = src[iter];
        }
    }

}
