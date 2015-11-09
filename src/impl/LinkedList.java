package impl;

import interfaces.ErrorMessage;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by Vladimirs Ivanovs on 05/11/2015.
 */
public class LinkedList implements List {

    protected int size = 0;
    private ListNode head = null;

    public LinkedList() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ReturnObject get(int index) {
        if (!isIndexValid(index + 1)) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
        }
        ListNode node = head;
        while (index > 1) {
            node = node.getNext();
            index--;
        }
        return returnSuccess(node.getValue());
    }

    @Override
    public ReturnObject remove(int index) {
        ListNode toRemove;
        ListNode prevNode = head;
        while (index > 1) {
            prevNode = prevNode.getNext();
            index--;
        }
        toRemove = prevNode.getNext();
        prevNode.setNext(toRemove.getNext());
        Object result = toRemove.getValue();
        toRemove.setNext(null);
        size--;
        return returnSuccess(result);

    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (!isIndexValid(index)) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
        }

        ListNode newNode = new ListNode(item);

        if (isEmpty()) {
            head = newNode;
        } else {
            ListNode nodePreIndex = head;
            while (index > 2) {
                nodePreIndex = nodePreIndex.getNext();
                index--;
            }
            newNode.setNext(nodePreIndex.getNext());
            nodePreIndex.setNext(newNode);
        }
        size++;
        return returnSuccess(item);
    }

    @Override
    public ReturnObject add(Object item) {

//        System.out.println("DEBUG: list size is " + size);
        ListNode newNode = new ListNode(item);
        if (isEmpty()) {
//            System.out.println("DEBUG: List is empty");
            head = newNode;
        } else {
            ListNode next = head;
            while (next.getNext() != null) {
//                System.out.println("DEBUG: next is " + next.getNext().getValue());
                next = next.getNext();
            }
            next.setNext(newNode);
        }
        size++;
        return returnSuccess(newNode.getValue());
    }

    public boolean isIndexValid(int index) {
        if (index < 1 || index > size + 1) {
            return false;
        }
        return true;
    }

    /**
     * Returns wrapper object with no error message.
     *
     * @param object to be returned within wrapper object
     * @return
     */
    protected ReturnObject returnSuccess(Object object) {
        return new ReturnObjectImpl(ErrorMessage.NO_ERROR, object);
    }

}
