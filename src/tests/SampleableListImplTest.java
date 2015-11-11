package tests;

import impl.SampleableListImpl;
import interfaces.SampleableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Workstation on 11/11/2015.
 */
public class SampleableListImplTest {
    SampleableList list;
    SampleableList emptyList;

    @Before
    public void init() {
        list = new SampleableListImpl();
        emptyList = new SampleableListImpl();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
    }

    @Test
    public void shouldReturnEmptyListIfListIsEmpty() throws Exception {
        SampleableList list = emptyList.sample();
        assertEquals(0, list.size());
    }

    @Test
    public void shouldReturnListWithEvenElementPositions() throws Exception {
        SampleableList sampled = list.sample();
        assertEquals(5, sampled.size());
        assertEquals("1", sampled.get(0).getReturnValue());
        assertEquals("3", sampled.get(1).getReturnValue());
        assertEquals("5", sampled.get(2).getReturnValue());
        assertEquals("7", sampled.get(3).getReturnValue());
        assertEquals("9", sampled.get(4).getReturnValue());
    }
}