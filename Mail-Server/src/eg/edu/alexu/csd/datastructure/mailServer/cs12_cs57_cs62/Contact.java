package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import eg.edu.alexu.csd.datastructure.mailServer.IContact;

public class Contact implements IContact {

	/**
	 * contact's name.
	 */
	private String name;
	/**
	 * contact's password.
	 */
	private String password;
	private String email;
	private String birthday;
	private String phoneNumber;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * get name of contact.
	 * 
	 * @return contact's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get password of contact.
	 * 
	 * @return contact's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set name of contact.
	 * 
	 * @param i
	 *            it is contact's name
	 */
	public void setName(final String na) {
		name = na;
	}

	/**
	 * set password of contact.
	 * 
	 * @param i1
	 *            it is contact's password
	 */
	public void setPassword(final String pass) {
		password = pass;
	}

	/**
	 * create folders of contact.
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void creatFolder() {
		File server = new File("Server");
		File c = new File(server, email);
		c.mkdir();
		File inbox = new File(c, "Inbox");
		inbox.mkdir();
		File index1 = new File(inbox, "indexFile.json");
		try {
			index1.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File sent = new File(c, "Sent");
		sent.mkdir();
		File index2 = new File(sent, "indexFile.json");
		try {
			index2.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File trash = new File(c, "Trash");
		trash.mkdir();
		File index3 = new File(trash, "indexFile.json");
		try {
			index3.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File draft = new File(c, "Drafts");
		draft.mkdir();
		File index4 = new File(draft, "indexFile.json");
		try {
			index4.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File starred = new File(c, "Starred");
		starred.mkdir();
		File index5 = new File(starred, "indexFile.json");
		try {
			index5.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File contacts = new File(c, "Contacts");
		contacts.mkdir();
		File information = new File(c, "Information.json");
		File folders = new File(c, "Folders.txt");
		try {
			folders.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		File filters = new File(c, "Filters.json");
		try {
			filters.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		obj.put("Password", password);
		obj.put("Phone number", phoneNumber);
		obj.put("Birthday", birthday);
		obj.put("Name", name);
		try (FileWriter file = new FileWriter(information)) {
			file.write(obj.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkMailValidity(String mail) {
		for (int i = 0; i < mail.length(); i++) {
			if (mail.charAt(i) == ' ' || mail.charAt(i) == '"' || mail.charAt(i) == '*' || mail.charAt(i) == '\\'
					|| mail.charAt(i) == '<' || mail.charAt(i) == '/' || mail.charAt(i) == '>' || mail.charAt(i) == '?'
					|| mail.charAt(i) == ':' || mail.charAt(i) == '|') {
				return false;
			}
		}
		for (int i = 0; i < mail.length(); i++) {
			if (mail.charAt(i) == '@') {
				String temp1 = mail.substring(i, mail.length());
				if (temp1.equals("@mail.com")) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkPhoneValidity(String phone) {
		if (phone.length() != 11) {
			return false;
		}
		if (phone.charAt(0) != '0' || phone.charAt(1) != '1') {
			return false;
		}
		char c = phone.charAt(2);
		if (c != '0' && c != '1' && c != '2' && c != '5' ) {
			return false;
		}
		for (int i = 3; i < phone.length(); i++) {
			if (phone.charAt(i) < '0' || phone.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
}