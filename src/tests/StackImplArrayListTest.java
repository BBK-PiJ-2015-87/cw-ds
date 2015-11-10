package tests;

import impl.ArrayList;
import impl.StackImpl;
import static org.junit.Assert.*;

import interfaces.ErrorMessage;
import interfaces.ReturnObject;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Vladimirs Ivanovs on 10/11/2015.
 */
public class StackImplArrayListTest {

    StackImpl stack;

    @Before
    public void init() {
        ArrayList list = new ArrayList();
        stack = new StackImpl(list);
    }

    @Test
    public void testShouldBeEmpty() throws Exception {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testShouldNotBeEmpty() throws Exception {
        stack.push("one");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testShouldReturnZeroSize() throws Exception {
        assertEquals(0, stack.size());
    }

    @Test
    public void testShouldReturnTopElement() throws Exception {
        stack.push("One");
        stack.push("Two");
        assertEquals(2, stack.size());
    }

    @Test
    public void testTop() throws Exception {
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        ReturnObject obj = stack.top();
        assertEquals(3, stack.size());
        assertEquals("Three", obj.getReturnValue());
    }

    @Test
    public void testShouldReturnAnErrorWhenTopFromEmptyStack() throws Exception {
        ReturnObject obj = stack.top();
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, obj.getError());
    }

    @Test
    public void testPop() throws Exception {
        stack.push("1");
        stack.push("2");
        stack.push("3");
        ReturnObject obj = stack.pop();
        assertEquals(2, stack.size());
        assertEquals("3", obj.getReturnValue());
    }

    @Test
    public void testShouldReturnAnErrorWhenPopFromEmptyStack() throws Exception {
        ReturnObject obj = stack.top();
        assertEquals(ErrorMessage.EMPTY_STRUCTURE, obj.getError());
    }
}