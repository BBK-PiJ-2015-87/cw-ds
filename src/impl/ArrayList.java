package impl;

import interfaces.ErrorMessage;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class ArrayList implements List {

    /**
     * The array where all elements are stored. Default size of this array is 20.
     */
    private Object[] elements;


    public ArrayList(int size) {
        elements = new Object[size];
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
        if (isIndexValid(index)) {
            return returnSuccess(item);
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

    private boolean isIndexValid(int index) {
        if (index < 0 || index >= elements.length) {
            return false;
        } else {
            return true;
        }
    }

    private ReturnObject returnOutOfBoundsError() {
        return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
    }

    private ReturnObject returnEmptyStructureError() {
        return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE, null);
    }

    private ReturnObject returnInvalidArgumentError() {
        return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT, null);
    }

    private ReturnObject returnSuccess(Object object) {
        return new ReturnObjectImpl(ErrorMessage.NO_ERROR, object);
    }

    private void increaseSize() {
        int size = elements.length;
        if (elements[size - 1] != null) {
            Object[] tmp = elements;
            elements = new Object[size * 2];
            copyArrayElements(tmp, elements);
        }
    }

    private void copyArrayElements(Object[] src, Object[] dest) {
        int iter = src.length;
        while (iter > 0) {
            dest[iter] = src[iter];
        }
    }

}
