package tests;

import impl.ArrayList;
import impl.ImprovedStackImpl;
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
        List list = new ArrayList();
        stack = new ImprovedStackImpl(list);
    }

    @Test
    public void testReverse() throws Exception {
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
    public void testRemove() throws Exception {

    }
}