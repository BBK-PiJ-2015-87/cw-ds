package tests;

import impl.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vladimirsivanovs on 05/11/2015.
 */


public class ArrayListTest {


    ArrayList list = new ArrayList(0);
    ArrayList list2 = new ArrayList();

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsNotEmpty() throws Exception {
        assertFalse(list2.isEmpty());
    }

    @Test
    public void testSizeIsZero() throws Exception {
        assertEquals(0, list.size());
    }

    @Test
    public void testSizeIsTwenty() throws Exception {
        assertEquals(20, list2.size());
    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testAdd1() throws Exception {

    }
}