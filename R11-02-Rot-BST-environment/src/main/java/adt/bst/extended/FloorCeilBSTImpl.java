package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;

		if (array != null) {
			this.insertElements(array, 0);
			floor = this.floor(this.root, numero, floor);
		}

		return floor;
	}
	
	private Integer floor(BSTNode<Integer> current, Double numero, Integer floor) {
		if (!current.isEmpty()) {
			if (current.getData() < numero) {
				floor = this.floor((BSTNode<Integer>) current.getRight(), numero, current.getData());
			} else if (current.getData() > numero) {
				floor = this.floor((BSTNode<Integer>) current.getLeft(), numero, floor);
			} else {
				floor = current.getData();
			}
		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;

		if (array != null) {
			this.insertElements(array, 0);
			ceil = this.ceil(this.root, numero, ceil);
		}
		
		return ceil;
	}

	private Integer ceil(BSTNode<Integer> current, double numero, Integer ceil) {
		if (!current.isEmpty()) {
			if (current.getData() > numero) {
				ceil = this.ceil((BSTNode<Integer>) current.getLeft(), numero, current.getData());
			} else if (current.getData() < numero) {
				ceil = this.ceil((BSTNode<Integer>) current.getRight(), numero, ceil);
			} else {
				ceil = current.getData();
			}
		}

		return ceil;
	}

	private void insertElements(Integer[] array, int i) {
		if (i < array.length) {
			this.insert(array[i]);
			this.insertElements(array, i + 1);
		}
	}

}
