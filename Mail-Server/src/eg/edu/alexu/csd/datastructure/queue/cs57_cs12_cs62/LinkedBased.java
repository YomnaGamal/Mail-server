package eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62;

import java.util.EmptyStackException;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author N
 *
 */
public class LinkedBased implements IQueue, ILinkedBased {
	/**
	 * @param size
	 *            of queue.
	 */
	private int size;
	/**
	 * @param head
	 *            of queue.
	 */
	private SNode head;
	/**
	 * @param tail
	 *            of queue.
	 */
	private SNode tail;

	/**
	 * constructor that creates an empty queue.
	 */
	public LinkedBased() {
		size = 0;
		tail = new SNode(null, null);
		head = new SNode(null, null);
		head.setNext(tail);
	}

	/**
	 * Inserts an item at the queue front.
	 */
	@Override
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		SNode node = new SNode(null, null);
		node.setElement(item);
		node.setNext(null); // node will be new tail node
		if (size == 0) {
			head = node; // special case of a previously empty queue
		} else {
			tail.setNext(node); // add node at the tail of the list
		}
		tail = node; // update the reference to the tail node
		size++;
	}

	/**
	 * Removes the object at the queue rear and returns it.
	 */
	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object tmp = head.getElement();
		head = head.getnext();
		size--;
		if (size == 0) {
			tail = null; // the queue is now empty
		}
		return tmp;
	}

	/**
	 * Tests if this queue is empty.
	 * @return empty or not
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	/**.
	 * Returns the number of elements in the queue
	 * @return size of queue
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
