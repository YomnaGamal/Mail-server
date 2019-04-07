package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.IOException;

public interface IContact {
/**
 * set name of contact.
 * @param i it is contact's name
 */
	void setName(String i);
	/**
	 * set password of contact.
	 * @param i1 it is contact's password
	 */
	void setPassword(String i1);
	/**
	 * get password of contact.
	 * @return contact's password
	 */
	String getPassword();
	/**
	 * get name of contact.
	 * @return contact's name
	 */
	String getName();
	/**
	 * creat folders of contact.
	 * @throws IOException 
	 */
	void creatFolder();
}
