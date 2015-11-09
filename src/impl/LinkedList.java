package impl;

import interfaces.ErrorMessage;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by Vladimirs Ivanovs on 05/11/2015.
 */
public class LinkedList implements List {

    protected int size = 0;
    public Node head = null;
    public Node tail = null;

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns node at the given index.
     *
     * @param index of the node
     * @return node at given index
     */
    private Node getNode(int index) {
        //if index is greater than half of size - traverse from start
        if (index < (size >> 1)) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return node;
        } else {
            Node node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrev();
            }
            return node;
        }
    }


    @Override
    public ReturnObject get(int index) {
        if (!isIndexValid(index)) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
        }
        Node node = this.getNode(index);
        return returnSuccess(node.getValue());
    }

    @Override
    public ReturnObject remove(int index) {
        if (!isIndexValid(index)) return returnOutOfBoundsError();
        if (isEmpty()) return returnEmptyStructureError();

        Node node = getNode(index);
        node.getPrev().setNext(node.getNext());
        node.setNext(null);
        size--;

        return returnSuccess(node.getValue());

    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (!isPositionValid(index)) return returnOutOfBoundsError();
        if (item == null) return returnInvalidArgumentError();

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node succ = getNode(index);
            Node pred = succ.getPrev();
            Node newNode = new Node(item, succ, pred);
            succ.setPrev(newNode);
            pred.setNext(newNode);
        }
        size++;
        return returnSuccess(item);
    }

    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return returnInvalidArgumentError();
        }
        addLast(item);
        size++;
        return returnSuccess(item);
    }

    /**
     * Adds node to the beginning of the list
     *
     * @param item to be added
     */
    private void addFirst(Object item) {
        Node first = head;
        head = new Node(item, head, null);
        if (size == 0) {
            tail = head;
        } else {
            first.setPrev(head);
        }
    }

    /**
     * Adds node to the end of the list.
     *
     * @param item to be added
     */
    private void addLast(Object item) {
        Node last = tail;
        tail = new Node(item, null, tail);
        if (size == 0) {
            head = tail;
        } else {
            last.setNext(tail);
        }
    }

    public boolean isIndexValid(int index) {
        return (index >= 0 && index < size);
    }

    public boolean isPositionValid(int index) {
        return (index >= 0 && index <= size);
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

    /**
     * Returns wrapper object with Invalid Argument error message.
     *
     * @return
     */
    protected ReturnObject returnInvalidArgumentError() {
        return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT, null);
    }

    /**
     * Returns wrapper object with Empty Source error message.
     *
     * @return
     */
    protected ReturnObject returnEmptyStructureError() {
        return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE, null);
    }

    /**
     * Returns wrapper object with Index Out of Bounds error message.
     *
     * @return
     */
    protected ReturnObject returnOutOfBoundsError() {
        return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
    }

    public void printForward() {
        Node node = head;

       for (int i = 0; i < size; i ++) {
           System.out.println(i + " : " + node.getValue() + " by index: " + this.get(i));
           node = node.getNext();
        }
    }

    public void printBackwards() {
        Node node = tail;

        for (int i = size - 1; i >= 0; i --) {
            System.out.println(i + " : " + node.getValue() + " by index: " + this.get(i));
            node = node.getPrev();
        }
    }

}
