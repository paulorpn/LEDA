package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {
	
	private int count;

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return this.equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean equals(BSTNode<T> tree1Node, BSTNode<T> tree2Node) {
		boolean equals = false;

		if (tree1Node.isEmpty() && tree2Node.isEmpty()) {
			equals = true;
		} else if (!tree1Node.isEmpty() && !tree2Node.isEmpty()) {
			if (tree1Node.equals(tree2Node)) {
				equals = this.equals((BSTNode<T>) tree1Node.getLeft(), (BSTNode<T>) tree2Node.getLeft());
				equals = this.equals((BSTNode<T>) tree1Node.getRight(), (BSTNode<T>) tree2Node.getRight());
			}
		}

		return equals;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return this.isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean isSimilar(BSTNode<T> tree1Node, BSTNode<T> tree2Node) {
		boolean isSimilar = false;

		if (tree1Node.isEmpty() && tree2Node.isEmpty()) {
			isSimilar = true;
		} else if (!tree1Node.isEmpty() && !tree2Node.isEmpty()) {
			isSimilar = this.isSimilar((BSTNode<T>) tree1Node.getLeft(), (BSTNode<T>) tree2Node.getLeft());
			isSimilar = this.isSimilar((BSTNode<T>) tree1Node.getRight(), (BSTNode<T>) tree2Node.getRight());
		}

		return isSimilar;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T orderStatistic = null;

		if (k >= 1 && k <= tree.size()) {
			this.count = 0;
			orderStatistic = this.orderStatistic((BSTNode<T>) tree.getRoot(), k);
		}

		return orderStatistic;
	}

	private T orderStatistic(BSTNode<T> current, int k) {
		T orderStatistic = null;

		if (!current.isEmpty()) {
			orderStatistic = this.orderStatistic((BSTNode<T>) current.getLeft(), k);

			this.count++;

			if (count == k) {
				orderStatistic = current.getData();
			}

			if (orderStatistic == null) {
				orderStatistic = this.orderStatistic((BSTNode<T>) current.getRight(), k);
			}
		}

		return orderStatistic;
	}

}