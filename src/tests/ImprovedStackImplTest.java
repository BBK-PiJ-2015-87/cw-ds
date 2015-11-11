package tests;

import impl.ImprovedStackImpl;
import impl.LinkedList;
import interfaces.ErrorMessage;
import interfaces.ImprovedStack;
import interfaces.List;
import interfaces.ReturnObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Workstation on 11/11/2015.
 */
public class ImprovedStackImplTest {

    ImprovedStackImpl stack;

    @Before
    public void init() {
        List list = new LinkedList();
        stack = new ImprovedStackImpl(list);
    }

    @Test
        public void shoudlReturnReversedStack() throws Exception {
        stack.push("one");
        stack.push("two");
        stack.push("three");

        ImprovedStack reversed = stack.reverse();
        assertEquals(3, stack.size());
        assertEquals(3, reversed.size());
        ReturnObject fromStack = stack.top();
        ReturnObject fromReversed = reversed.top();
        assertEquals("three", fromStack.getReturnValue());
        assertEquals(ErrorMessage.NO_ERROR, stack.top().getError());
        assertEquals("one", fromReversed.getReturnValue());
        assertEquals(ErrorMessage.NO_ERROR, reversed.top().getError());
    }

    @Test
    public void shouldReturnEmptyStack() throws Exception {
        assertEquals(0, stack.reverse().size());
    }

    @Test
    public void shouldRemoveThreeObjects() throws Exception {
        stack.push("REMOVED");
        stack.push("one");
        stack.push("REMOVED");
        stack.push("two");
        stack.push("REMOVED");
        stack.remove("REMOVED");
        assertEquals(2, stack.size());
        assertEquals("two", stack.top().getReturnValue());
    }

    @Test
    public void shouldNotRemoveAnyObjects() throws Exception {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("removed");
        stack.remove("REMOVED");
        assertEquals(4, stack.size());
        assertEquals("removed", stack.top().getReturnValue());
    }
}