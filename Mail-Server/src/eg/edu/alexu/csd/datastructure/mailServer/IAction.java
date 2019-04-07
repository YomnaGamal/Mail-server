package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62.Folder;

public interface IAction {

	public void status(String mail, Folder f);
	public void star(String mail, Folder f);
	public void restore(SLinkedList mails);
	public void unstar(String mail);
}
