package impl;

import interfaces.AbstractStack;
import interfaces.ErrorMessage;
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
        return internalList.isEmpty();
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public void push(Object item) {
        internalList.add(0, item);
    }

    @Override
    public ReturnObject top() {
        return internalList.get(0);
    }

    @Override
    public ReturnObject pop() {
        return internalList.remove(0);
    }
}
