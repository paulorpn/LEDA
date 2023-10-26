package adt.bst;

import java.util.ArrayList;

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
			height = 1 + Math.max(this.height(this.getLeftOf(current)), this.height(this.getRightOf(current)));
		}

		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return this.search(element, this.root);
	}

	private BSTNode<T> search(T element, BSTNode<T> current) {
		BSTNode<T> output = new BSTNode<>();

		if (element != null) {
			if (current.isEmpty() || element.compareTo(current.getData()) == 0) {
				output = current;
			} else {
				if (element.compareTo(current.getData()) < 0) {
					output = this.search(element, this.getLeftOf(current));
				} else {
					output = this.search(element, this.getRightOf(current));
				}
			}
		}

		return output;
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
		if (element.compareTo(current.getData()) < 0) {
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

	@Override
	public BSTNode<T> maximum() {
		return this.maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> current) {
		BSTNode<T> maximum = null;

		if (!current.isEmpty()) {
			if (current.getRight().isEmpty()) {
				maximum = current;
			} else {
				maximum = this.maximum(this.getRightOf(current));
			}
		}

		return maximum;
	}

	@Override
	public BSTNode<T> minimum() {
		return this.minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> current) {
		BSTNode<T> minimum = null;

		if (!current.isEmpty()) {
			if (current.getLeft().isEmpty()) {
				minimum = current;
			} else {
				minimum = this.minimum(this.getLeftOf(current));
			}
		}

		return minimum;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> sucessor = null;
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty()) {
				sucessor = this.minimum(this.getRightOf(node));
			} else {
				sucessor = this.sucessor(element, this.getParentOf(node));
			}
		}

		return sucessor;
	}

	private BSTNode<T> sucessor(T element, BSTNode<T> current) {
		BSTNode<T> sucessor = null;

		if (current == null || current.getData().compareTo(element) > 0) {
			sucessor = current;
		} else {
			sucessor = this.sucessor(element, this.getParentOf(current));
		}

		return sucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> predecessor = null;
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				predecessor = this.maximum(this.getLeftOf(node));
			} else {
				predecessor = this.predecessor(element, this.getParentOf(node));
			}
		}

		return predecessor;
	}

	private BSTNode<T> predecessor(T element, BSTNode<T> current) {
		BSTNode<T> predecessor = null;

		if (current == null || current.getData().compareTo(element) < 0) {
			predecessor = current;
 		} else {
			predecessor = this.predecessor(element, this.getParentOf(current));
		}

		return predecessor;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);

		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				if (node == this.root) {
					this.root = new BSTNode<>();
				} else {
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
				}
			} else if (node.getRight().isEmpty()) {
				this.removeLeftChildOnlyNode(node);
			} else if (node.getLeft().isEmpty()) {
				this.removeRightChildOnlyNode(node);
			} else {
				T sucessorData = this.sucessor(node.getData()).getData();
				this.remove(sucessorData);
				node.setData(sucessorData);
			}
		}
	}

	private void removeLeftChildOnlyNode(BSTNode<T> node) {
		if (node == this.root) {
			this.root = this.getLeftOf(node);
			this.root.setParent(null);
		} else {
			node.getLeft().setParent(node.getParent());

			if (node.getData().compareTo(node.getParent().getData()) < 0) {
				node.getParent().setLeft(node.getLeft());
			} else {
				node.getParent().setRight(node.getLeft());
			}
		}
	}

	private void removeRightChildOnlyNode(BSTNode<T> node) {
		if (node == this.root) {
			this.root = this.getRightOf(node);
			this.root.setParent(null);
		} else {
			node.getRight().setParent(node.getParent());

			if (node.getData().compareTo(node.getParent().getData()) < 0) {
				node.getParent().setLeft(node.getRight());
			} else {
				node.getParent().setRight(node.getRight());
			}
		}
	}

	@Override
	public T[] preOrder() {
		return (T[]) this.preOrder(this.root).toArray(new Comparable[this.size()]);
	}

	private ArrayList<T> preOrder(BSTNode<T> current) {
		ArrayList<T> preOrder = new ArrayList<>();

		if (!current.isEmpty()) {
			preOrder.add(current.getData());
			preOrder.addAll(this.preOrder(this.getLeftOf(current)));
			preOrder.addAll(this.preOrder(this.getRightOf(current)));
		}

		return preOrder;
	}

	@Override
	public T[] order() {
		return (T[]) this.order(this.root).toArray(new Comparable[this.size()]);
	}

	private ArrayList<T> order(BSTNode<T> current) {
		ArrayList<T> order = new ArrayList<>();

		if (!current.isEmpty()) {
			order.addAll(this.order(this.getLeftOf(current)));
			order.add(current.getData());
			order.addAll(this.order(this.getRightOf(current)));
		}

		return order;
	}

	@Override
	public T[] postOrder() {
		return (T[]) this.postOrder(this.root).toArray(new Comparable[this.size()]);
	}

	private ArrayList<T> postOrder(BSTNode<T> current) {
		ArrayList<T> postOrder = new ArrayList<>();

		if (!current.isEmpty()) {
			postOrder.addAll(this.postOrder(this.getLeftOf(current)));
			postOrder.addAll(this.postOrder(this.getRightOf(current)));
			postOrder.add(current.getData());
		}

		return postOrder;
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

	private BSTNode<T> getLeftOf(BSTNode<T> node) {
		return (BSTNode<T>) node.getLeft();
	}

	private BSTNode<T> getRightOf(BSTNode<T> node) {
		return (BSTNode<T>) node.getRight();
	}

	private BSTNode<T> getParentOf(BSTNode<T> node) {
		return (BSTNode<T>) node.getParent();
	}

}
