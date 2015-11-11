package tests;

import impl.FunctionalArrayList;
import interfaces.ErrorMessage;
import interfaces.FunctionalList;
import interfaces.ReturnObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by vladimirsivanovs on 11/11/2015.
 */
public class FunctionalArrayListTest {
    FunctionalArrayList list;
    FunctionalArrayList emptyList;

    @Before
    public void init(){
        list = new FunctionalArrayList();
        emptyList = new FunctionalArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
    }

    @Test
    public void shouldReturnErrorWhenListIsEmpty() throws Exception {
        ReturnObject result = emptyList.head();
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, result.getError());
        assertNull(result.getReturnValue());
    }

    @Test
    public void shouldReturnHeadObject() throws Exception {
        ReturnObject result = list.head();
        Object value = result.getReturnValue();
        assertEquals(ErrorMessage.NO_ERROR, result.getError());
        assertEquals("one", value);
    }

    @Test
    public void shouldReturnNewEmptyListWhenListIsEmpty() throws Exception {
        FunctionalList rest = emptyList.rest();
        assertEquals(0, rest.size());
    }

    @Test
    public void shouldReturnNewEmptyListWhenOnlyOneElementInList() throws Exception {
        emptyList.add("one");
        FunctionalList rest = emptyList.rest();
        assertEquals(0, rest.size());
    }

    @Test
    public void shouldReturnNewListWithoutFirstElement() throws Exception {
        FunctionalList rest = list.rest();
        assertEquals(3, rest.size());
        assertEquals("two", rest.head().getReturnValue());
    }
}