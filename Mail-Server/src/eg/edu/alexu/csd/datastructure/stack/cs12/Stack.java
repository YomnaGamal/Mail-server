package eg.edu.alexu.csd.datastructure.stack.cs12;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;

/**.
 *
 * @author LENOVO
 *
 */
public class Stack implements IStack {

	/**.
	 * Single linked list for stack implementation
	 */
	public SLinkedList stack = new SLinkedList();
	/**.
	 * Size of the stack
	 */
	public int size;

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (size != 0) {
			Object x = stack.get(0);
			stack.remove(0);
			size--;
			return x;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (size != 0) {
			Object x = stack.get(0);
			return x;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public void push(final Object element) {
		// TODO Auto-generated method stub
		stack.add(0, element);
		size++;
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
