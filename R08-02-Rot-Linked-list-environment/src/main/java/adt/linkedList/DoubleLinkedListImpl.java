package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<>();
		this.head = last;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element,
			 new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());

			if (this.isEmpty()) {
				this.head = newNode;
				this.last = newNode;
			} else {
				newNode.setNext(this.getHead());
				((DoubleLinkedListNode<T>) this.head).setPrevious(newNode);
				this.head = newNode;
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element,
				 new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());

			if (this.isEmpty()) {
				this.head = newNode;
				this.last = newNode;
			} else {
				this.last.setNext(newNode);
				newNode.setPrevious(this.last);
				this.last = newNode;
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.head.equals(last)) {
				this.head = new DoubleLinkedListNode<>();
				this.last = new DoubleLinkedListNode<>();
			} else {
				((DoubleLinkedListNode<T>) this.head.getNext()).setPrevious(new DoubleLinkedListNode<>());
				this.head = this.head.getNext();
			}
		}
	}

	@Override
	public void remove(T element) {
		if (this.search(element) != null) {
			if (this.head.getData().equals(element)) {
				this.removeFirst();

			} else if (this.last.getData().equals(element)) {
				this.removeLast();

			} else {
				DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.head.getNext();

				while (!auxNode.getData().equals(element)) {
					auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
				}
				
				auxNode.getPrevious().setNext(auxNode.getNext()); 
				((DoubleLinkedListNode<T>) auxNode.getNext()).setPrevious(auxNode.getPrevious());
			}
		}
	}

	@Override
	public void removeLast() {		
		if (!this.isEmpty()) {
			if (this.head.equals(last)) {
				this.head = new DoubleLinkedListNode<>();
				this.last = new DoubleLinkedListNode<>();
			} else {
				this.last.getPrevious().setNext(this.last.getNext());
				((DoubleLinkedListNode<T>) this.last.getNext()).setPrevious(this.last.getPrevious());
				this.last = this.last.getPrevious();
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
