package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null) {
			try {
				this.stack1.push(element);
			} catch (StackOverflowException sofe) {
				throw new QueueOverflowException();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		try {
			this.disloadStack1();
			T value = this.stack2.pop();
			this.reloadStack1();

			return value;
		} catch (StackUnderflowException sufe) {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		this.disloadStack1();
		T value = this.stack2.top();
		this.reloadStack1();

		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

	// This method sends all the elements from Stack1 to Stack2
	private void disloadStack1() {
		while (!this.stack1.isEmpty()) {
			try {
				T value = this.stack1.pop();
				try {
					this.stack2.push(value);
				} catch (StackOverflowException sofe) {}
			} catch (StackUnderflowException sufe) {}
		}
	}

	// This method sends all the elements back to Stack1
	private void reloadStack1() {
		while (!this.stack2.isEmpty()) {
			try {
				T value = this.stack2.pop();
				try {
					this.stack1.push(value);
				} catch (StackOverflowException sofe) {}
			} catch (StackUnderflowException sufe) {}
		}
	}

}
