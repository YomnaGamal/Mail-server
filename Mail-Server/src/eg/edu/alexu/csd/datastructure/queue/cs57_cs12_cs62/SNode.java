package eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62;
/**
 * @author Y
 *
 */
public class SNode {
	/**
	 * @param element value.
	 */
	Object element;
	/**
	 * @param next node.
	 */
	 SNode next;
	/**
	 * Constructor that creates a node with given fields.
	 * @param data of node
	 * @param nex is next node
	 */
	public SNode(final Object data, final SNode nex) {
		element = data;
		next = nex;
	}
	/**
	 * Returns the element of this node.
	 * @return element value.
	 */
	public Object getElement() {
		return element;
	}
	/**
	 * Returns the next node of this node.
	 * @return next node
	 */
	public SNode getnext() {
		return next;
	}
	/**
	 * sets the element of this node.
	 * @param data of element
	 */
	public void setElement(final Object data) {
		element = data;
	}
	/**
	 * sets the next node of this node.
	 * @param nex the next node
	 */
	public void setNext(final SNode nex) {
		next = nex;
	}
}
