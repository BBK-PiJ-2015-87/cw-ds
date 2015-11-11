package impl;

import interfaces.FunctionalList;
import interfaces.ReturnObject;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {

    public FunctionalLinkedList() {
        super();
    }

    @Override
    public ReturnObject head() {
        if (isEmpty()) return returnEmptyStructureError();

        return returnSuccess(head.getValue());
    }

    @Override
    public FunctionalList rest() {
        return null;
    }
}
