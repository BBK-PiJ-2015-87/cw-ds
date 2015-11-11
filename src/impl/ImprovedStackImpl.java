package impl;

import interfaces.ImprovedStack;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by Vladimirs Ivanovs on 05/11/2015.
 */
public class ImprovedStackImpl extends StackImpl implements ImprovedStack {

    public ImprovedStackImpl(List list) {
        super(list);
    }


    @Override
    public ImprovedStack reverse() {
        LinkedList newList = new LinkedList();
        for (int i = internalList.size(); i >= 0; i--) {
            ReturnObject obj = internalList.get(i);
            newList.add(obj.getReturnValue());
        }
        ImprovedStack reversed = new ImprovedStackImpl(newList);
        return reversed;
    }

    @Override
    public void remove(Object object) {
        int i = internalList.size() - 1;
        while (i >= 0) {
            ReturnObject target = internalList.get(i);
            Object targetVal = target.getReturnValue();
            if (targetVal.equals(object)) {
                this.internalList.remove(i);
//                System.out.println("DEBUG: removed object " + targetVal);
            }
            i--;
        }
    }
}
