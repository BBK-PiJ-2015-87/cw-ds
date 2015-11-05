package impl;

import interfaces.AbstractStack;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class StackImpl extends AbstractStack {
    /**
     * Creates a new abstract stack using the provided list as the
     * underlying data structure.
     * <p/>
     * Note: This constructor does not check whether the provided list
     * is null. Programmers must do their own checks. If a null list
     * is provided, a NullPointerException will be thrown at runtime
     * as soon as any operation is attempted on the underlying list.
     *
     * @param list the list to be used
     */
    public StackImpl(List list) {
        super(list);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void push(Object item) {

    }

    @Override
    public ReturnObject top() {
        return null;
    }

    @Override
    public ReturnObject pop() {
        return null;
    }
}
