package adt.linkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Target;

import org.junit.Before;
import org.junit.Test;

public class RecursiveSingleLInkedListImplTest {

    private RecursiveSingleLinkedListImpl<Integer> list1;
    private RecursiveDoubleLinkedListImpl<Integer> list2;

    @Before
    public void setUp() {
        this.list1 = new RecursiveSingleLinkedListImpl<>();
        this.list2 = new RecursiveDoubleLinkedListImpl<>();

        this.list1.insert(1);
        this.list1.insert(2);
        this.list1.insert(3);
    }

    @Test
    public void testIsEmpty() {
        assertFalse(this.list1.isEmpty());
        assertTrue(this.list2.isEmpty());
    }

    @Test
    public void testSearch() {
        assertEquals(new Integer(2), this.list1.search(2));
        assertEquals(null, this.list1.search(5));
        assertEquals(null, this.list2.search(2));
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Integer[] {1, 2, 3}, this.list1.toArray());
        assertArrayEquals(new Integer[] {}, this.list2.toArray());
    }

    @Test
    public void testRemoveFirst() {
        this.list1.remove(1);
        assertArrayEquals(new Integer[] {2, 3}, this.list1.toArray());
    }

    @Test
    public void testRemoveMiddle() {
        this.list1.remove(2);
        assertArrayEquals(new Integer[] {1, 3}, this.list1.toArray());
    }

    @Test
    public void testRemoveLast() {
        this.list1.remove(3);
        assertArrayEquals(new Integer[] {1, 2}, this.list1.toArray());
    }

}
