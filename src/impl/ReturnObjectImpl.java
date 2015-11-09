package impl;

import interfaces.ErrorMessage;
import interfaces.ReturnObject;

/**
 * Created by Vladimirs Ivanovs on 05/11/2015.
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
        return !error.toString().equals("NO_ERROR");
    }

    @Override
    public ErrorMessage getError() {
        return error;
    }

    @Override
    public Object getReturnValue() {
        return returnValue;
    }

    @Override
    public String toString() {
        return "Error: " + this.hasError() + " Message: " + getError().toString() +
                " Object: " + returnValue;
    }
}
