package impl;

import interfaces.ErrorMessage;
import interfaces.List;
import interfaces.ReturnObject;

/**
 * Created by Vladimirs Ivanovs on 05/11/2015.
 */
public class LinkedList implements List {

    protected int size = 0; //size of the list
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
        Object item = node.getValue(); //get value of the node
        Node next = node.getNext();
        Node prev = node.getPrev();

        //checks if node is the first element of the list
        if (prev == null) {
            head = next;
        } else {
            prev.setNext(next);
            node.setPrev(null);
        }
        //checks if node is the last element of the list
        if (next == null) {
            tail = prev;
        } else {
            next.setPrev(prev);
            node.setNext(null);
        }

        node.setValue(null); //set value of the node to null
        size--;
        return returnSuccess(item);
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (!isPositionValid(index)) return returnOutOfBoundsError();
        if (item == null) return returnInvalidArgumentError();

        if (index == size) {
            addLast(item);
        } else {
            addBefore(item, getNode(index));
        }
        return returnSuccess(item);
    }

    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return returnInvalidArgumentError();
        }
        addLast(item);
        return returnSuccess(item);
    }

    /**
     * Adds node to the beginning of the list
     *
     * @param item to be added
     */
    private void addFirst(Object item) {
        Node first = head;
        Node newNode = new Node(item, first, null);
        head = newNode;
        if (first == null) {
            tail = newNode;
        } else {
            first.setPrev(newNode);
        }
        size++;
    }

    /**
     * Adds node to the end of the list.
     *
     * @param item to be added
     */
    private void addLast(Object item) {
        Node last = tail;
        Node newNode = new Node(item, null, last);
        tail = newNode;
        if (last == null) {
            head = newNode;
        } else {
            last.setNext(newNode);
        }
        size++;
    }

    /**
     * Adds a new node before specified node.
     *
     * @param item value of new node
     * @param succ node to insert before
     */
    private void addBefore(Object item, Node succ) {
        Node pred = succ.getPrev();
        Node newNode = new Node(item, succ, pred);
        succ.setPrev(newNode);
        if (pred == null) {
            head = newNode;
        } else {
            pred.setNext(newNode);
        }
        size++;
    }

    /**
     * Checks if element with current index exists within a list.
     *
     * @param index to check
     * @return true if succeeded, false otherwise
     */
    private boolean isIndexValid(int index) {
        return (index >= 0 && index < size);
    }

    /**
     * Checks if position for insertion is valid.
     *
     * @param index to check
     * @return true if succeeded, false otherwise
     */
    private boolean isPositionValid(int index) {
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

    //For testing purposes
    public void printForward() {
        Node node = head;

       for (int i = 0; i < size; i ++) {
           System.out.println(i + " : " + node.getValue() + " by index: " + this.get(i));
           node = node.getNext();
        }
    }

    //For testing purposes
    public void printBackwards() {
        Node node = tail;

        for (int i = size - 1; i >= 0; i --) {
            System.out.println(i + " : " + node.getValue() + " by index: " + this.get(i));
            node = node.getPrev();
        }
    }
}
