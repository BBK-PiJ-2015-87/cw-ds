package impl;

import interfaces.ImprovedStack;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class ImprovedStackImpl extends StackImpl implements ImprovedStack {

    /**
     * Creates a new abstract stack using the provided list as the
     * underlying data structure.
     * <p>
     * Note: This constructor does not check whether the provided list
     * is null. Programmers must do their own checks. If a null list
     * is provided, a NullPointerException will be thrown at runtime
     * as soon as any operation is attempted on the underlying list.
     *
     * @param list the list to be used
     */
    public ImprovedStackImpl(List list) {
        super(list);
    }


    @Override
    public ImprovedStack reverse() {
        LinkedList newList = new LinkedList();
        for (int i = 0; i < internalList.size(); i++) {
            ReturnObject obj = internalList.get(i);
            newList.add(0, obj.getReturnValue());
        }
        ImprovedStack reversed = new ImprovedStackImpl(newList);
        return reversed;
    }

    @Override
    public void remove(Object object) {

    }
}
