package eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**.
 * Class of double linked list
 * @author LENOVO
 *
 */
public class DLinkedList implements ILinkedList {

	/**.
	 * Head of the list
	 */
	public DNode head;
	/**.
	 * Tail of the list
	 */
	public DNode tail;
	/**.
	 * Size of the list
	 */
	public int size;

	/**.
	 * Constructor of DLinkedList
	 */
	public DLinkedList() {
		head = new DNode();
		tail = new DNode();
		size = 0;
		head.element = null;
		head.next = tail;
		head.prev = null;
		tail.element = null;
		tail.prev = head;
		tail.next = null;
	}

	/**.
	 * Add element in an index to the list
	 * @param index
	 * @param element
	 * @throws RuntimeException
	 *
	 */
	@Override
	public void add(final int index,
			final Object element) {
		// TODO Auto-generated method stub
		if (index > size || index < 0) {
			throw new RuntimeException();
		}
		if (index == size) {
			DNode x = new DNode();
			x.element = element;
			x.next = tail;
			tail.prev.next = x;
			x.prev = tail.prev;
			tail.prev = x;
			size++;
		} else {
			DNode x = new DNode();
			x.element = element;
			DNode v = new DNode();
			v = head;
			for (int i = 0; i < index; i++) {
				v = v.next;
			}
			x.next = v.next;
			v.next = x;
			x.prev = v;
			v.next.prev = x;
			size++;
		}
	}

	/**.
	 * Add element to the end of the list
	 * @param element
	 */
	@Override
	public void add(final Object element) {
		// TODO Auto-generated method stub
		/*DNode x = new DNode();
		x.element = element;
		DNode v = new DNode();
		v = head;
		for (int i = 0; i < size(); i++) {
			v = v.next;
		}
		x.next = v.next;
		v.next = x;
		x.prev = v;
		v.next.prev = x;
		size++;*/
		DNode x = new DNode();
		x.element = element;
		x.next = tail;
		tail.prev.next = x;
		x.prev = tail.prev;
		tail.prev = x;
		size++;
	}

	/**.
	 * Get element in the list with index
	 * @param index
	 * @return value of the node
	 * @throws RuntimeException
	 */
	@Override
	public Object get(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new RuntimeException();
		} else {
			DNode v = new DNode();
			v = head.next;
			for (int i = 0; i < index; i++) {
				v = v.next;
			}
			return v.element;
		}
	}

	/**.
	 * Set the value of a node
	 * @param index
	 * @param element
	 */
	@Override
	public void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index >= size) {
			throw new RuntimeException();
		} else {
			DNode v = new DNode();
			v = head.next;
			for (int i = 0; i < index; i++) {
				v = v.next;
			}
			v.element = element;
		}
	}

	/**.
	 * Clear the list
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**.
	 * Check if the list is Empty
	 * @return true or false
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	/**.
	 * Remove element from the list by index
	 * @param index
	 */
	@Override
	public void remove(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new RuntimeException();
		} else {
			DNode v = new DNode();
			v = head;
			for (int i = 0; i < index; i++) {
				v = v.next;
			}
			DNode x = new DNode();
			x = v.next;
			v.next = x.next;
			v.next.prev = v;
			size--;
		}
	}

	/**.
	 * @return the size of the list
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	/**.
	 * Get a sublist
	 * @param fromIndex
	 * @param toIndex
	 * @return subList
	 * @throws RuntimeExceoption
	 */
	@Override
	public ILinkedList sublist(final int fromIndex,
			final int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex < 0 || fromIndex >= size
				|| toIndex >= size || toIndex < 0) {
			throw new RuntimeException();
		}
		DLinkedList subList = new DLinkedList();
		DNode v = new DNode();
		v = head;
		for (int i = 0; i <= fromIndex; i++) {
			v = v.next;
		}
		for (int i = fromIndex; i <= toIndex; i++) {
			subList.add(v.element);
			v = v.next;
		}
		return subList;
	}

	/**.
	 * Check if the list contains an element
	 * @param o
	 * @return true or false
	 */
	@Override
	public boolean contains(final Object o) {
		// TODO Auto-generated method stub
		DNode v = new DNode();
		v = head.next;
		while (v != tail) {
			if (o.equals(v.element)) {
				return true;
			}
			v = v.next;
		}
		return false;
	}

}
