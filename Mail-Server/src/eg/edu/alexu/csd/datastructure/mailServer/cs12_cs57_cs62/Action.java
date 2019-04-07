package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IAction;

public class Action implements IAction {

	private String contact;
	private boolean visited = false;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void status(String mail, Folder f) {
		// TODO Auto-generated method stub
		File current = f.selectedFolder();
		File index = findFile(current, "indexFile.json");
		File[] list = current.listFiles();
		SLinkedList mails = new SLinkedList();
		SLinkedList maps = new SLinkedList();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				mails.add(list[i].getName());
			}
		}
		Object obj;
		try {
			obj = new JSONParser().parse(new FileReader(index.getPath()));
			JSONObject j = (JSONObject) obj;
			for (int i = 0; i < mails.size(); i++) {
				String s = (String) mails.get(i);
				Map x = (Map) j.get(s);
				if (s.equals(mail)) {
					x.put("Status", "Read");
				}
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
		JSONObject jw = new JSONObject();
		for (int i = 0; i < maps.size(); i++) {
			Map x = (Map) maps.get(i);
			String name = (String) x.get("Name");
			jw.put(name, x);
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(index.getPath());
			pw.write(jw.toJSONString());
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!visited) {
			visited = true;
			File server = new File("Server");
			File user = findDir(server, f.getContact());
			File starred = findDir(user, "Starred");
			if (findDir(starred, mail) != null) {
				Folder temp = new Folder();
				temp.setFolder("Starred");
				status(mail, temp);
			}
		} else {
			visited = false;
		}
	}

	@Override
	public void star(String mail, Folder f) {
		// TODO Auto-generated method stub
		File current = f.selectedFolder();
		Folder des = new Folder();
		des.setFolder("Starred");
		des.setContact(f.getContact());
		File starred = des.selectedFolder();
		currentIndex(current, mail, starred);
		File x = findDir(current, mail);
		File temp = new File(starred.getPath(), mail);
		try {
			Files.copy(Paths.get(x.getPath()), Paths.get(temp.getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void currentIndex(File current, String mail, File starred) {
		File index = findFile(current, "indexFile.json");
		DLinkedList maps = new DLinkedList();
		try {
			Object obj = new JSONParser().parse(new FileReader(index.getPath()));
			JSONObject j = (JSONObject) obj;
			Map x = (Map) j.get(mail);
			x.remove("Starred");
			x.put("Folder", current.getName());
			desIndex(starred, x);
			x.remove("Folder");
			x.put("Starred", "True");
			maps.add(x);
			File[] list = current.listFiles();
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					String s = list[i].getName();
					if (!s.equals(mail)) {
						Map y = (Map) j.get(s);
						maps.add(y);
					}
				}
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
		JSONObject jw = new JSONObject();
		for (int i = 0; i < maps.size(); i++) {
			Map x = (Map) maps.get(i);
			String name = (String) x.get("Name");
			jw.put(name, x);
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(index.getPath());
			pw.write(jw.toJSONString());
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void desIndex(File des, Map mail) {
		File index = findFile(des, "indexFile.json");
		DLinkedList maps = new DLinkedList();
		maps.add(mail);
		File[] list = des.listFiles();
		if (index.length() != 0) {
			try {
				Object obj = new JSONParser().parse(new FileReader(index.getPath()));
				JSONObject j = (JSONObject) obj;
				for (int i = 0; i < list.length; i++) {
					if (list[i].isDirectory()) {
						String s = list[i].getName();
						if (!s.equals(mail.get("Name")) ) {
							Map x = (Map) j.get(s);
							maps.add(x);
						}
					}
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
			pw = new PrintWriter(index.getPath());
			pw.write(jw.toJSONString());
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void restore(SLinkedList mails) {
		// TODO Auto-generated method stub
		File server = new File("Server");
		File user = findDir(server, contact);
		File trash = findDir(user, "Trash");
		File index = findFile(trash, "indexFile.json");
		try {
			Object obj = new JSONParser().parse(new FileReader(index.getPath()));
			JSONObject j = (JSONObject) obj;
			for (int i = 0; i < mails.size(); i++) {
				Map x = (Map) j.get((String) mails.get(i));
				String folder = (String) x.get("Folder");
				x.remove("Folder");
				x.remove("deletionDate");
				File des = findDir(user, folder);
				desIndex(des, x);
				File y = findDir(trash, (String) mails.get(i));
				File temp = new File(des.getPath(), (String) mails.get(i));
				try {
					Files.move(Paths.get(y.getPath()), Paths.get(temp.getPath()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void unstar(String mail) {
		// TODO Auto-generated method stub
		File server = new File("Server");
		File user = findDir(server, contact);
		File starred = findDir(user, "Starred");
		File index = findFile(starred, "indexFile.json");
		Object obj;
		try {
			obj = new JSONParser().parse(new FileReader(index.getPath()));
			JSONObject j = (JSONObject) obj;
			Map x = (Map) j.get(mail);
			String folder = (String) x.get("Folder");
			x.remove("Folder");
			x.put("Starred", "False");
			File des = findDir(user, folder);
			desIndex(des, x);
			File y = findDir(starred, mail);
			y.delete();
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

	public File findDir(File dir, String name) {
		File[] f = dir.listFiles();
		if (f != null) {
			for (int i = 0; i < f.length; i++) {
				if (f[i].isDirectory()) {
					if (f[i].getName().equals(name)) {
						return f[i];
					}
				}
			}
		}
		return null;
	}

	public File findFile(File dir, String name) {
		File[] f = dir.listFiles();
		if (f != null) {
			for (int i = 0; i < f.length; i++) {
				if (f[i].getName().equals(name)) {
					return f[i];
				}
			}
		}
		return null;
	}
}
