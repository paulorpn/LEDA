package adt.bst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import adt.bst.extended.FloorCeilBSTImpl;

public class FloorCeilBSTTest {
    private FloorCeilBSTImpl impl;
    private Integer[] array;

    @Before
    public void setUp() {
        this.impl = new FloorCeilBSTImpl();
        this.array = new Integer[] { 5, null, 16, -1, 9, 40, 4};
    }

    @Test
    public void testFloor() {
        assertEquals(new Integer(-1), impl.floor(array, 3.5));
        assertEquals(null, impl.floor(null, 4.2));
        assertEquals(null, impl.floor(array, -7));
        assertEquals(new Integer(-1), impl.floor(array, 1));
        assertEquals(new Integer(40), impl.floor(array, 40));
    }

    @Test
    public void testCeil() {
        assertEquals(new Integer(9), impl.ceil(array, 5.1));
        assertEquals(null, impl.ceil(array, 77));
        assertEquals(null, impl.ceil(null, 8));
        assertEquals(new Integer(-1), impl.ceil(array, -5));
        assertEquals(new Integer(16), impl.ceil(array, 16));
    }
}