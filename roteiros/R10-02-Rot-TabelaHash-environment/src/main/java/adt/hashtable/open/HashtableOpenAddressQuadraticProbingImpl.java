package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (element != null && this.indexOf(element) == -1) {
			int probe = 0;

			while (probe < this.table.length) {
				int hash = this.getHashOf(element, probe);

				if (this.table[hash] == null || this.table[hash] instanceof DELETED) {
					this.table[hash] = element;
					this.elements++;
					break;
				}

				probe++;
				this.COLLISIONS++;
			}

			if (probe == this.table.length) {
				throw new HashtableOverflowException();
			}
		}
	}

	@Override
	public void remove(T element) {
		int index = this.indexOf(element);

		if (index != -1) {
			this.table[index] = this.deletedElement;
			this.elements--;
		}
	}

	@Override
	public T search(T element) {
		T output = null;

		if (this.indexOf(element) != -1) {
			output = element;
		}

		return output;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;

		if (element != null) {
			int probe = 0;

			while (probe < this.table.length) {
				int hash = this.getHashOf(element, probe);

				if (this.table[hash] == null) {
					break;
				}

				if (this.table[hash].equals(element)) {
					index = hash;
					break;
				}

				probe++;
			}
		}

		return index;
	}

	private int getHashOf(T element, int probe) {
		return ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, probe);
	}
}
