package impl;

import interfaces.ErrorMessage;
import interfaces.ReturnObject;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class ReturnObjectImpl implements ReturnObject {
    @Override
    public boolean hasError() {
        return false;
    }

    @Override
    public ErrorMessage getError() {
        return null;
    }

    @Override
    public Object getReturnValue() {
        return null;
    }
}
