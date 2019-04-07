package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;

public interface ISort {

	public DLinkedList sort();
	public void defaultSort();
	public void read();
	public void priority();
	public void starred();
	public void quickSort(int low, int high);
}
