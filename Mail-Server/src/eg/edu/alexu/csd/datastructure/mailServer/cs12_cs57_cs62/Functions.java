package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;

public class Functions {

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

	@SuppressWarnings({ "rawtypes", "resource" })
	public DLinkedList readMails(File current) {
		SLinkedList names = new SLinkedList();
		DLinkedList mails = new DLinkedList();
		File index = findFile(current, "indexFile.json");
		File[] list = current.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				names.add(list[i].getName());
			}
		}
		if (names.size() != 0) {
			try {
				Object obj = new JSONParser().parse(new FileReader(index.getPath()));
				JSONObject j = (JSONObject) obj;
				for (int i = 0; i < names.size(); i++) {
					Map x = (Map) j.get((String) names.get(i));
					Mail y = new Mail();
					y.setSubject((String) x.get("Subject"));
					y.setDate((String) x.get("Date"));
					y.setName((String) x.get("Name"));
					y.setPriority((String) x.get("Priority"));
					if (current.getName().equals("Sent") || current.getName().equals("Drafts")) {
						y = sent(x, y);
						y.setStarred((String) x.get("Starred"));
					} else if (current.getName().equals("Trash")) {
						y = trash(x, y);
					} else if (current.getName().equals("Starred")) {
						y = starred(x, y);
					} else {
						y.setStarred((String) x.get("Starred"));
						y.setSender((String) x.get("Sender"));
						y.setStatus((String) x.get("Status"));
					}
					File m = findDir(current, y.getName());
					File body = findFile(m, "Body.txt");
					y.setBody(body);
					String temp = (String) x.get("Attachments");
					if (Integer.valueOf(temp) != 0) {
						File att = findFile(m, "Attachments.txt");
						BufferedReader bw = new BufferedReader(new FileReader(att));
						SLinkedList at = new SLinkedList();
						String a;
						while ((a = bw.readLine()) != null) {
							at.add(a);
						}
						y.setAttachments(at);
					}
					mails.add(y);
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
		
		return mails;
	}

	@SuppressWarnings("rawtypes")
	private Mail sent(Map x, Mail y) {
		LinkedBased receivers = new LinkedBased();
		String num = (String) x.get("Receivers");
		int n = Integer.valueOf(num);
		for (int k = 1; k <= n; k++) {
			String r = Integer.toString(k);
			receivers.enqueue((String) x.get(r));
		}
		y.setReceivers(receivers);
		return y;
	}
	
	@SuppressWarnings("rawtypes")
	private Mail trash(Map x, Mail y) {
		y.setFolder((String) x.get("Folder"));
		y.setDeletionDate((String) x.get("deletionDate"));
		if (y.getFolder().equals("Sent")) {
			y = sent(x, y);
		} else {
			y.setSender((String) x.get("Sender"));
		}
		return y;
	}
	
    @SuppressWarnings("rawtypes")
	private Mail starred(Map x, Mail y) {
    	y.setFolder((String) x.get("Folder"));
		if (y.getFolder().equals("Sent")) {
			y = sent(x, y);
		} else {
			y.setSender((String) x.get("Sender"));
			y.setStatus((String) x.get("Status"));
		}
		return y;
	}
}
