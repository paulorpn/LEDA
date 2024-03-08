package adt.bst;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BSTVerifierTest {
    private BSTVerifierImpl<Integer> impl;
    private BSTImpl<Integer> tree1;
    private BSTImpl<Integer> tree2;

    private void fillTree() {
        Integer[] array = { 6, 23, -34, 5, 9, 2 };
            for (int i : array) {
                tree1.insert(i);
		}
    }

    @Before
    public void setUp() {
        tree1 = new BSTImpl<>();
        tree2 = new BSTImpl<>();
        fillTree();
    }

    @Test
    public void testIsBST01() {
        impl = new BSTVerifierImpl<>(tree1);
        assertTrue(impl.isBST());
    }

    @Test
    public void testIsBST02() {
        impl = new BSTVerifierImpl<>(tree2);
        assertTrue(impl.isBST());
    }

    @Test
    public void testIsBST03() {
        impl = new BSTVerifierImpl<>(null);
        assertFalse(impl.isBST());
    }
}