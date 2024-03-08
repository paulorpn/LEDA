package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int capacidade;

	public CircularQueue(int size) {
		this.array = (T[]) new Object[size];
		this.head = -1;
		this.tail = -1;
		this.capacidade = size;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		if (element != null) {
			if (isEmpty()) {
				this.head = 0;
				this.tail = 0;
				this.array[0] = element;
			} else {
				this.tail = (tail + 1) % this.capacidade;
				this.array[tail] = element;
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		T value = array[head];

		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (head + 1) % this.capacidade;
		}

		return value;
	}

	@Override
	public T head() {
		T value = null;
		
		if (!isEmpty()) {
			value = array[head];
		}

		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.head == -1;
	}

	@Override
	public boolean isFull() {
		return (this.tail + 1) % this.capacidade == this.head;
	}

}
