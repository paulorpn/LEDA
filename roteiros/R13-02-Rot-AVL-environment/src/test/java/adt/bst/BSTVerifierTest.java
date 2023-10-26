package adt.bst;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Suite.SuiteClasses;

public class BSTVerifierTest {
    private BSTVerifierImpl<Integer> impl;
    private BSTImpl<Integer> tree1;
    private BSTImpl<Integer> tree2;
    private InvalidBST<Integer> tree3;

    private void fillTree() {
        Integer[] array = { 6, 23, -34, 5, 9, 2 };
            for (int i : array) {
                tree1.insert(i);
                tree3.insert(i);
		}
    }

    @Before
    public void setUp() {
        tree1 = new BSTImpl<>();
        tree2 = new BSTImpl<>();
        tree3 = new InvalidBST<>();
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

    @Test
    public void testIsBSTInvalidTree() {
        impl = new BSTVerifierImpl<>(tree3);
        assertFalse(impl.isBST());
    }
}


class InvalidBST<T extends Comparable<T>> extends BSTImpl<T> {
    protected BSTNode<T> root;

	InvalidBST() {
		root = new BSTNode<T>();
	}

    @Override
    public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.root.setData(element);
				this.root.setLeft(new BSTNode<T>());
				this.root.setRight(new BSTNode<T>());
				this.root.getLeft().setParent(this.root);
				this.root.getRight().setParent(this.root);
			} else {
				this.insert(element, this.root);
			}
		}
	}

	private void insert(T element, BSTNode<T> current) {
		if (element.compareTo(current.getData()) > 0) {
			if (current.getLeft().isEmpty()) {
				current.getLeft().setData(element);
				current.getLeft().setParent(current);
				current.getLeft().setLeft(new BSTNode<T>());
				current.getLeft().setRight(new BSTNode<T>());
			} else {
				this.insert(element, this.getLeftOf(current));
			}
		} else {
			if (current.getRight().isEmpty()) {
				current.getRight().setData(element);
				current.getRight().setParent(current);
				current.getRight().setLeft(new BSTNode<T>());
				current.getRight().setRight(new BSTNode<T>());
			} else {
				this.insert(element, this.getRightOf(current));
			}
		}
	}

    private BSTNode<T> getLeftOf(BSTNode<T> node) {
		return (BSTNode<T>) node.getLeft();
	}

	private BSTNode<T> getRightOf(BSTNode<T> node) {
		return (BSTNode<T>) node.getRight();
	}

}