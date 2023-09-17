package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class QueueUsingStackTest {
    
    public QueueUsingStack<Integer> queue1;
	public QueueUsingStack<Integer> queue2;
	public QueueUsingStack<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueUsingStack<>(4);
		queue2 = new QueueUsingStack<>(2);
		queue3 = new QueueUsingStack<>(2);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
        assertEquals(new Integer(1), queue1.head());
		assertEquals(null, queue3.head());
	}

	@Test
	public void testIsEmpty() {
        try {
			assertEquals(new Integer(1), queue1.dequeue());
            assertEquals(new Integer(2), queue1.dequeue());
            assertEquals(new Integer(3), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(queue1.isEmpty());
		assertFalse(queue2.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @Test
	public void testEnqueueElementoNulo() {
		try {
			queue3.enqueue(null);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        assertTrue(queue3.isEmpty());
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}
}