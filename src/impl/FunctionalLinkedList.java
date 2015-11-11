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
        if (this.size <= 1) return new FunctionalLinkedList();

        FunctionalList rest = new FunctionalLinkedList();
        for (int i = 1; i < this.size(); i++) {
            rest.add(this.get(i).getReturnValue());
        }
        return rest;
    }
}
