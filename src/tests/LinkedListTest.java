package tests;

import impl.LinkedList;
import interfaces.ErrorMessage;
import interfaces.ReturnObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vladimirs Ivanovs on 11/11/2015.
 */
public class LinkedListTest {
    LinkedList list;
    LinkedList emptyList;

    @Before
    public void init() {
        list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        emptyList = new LinkedList();
    }

    @After
    public void clean() {
        list = null;
    }

    @Test
    public void shouldReturnObjectWithSpecifiedPosition() throws Exception {
        ReturnObject result = list.get(0);
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals("1", result.getReturnValue());
    }

    @Test
    public void shouldReturnErrorWhenIndexOutOfBounds() throws Exception {
        ReturnObject result = list.get(10);
        assertEquals(ErrorMessage.INDEX_OUT_OF_BOUNDS, result.getError());
        assertNull(result.getReturnValue());
    }

    @Test
    public void shouldReturnErrorWhenListIsEmpty() throws Exception {
        ReturnObject result = emptyList.get(0);
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.getError());
        assertNull(result.getReturnValue());
    }

    @Test
    public void shouldRemoveObjectWithSpecifiedIndex() throws Exception {
        ReturnObject result = list.remove(2);
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals("3", result.getReturnValue());
        assertEquals(3, list.size());
    }

    @Test
    public void shouldReturnErrorWhenAddNull() throws Exception {
        ReturnObject result = list.add(null);
        assertEquals(ErrorMessage.INVALID_ARGUMENT, result.getError());
        assertNull(result.getReturnValue());
        assertEquals(4, list.size());
    }
}