package eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**.
 * @author ME
 *
 */
public class SLinkedList implements ILinkedList {
	/**
	 * @param head points to the first node
	 *
	 */
	public SNode head;
	/**
	 * @param size no. of elements
	 *
	 */
	public int size;
	/**
	 * @param tail points to the last node
	 *
	 */
	public SNode tail;
	/**
	 * @method SLinkedList
	 */
	public SLinkedList() {
		head = new SNode();
		tail = new SNode();
		tail.next = null;
		size = 0;
		head.next = tail;
		tail = null;
	}

	@Override
	public void add(final int index, final Object element) {
		if (index > size || index < 0) {
			throw new RuntimeException();
		} else {
			SNode x = new SNode();
	    	x.element = element;
	    	if (index == size) {
	    		if (size() == 0) {
	    			x.next = head.next;
	    			head.next = x;
	    			tail = x;
	    		} else {
	    			x.next = null;
	    			tail.next = x;
	    			tail = x;
	    		}
	    	} else {
	    		if (index == 0) {
					x.next = head.next;
					head.next = x;
				} else {
					int i = 0;
					SNode y = new SNode();
					y = head;
					while (i < index) {
						i++;
						y = y.next;
					}
					x.next = y.next;
					y.next = x;
				}
	    	}
	    	size++;
		}
	}

	@Override
	public void add(final Object element) {
		// TODO Auto-generated method stub
		SNode x = new SNode();
    	x.element = element;
		if (size() == 0) {
			x.next = head.next;
			head.next = x;
			tail = x;
		} else {
			x.next = null;
			tail.next = x;
			tail = x;
		}
		size++;
	}

	@Override
	public Object get(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new RuntimeException();
		}
		SNode y = new SNode();
		y = head;
		int i = 0;
		while (i < index + 1) { // mt8yreha4
			i++;
			y = y.next;
		}
		return y.element;
	}

	@Override
	public void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index > size - 1) {
			throw new RuntimeException();
		}
		int i = 0;
		SNode y = head.next;
		while (i < index) {
			i++;
			y = y.next;
		}
		y.element = element;
	}

	@Override
	public void clear() {
		size = 0;
		/*
		 * head.element = null; tail.element = null; head.next = tail;
		 */
		head = new SNode();
		tail = new SNode();
		head.next = tail;
		tail.next = null;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(final int index) {
		if (index > size - 1 || index < 0) {
			throw new RuntimeException();
		}
		int i = 0;
		SNode y = head;
		while (i < index) {
			i++;
			y = y.next;
		}
		y.next = y.next.next;
		size--;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex > size - 1 || fromIndex < 0) {
			throw new RuntimeException();
		}
		if (toIndex > size - 1 || toIndex < 0) {
			throw new RuntimeException();
		}
		int i = 0;
		SLinkedList sub = new SLinkedList();
		SNode y = head;
		while (i < fromIndex) {
			i++;
			y = y.next;
		}
		sub.head = y;
		while (i <= toIndex) {
			i++;
			y = y.next;
		}
		sub.tail = y;
		sub.size = toIndex - fromIndex + 1;
		return sub;
	}

	@Override
	public boolean contains(final Object o) {
		int i = 0;
		SNode y = head;
		while (i <= size) {
			if ((o).equals(y.element)) {
				return true;
			}
			y = y.next;
			i++;
		}
		return false;
	}
}
