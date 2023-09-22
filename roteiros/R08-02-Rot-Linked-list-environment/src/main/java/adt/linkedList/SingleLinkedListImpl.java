package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		SingleLinkedListNode<T> auxNode = this.head;
		int size = 0;

		while (!auxNode.isNIL()) {
			size += 1;
			auxNode = auxNode.getNext();
		}


		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxNode = this.head;
		
		while (!auxNode.isNIL() && !auxNode.getData().equals(element)) {
			auxNode = auxNode.getNext();
		}

		return auxNode.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<>());

			if (this.isEmpty()) {
				this.setHead(newNode);
			} else {
				this.getLast().setNext(newNode);
			}
		}
	}

	private SingleLinkedListNode<T> getLast() {
		SingleLinkedListNode<T> auxNode = this.head;

		while (!auxNode.getNext().isNIL()) {
			auxNode = auxNode.getNext();
		}

		return auxNode;
	}

	@Override
	public void remove(T element) {
		if (this.search(element) != null) {
			SingleLinkedListNode<T> node = new SingleLinkedListNode<T>();
			node.setData(element);

			if (this.head.equals(node)) {
				this.head = this.head.getNext();
			} else {
				SingleLinkedListNode<T> auxNode = this.head.getNext();

				while (!auxNode.equals(node)) {
					auxNode = auxNode.getNext();
				}
				
				this.getPrevious(auxNode).setNext(auxNode.getNext()); 
			}
		}
	}

	private SingleLinkedListNode<T> getPrevious(SingleLinkedListNode<T> node) {
		SingleLinkedListNode<T> auxNode = this.head;

		while (!auxNode.getNext().equals(node)) {
			auxNode = auxNode.getNext();
		}

		return auxNode;
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxNode = this.head;

		for (int i = 0; i < array.length; i++) {
			array[i] = auxNode.getData();
			auxNode = auxNode.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
