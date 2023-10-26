package adt.bst;

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

	private boolean isBST(BSTNode<T> current) {
		boolean isBST = true;

		if (!current.isEmpty()) {
			if (!current.getLeft().isEmpty()) {
				if (current.getData().compareTo(current.getLeft().getData()) < 0) {
					isBST = false;
				}
			}

			if (!current.getRight().isEmpty()) {
				if (current.getData().compareTo(current.getRight().getData()) > 0) {
					isBST = false;
				}
			}

			isBST = isBST((BSTNode<T>) current.getLeft()) && isBST((BSTNode<T>) current.getRight());
		}

		return isBST;
	}
	
}
