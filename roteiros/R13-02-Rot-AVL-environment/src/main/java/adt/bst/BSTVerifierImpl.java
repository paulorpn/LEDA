package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		boolean isBST = false;;

		if (bst != null) {
			isBST = isBST(bst.getRoot());
		}

		return isBST;
	}

	private boolean isBST(BSTNode<T> currentNode) {
		boolean isBST = true;

		if (!currentNode.isEmpty()) {
			if (isValidLeftNode(currentNode) && isValidRightNode(currentNode)) {
				isBST = isBST((BSTNode<T>) currentNode.getLeft())
						&& isBST((BSTNode<T>) currentNode.getRight());
			} else {
				isBST = false;
			}
		}

		return isBST;
	}

	private boolean isValidRightNode(BSTNode<T> currentNode) {
		return isValidRightNode(currentNode.getRight(), currentNode);
	}

	private boolean isValidRightNode(BTNode<T> right, BSTNode<T> currentNode) {
		boolean isValidRightNode = true;

		if (!right.isEmpty()) {
			if (right.getData().compareTo(currentNode.getData()) > 0) {
				isValidRightNode = isValidRightNode(right.getLeft(), currentNode)
						&& isValidRightNode(right.getRight(), currentNode);
			} else {
				isValidRightNode = false;
			}
		}
		return isValidRightNode;
	}

	private boolean isValidLeftNode(BTNode<T> currentNode) {
		return isValidLeftNode(currentNode.getLeft(), currentNode);
	}

	private boolean isValidLeftNode(BTNode<T> left, BTNode<T> currentNode) {
		boolean result = true;
		if (!left.isEmpty()) {
			if (left.getData().compareTo(currentNode.getData()) < 0) {
				result = isValidLeftNode(left.getLeft(), currentNode)
						&& isValidLeftNode(left.getRight(), currentNode);
			} else {
				result = false;
			}
		}
		return result;

	}
	
}
