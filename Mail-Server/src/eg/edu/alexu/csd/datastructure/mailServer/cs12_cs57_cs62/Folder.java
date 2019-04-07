package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IFolder;

public class Folder implements IFolder {

	private String folder;
	private String contact;
	Functions functions = new Functions();

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	@Override
	public File selectedFolder() {
		// TODO Auto-generated method stub
		File server = new File("Server");
		File user = functions.findDir(server, contact);
		File f = functions.findDir(user, folder);
		if (folder.equals("Trash")) {
			trash(f);
		}
		return f;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void trash(File f) {
		// TODO Auto-generated method stub
		DLinkedList maps = new DLinkedList();
		SLinkedList mails = new SLinkedList();
		File[] deleted = f.listFiles();
		for (int i = 0; i < deleted.length; i++) {
			if (deleted[i].isDirectory()) {
				mails.add(deleted[i].getName());
			}
		}
		File index = functions.findFile(f, "indexFile.json");
		if (mails.size() != 0) {
			Object obj;
			try {
				obj = new JSONParser().parse(new FileReader(index.getPath()));
				JSONObject j = (JSONObject) obj;
				for (int i = 0; i < mails.size(); i++) {
					String name = (String) mails.get(i);
					Map x = (Map) j.get(name);
					String date = (String) x.get("deletionDate");
					System.out.println(date);
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date d = new Date();
					String currentDate = format.format(d);
					Date d1 = null;
					Date d2 = null;
					try {
						d1 = format.parse(date);
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						d2 = format.parse(currentDate);
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					long diff = d2.getTime() - d1.getTime();
					long days = diff / (60 * 60 * 1000 * 24);
					if (days < 30) {
						maps.add(x);
					} else {
						File y = functions.findDir(f, name);
						y.delete();
						mails.remove(i);
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
		JSONObject jo = new JSONObject();
		for (int i = 0; i < maps.size(); i++) {
			Map x = (Map) maps.get(i);
			String name = (String) x.get("Name");
			jo.put(name, x);
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(index.getPath());
			pw.write(jo.toJSONString());
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean createNewFolder(String name, SearchFilter filter) {
		// TODO Auto-generated method stub
		File server = new File("Server");
		File user = functions.findDir(server, contact);
		if (functions.findDir(user, name) == null) {
			File newFolder = new File(user, name);
			newFolder.mkdir();
			File index = new File(newFolder, "indexFile.json");
			try {
				index.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				File folder = functions.findFile(user, "Folders.txt");
				SLinkedList folders = new SLinkedList();
				SLinkedList maps = new SLinkedList();
				if (folder.length() != 0) {
					try {
						BufferedReader br = new BufferedReader(new FileReader(folder.getPath()));
						String line;
						try {
							while ((line = br.readLine()) != null) {
								folders.add(line);
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
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(folder.getPath(), true));
					bw.write(name);
					bw.newLine();
					bw.flush();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File f = functions.findFile(user, "Filter.json");
				if (f.length() != 0) {
					try {
						Object obj = new JSONParser().parse(new FileReader(f.getPath()));
						JSONObject j = (JSONObject) obj;
						for (int i = 0; i < folders.size(); i++) {
							String s = (String) folders.get(i);
							Map x = (Map) j.get(s);
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
				Map newMap = new LinkedHashMap();
				newMap.put("Type", filter.type);
				newMap.put("Filter", filter.searchFor);
				newMap.put("Name", name);
				maps.add(newMap);
				JSONObject jo = new JSONObject();
				for (int i = 0; i < maps.size(); i++) {
					Map x = (Map) maps.get(i);
					String n = (String) x.get("Name");
					jo.put(n, x);
				}
				PrintWriter pw;
				try {
					pw = new PrintWriter(f.getPath());
					pw.write(jo.toJSONString());
					pw.flush();
					pw.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return true;
		}
		return false;
	}

	@Override
	public void deleteFolder(String name) {
		// TODO Auto-generated method stub
		File server = new File("Server");
		File user = functions.findDir(server, contact);
		File x = functions.findDir(user, name);
		x.delete();
	}

	@Override
	public void renameFolder(String name, String newName) {
		// TODO Auto-generated method stub
		File server = new File("Server");
		File user = functions.findDir(server, contact);
		File x = functions.findDir(user, name);
		File newFile = new File(user, newName);
		x.renameTo(newFile);
	}
}
