package eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
/**
 * @author Y
 *
 */
public class ArrayBased implements IQueue, IArrayBased {

	/**
	 * @param f front element.
	 */
	int f = 0;
	/**
	 * @param r rear element.
	 */
	int r = 0;
	/**
	 * @param size of queue.
	 */
	int size = 0;
	/**
	 * @param noE number of elements.
	 */
	int noE;
	/**
	 * @param queue array of objects.
	 */
	Object[] queue;
	/**
	 * @method ArrayBased to intialize the size of array.
	 * @param n for number of elements.
	 */
	public ArrayBased(final int n) {
		noE = n;
		queue = new Object[noE];
	}

	@Override
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		if (size == noE) {
			throw new RuntimeException();
		}
		queue[r] = item;
		if (r == noE - 1) {
			r = 0;
		} else {
			r++;
		}
		size++;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new RuntimeException();
		}
		Object temp = queue[f];
		queue[f] = null;
		if (f == noE - 1) {
			f = 0;
		} else {
			f++;
		}
		size--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
