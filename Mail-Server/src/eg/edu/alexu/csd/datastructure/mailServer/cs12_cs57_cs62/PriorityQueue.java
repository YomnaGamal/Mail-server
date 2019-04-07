package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import eg.edu.alexu.csd.datastructure.mailServer.IPriorityQueue;

/**
 * .
 *
 * @author Y
 *
 */
public class PriorityQueue implements IPriorityQueue {

	/**
	 * . size of priority queue
	 */
	int size = 0;
	/**
	 * . the lowest key priority
	 */
	Element head = new Element();
	/**
	 * . the highest key priority
	 */
	Element tail = new Element();

	@Override
	public void insert(final Object item, final int key) {
		// TODO Auto-generated method stub
		if (key <= 0 || key > Integer.MAX_VALUE) {
			throw new RuntimeException();
		}
		Element x = new Element();
		x.key = key;
		x.item = item;
		Element temp = head;
		if (size == 0) {
			head = x;
			tail = x;
			x.next = null;
		} else if (size == 1) {
			if (temp.key < x.key) {
				x.next = null;
				tail = x;
				head.next = x;
			} else {
				tail = temp;
				temp.next = null;
				head = x;
				x.next = temp;
			}
		} else {
			if (x.key < head.key) {
				x.next = head;
				head = x;
			} else if (x.key > tail.key) {
				tail.next = x;
				tail = x;
				tail.next = null;
			} else {
				while (temp.key <= x.key && temp.next != null) {
					if (temp.next.key > x.key) {
						break;
					}
					temp = temp.next;
				}
				x.next = temp.next;
				temp.next = x;
			}
		}
		size++;

	}

	@Override
	public Object removeMin() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new RuntimeException();
		}
		Object min = head.item;
		head = head.next;
		size--;
		return min;
	}

	@Override
	public Object min() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new RuntimeException();
		}
		return head.item;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
