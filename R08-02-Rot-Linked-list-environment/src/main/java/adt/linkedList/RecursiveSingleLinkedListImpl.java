package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		}

		return this.next.size() + 1;
	}

	@Override
	public T search(T element) {
		T found = null;

		if (element != null) {
			if (this.isEmpty() || this.data.equals(element)) {
				found = this.data;
			} else {
				return this.next.search(element);
			}
		}

		return found;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<>();
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {
			if (this.data.equals(element)) {
				this.data = this.next.getData();
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		} 
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		this.recursiveToArray(array, 0);
		return array;
	}

	private void recursiveToArray(T[] array, int i) {
		if (!this.isEmpty()) {
			array[i] = this.data;
			this.next.recursiveToArray(array, i + 1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
