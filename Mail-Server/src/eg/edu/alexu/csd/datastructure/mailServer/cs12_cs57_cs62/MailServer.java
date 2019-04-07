package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IApp;
import eg.edu.alexu.csd.datastructure.mailServer.IContact;
import eg.edu.alexu.csd.datastructure.mailServer.IFilter;
import eg.edu.alexu.csd.datastructure.mailServer.IFolder;
import eg.edu.alexu.csd.datastructure.mailServer.IMail;
import eg.edu.alexu.csd.datastructure.mailServer.ISort;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;

/**
 * .
 *
 * @author LENOVO
 *
 */
public class MailServer implements IApp {

	private File server;
	private File contacts;
	public String currentContact;
	public String currentFolderName;
	public File currentFolder;
	public DLinkedList mails;
	Functions functions = new Functions();

	/**
	 * put name of new contact into File contacts.
	 *
	 * @param contact
	 * @throws IOException
	 */
	public void setName(IContact contact) throws IOException {
		BufferedWriter fw = new BufferedWriter(new FileWriter(contacts, true));
		fw.write(contact.getName());
		fw.newLine();
		fw.close();
	}

	/**
	 * create server.
	 */
	public MailServer() {
		server = new File("Server");
		if (!server.exists()) {
			server.mkdir();
			contacts = new File("Server/Contacts.txt");
			try {
				contacts.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			contacts = new File("Server/Contacts.txt");
		}
	}

	@Override
	public boolean signin(final String email, final String password) {
		// TODO Auto-generated method stub
		// check in index of server of this email.
		if (functions.findDir(server, email) != null) {
			JSONParser parser = new JSONParser();
			String pa = null;
			try {
				Object obj = parser.parse(new FileReader("Server/" + email + "/Information.json"));
				JSONObject jsonObject = (JSONObject) obj;
				pa = (String) jsonObject.get("Password");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (password.equals(pa)) {
				currentContact = email;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		// then if it is exist check of password.
		// if password wrong print masseg.
	}

	@Override
	public boolean signup(final IContact contact) {
		// TODO Auto-generated method stub
		String name = contact.getName();
		// check if name be in index file of server or not.
		if (functions.findDir(server, name) != null) {
			return false;
		} else {
			contact.creatFolder();
			try {
				setName(contact);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}

	@Override
	public void setViewingOptions(final IFolder folder, final IFilter filter, final ISort sort) {
		// TODO Auto-generated method stub
		Folder current = (Folder) folder;
		current.setContact(currentContact);
		currentFolderName = current.getFolder();
		currentFolder = current.selectedFolder();
		Sort s = (Sort) sort;
		if (filter != null) {
			Filter f = (Filter) filter;
			f.setSearchIn(currentFolder);
			mails = f.filter();
			s.setMails(mails);
			s.setFilter(true);
			mails = s.sort();
		} else {
			s.setFilter(false);
			s.setCurrent(currentFolder);
			mails = s.sort();
		}
	}

	@Override
	public IMail[] listEmails(final int page) {
		// TODO Auto-generated method stub
		Mail[] m;
		if (page * 10 <= mails.size()) {
			 m = new Mail[10];
		} else {
			 m = new Mail[mails.size() % 10];
		}
		int start = 0;
		/*double num = mails.size() / 10;
		num = Math.ceil(num);
		int n = (int) num; 
		System.out.println(num);
		System.out.println(n);
		if (page > n) {
			return null;
		}*/
		for (int i = 1; i < page; i++) {
			start += 10;
		}
		int end = start + 10;
		if (end >= mails.size()) {
			end = mails.size();
		}
		int k = 0;
		for (int i = start; i < end; i++) {
			Mail x = (Mail) mails.get(i);
			m[k] = x;
			k++;
		}
		return m;
	}

	@Override
	public void deleteEmails(final ILinkedList mails) {
		// TODO Auto-generated method stub
		Folder t = new Folder();
		t.setFolder("Trash");
		t.setContact(currentContact);
		File trash = t.selectedFolder();
		SLinkedList m = (SLinkedList) mails;
		if (currentFolderName.equals("Trash")) {
			for (int i = 0; i < m.size(); i++) {
				File x = functions.findDir(trash, (String) m.get(i)); 
				x.delete();
			}
		} else {
			indexFiles(currentFolder, trash, m, true);
			for (int i = 0; i < m.size(); i++) {
				Mail y = (Mail) m.get(i);
				File x = functions.findDir(currentFolder, y.getName());
				File temp = new File(trash.getPath(), y.getName());
				try {
					Files.move(Paths.get(x.getPath()), Paths.get(temp.getPath()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void moveEmails(final ILinkedList mails, final IFolder des) {
		// TODO Auto-generated method stub
		Folder to = (Folder) des;
		to.setContact(currentContact);
		File y = to.selectedFolder();
		SLinkedList m = (SLinkedList) mails;
		indexFiles(currentFolder, y, m, false);
		for (int i = 0; i < m.size(); i++) {
			Mail z = (Mail) m.get(i);
			File x = functions.findDir(currentFolder, z.getName());
			File temp = new File(y.getPath(), z.getName());
			try {
				Files.move(Paths.get(x.getPath()), Paths.get(temp.getPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean compose(final IMail email) {
		// TODO Auto-generated method stub
		Mail e = (Mail) email;
		if (e.getSubject() == null || e.getSubject().length() == 0) {
			e.setSubject("No subject");
		}
		File user = functions.findDir(server, currentContact);
		File folders = functions.findFile(user, "Folders.txt");
		File filters = functions.findFile(user, "Filters.json");
		e.setFilters(filters);
		e.setFolders(folders);
		e.setSender(currentContact);
		e.inbox();
		e.sent();
		LinkedBased errors = e.getErrors();
		if (errors.size() == 0) {
			return true;
		}
		return false;
	}

	public void draft(final Mail email) {
		email.setSender(currentContact);
		email.draft();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void indexFiles(File current, File des, SLinkedList mails, boolean trash) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = new Date();
		String date = dateFormat.format(d);
		File desIndex = functions.findFile(des, "indexFile.json");
		File currentIndex = functions.findFile(current, "indexFile.json");
		DLinkedList maps = new DLinkedList();
		Object obj;
		try {
			obj = new JSONParser().parse(new FileReader(currentIndex.getPath()));
			JSONObject j = (JSONObject) obj;
			for (int i = 0; i < mails.size(); i++) {
				Mail m = (Mail) mails.get(i);
				String n = m.getName();
				Map x = (Map) j.get(n);
				if (trash) {
					x.put("deletionDate", date);
					x.put("Folder", currentFolderName);
				}
				//x.put("newDate", "date");
				maps.add(x);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SLinkedList temp = new SLinkedList();
		File[] f = des.listFiles();
		for (int i = 0; i < f.length; i++) {
			if (f[i].isDirectory()) {
				temp.add(f[i].getName());
			}
		}
		if (temp.size() != 0) {
			try {
				obj = new JSONParser().parse(new FileReader(desIndex.getPath()));
				JSONObject jo = (JSONObject) obj;
				for (int i = 0; i < temp.size(); i++) {
					Map x = (Map) jo.get((String) temp.get(i));
					maps.add(x);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JSONObject jw = new JSONObject();
		for (int i = 0; i < maps.size(); i++) {
			Map x = (Map) maps.get(i);
			String name = (String) x.get("Name");
			jw.put(name, x);
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(desIndex.getPath());
			pw.write(jw.toJSONString());
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SLinkedList ckeck() {
		File f = functions.findDir(server, currentContact);
		File cf = functions.findFile(f, "Folders.txt");
		SLinkedList names = new SLinkedList();
		if (cf.length() != 0) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(cf.getPath()));
				String line;
				try {
					while ((line = br.readLine()) != null) {
						names.add(line);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return names;
	}
	
	@SuppressWarnings("unchecked")
	public boolean changePassword(String email, String oldpassword, String newpassword) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		String pa = null;
		String phonenum = null;
		String birthday = null;
		String name = null;
		boolean flag;
		try {
			Object objc = parser.parse(new FileReader("Server/" + email + "/Information.json"));
			JSONObject jsonObject = (JSONObject) objc;
			pa = (String) jsonObject.get("Password");
			if (!oldpassword.equals(pa)) {
				return false;
			} else {
				currentContact = email;
				flag = true;
				phonenum = (String) jsonObject.get("Phone number");
				birthday = (String) jsonObject.get("Birthday");
				name = (String) jsonObject.get("Name");
				pa = newpassword;
				JSONObject obj = new JSONObject();
				obj.put("Password", pa);
				obj.put("Phone number", phonenum);
				obj.put("Birthday", birthday);
				obj.put("Name", name);
				try (FileWriter file = new FileWriter("Server/" + email + "/Information.json")) {
					file.write(obj.toJSONString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
