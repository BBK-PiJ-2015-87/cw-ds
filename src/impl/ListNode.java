package impl;

import interfaces.List;

/**
 * Created by vladimirsivanovs on 09/11/2015.
 */
public class ListNode {

    private Object value;
    private ListNode next;

    public ListNode(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }


}
