package adt.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationTest {
    private SimpleBSTManipulationImpl<Integer> impl;
    private BSTImpl<Integer> tree1;
    private BSTImpl<Integer> tree2;
    private BSTImpl<Integer> tree3;

    private void fillTree() {
		Integer[] array1 = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
        Integer[] array2 = { 5, 3, 16, -1, 9, 40, 4, 27, 76, 3, 2, 12};
        Integer[] array3 = { 5, 3, 16, -1, 9, 40, 4};

		for (int i = 0; i < array1.length; i++) {
			tree1.insert(array1[i]);
            tree2.insert(array2[i]);
		}

        for (int i : array3) {
            tree3.insert(i);
        }
	}

	@Before
	public void setUp() {
        impl = new SimpleBSTManipulationImpl<>();
		tree1 = new BSTImpl<>();
        tree2 = new BSTImpl<>();
        tree3 = new BSTImpl<>();
	}

    @Test
    public void testEquals() {
        this.fillTree();

        assertTrue(impl.equals(tree1, tree1));
        assertFalse(impl.equals(tree1, tree2));
        assertFalse(impl.equals(tree3, tree2));
    }

    @Test
    public void testIsSimilar() {
        this.fillTree();

        assertTrue(impl.isSimilar(tree1, tree2));
        assertFalse(impl.isSimilar(tree1, tree3));
    }

    @Test
    public void testOrderStatistic() {
        this.fillTree();

        assertEquals(new Integer(5), impl.orderStatistic(tree3, 4));
    }
}
