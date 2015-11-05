package impl;

import interfaces.ErrorMessage;
import interfaces.ReturnObject;

import java.util.Objects;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */
public class ReturnObjectImpl implements ReturnObject {
    private ErrorMessage error;
    private Object returnValue;

    public ReturnObjectImpl(ErrorMessage error, Object returnValue){
        this.error = error;
        this.returnValue = returnValue;
    }

    @Override
    public boolean hasError() {
        return error!=null;
    }

    @Override
    public ErrorMessage getError() {
        return error;
    }

    @Override
    public Object getReturnValue() {
        return returnValue;
    }
}
