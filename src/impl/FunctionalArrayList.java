package impl;

import interfaces.FunctionalList;
import interfaces.ReturnObject;

/**
 * Created by Vladimirs Ivanovs on 05/11/2015.
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {

    public FunctionalArrayList(int capacity) {
        super(capacity);
    }

    public FunctionalArrayList() {
        super();
    }

    @Override
    public ReturnObject head() {
        if (this.size() == 0) {
            return returnEmptyStructureError();
        }
        return returnSuccess(elements[0]);
    }

    @Override
    public FunctionalList rest() {
        FunctionalList listNoHead = new FunctionalArrayList(this.elements.length);
        if (this.size == 0) {
            return listNoHead;
        }
        for (int i = 1; i <= this.size - 1; i++) {
            listNoHead.add(this.elements[i]);
        }
        return listNoHead;
    }
}
