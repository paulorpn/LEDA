package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.root);
	}

	private int height(BSTNode<T> current) {
		int height = -1;

		if (!current.isEmpty()) {
			return 1 + Math.max(this.height(this.getCurrentLeft(current)), this.height(this.getCurrentRight(current)));
		}

		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return this.search(element, this.root);
	}

	private BSTNode<T> search(T element, BSTNode<T> current) {
		BSTNode<T> output = new BSTNode<>();

		if (!current.isEmpty() && element != null) {
			if ((int) current.getData() == (int) element) {
				output = current;
			} else if ((int) this.getCurrentLeft(current).getData() < (int) element) {
				return this.search(element, this.getCurrentLeft(current));
			} else {
				return this.search(element, this.getCurrentRight(current));
			}
		}

		return output;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			this.insert(element, this.root);
		}
	}

	private void insert(T element, BSTNode<T> current) {
		if ((int) element < (int) this.getCurrentLeft(current).getData()) {
			
		}
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

	private BSTNode<T> getCurrentLeft(BSTNode<T> current) {
		return (BSTNode<T>) current.getLeft();
	}

	private BSTNode<T> getCurrentRight(BSTNode<T> current) {
		return (BSTNode<T>) current.getRight();
	}
}
