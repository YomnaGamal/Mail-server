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
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.DLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IMail;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;

public class Mail implements IMail {

	private String sender;
	/**
	 * . Queue of receivers
	 */
	private LinkedBased receivers;
	private String subject;
	private SLinkedList attachments;
	private File body;
	private String date;
	private String name;
	private String priority;
	private String starred;
	private String status;
	private String folder;
	private String deletionDate;
	private LinkedBased errors;
	private File folders;
	private File filters;
	Functions functions = new Functions();

	public File getFolders() {
		return folders;
	}

	public void setFolders(File folders) {
		this.folders = folders;
	}

	public File getFilters() {
		return filters;
	}

	public void setFilters(File filters) {
		this.filters = filters;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getDeletionDate() {
		return deletionDate;
	}

	public void setDeletionDate(String deletionDate) {
		this.deletionDate = deletionDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarred() {
		return starred;
	}

	public void setStarred(String starred) {
		this.starred = starred;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public LinkedBased getErrors() {
		return errors;
	}

	public void setErrors(LinkedBased errors) {
		this.errors = errors;
	}

	public SLinkedList getAttachments() {
		return attachments;
	}

	public void setAttachments(SLinkedList attachments) {
		this.attachments = attachments;
	}

	public File getBody() {
		return body;
	}

	public void setBody(File body) {
		this.body = body;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public LinkedBased getReceivers() {
		return receivers;
	}

	public void setReceivers(LinkedBased receivers) {
		this.receivers = receivers;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Mail() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = new Date();
		date = dateFormat.format(d);
		name = date;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == '/' || name.charAt(i) == ':') {
				name = name.substring(0, i) + " " + name.substring(i + 1, name.length());
			}
		}
		errors = new LinkedBased();
	}

	@Override
	public File newMail() {
		// TODO Auto-generated method stub
		File mail = new File(name);
		mail.mkdir();
		if (attachments != null && !attachments.isEmpty()) {
			File att = new File (mail, "Attachments.txt");
			try {
				att.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(att.getPath()));
				for (int i = 0; i < attachments.size(); i++) {
					File x = (File) attachments.get(i);
					String n = x.getAbsolutePath();
					bw.write(n);
					bw.newLine();
				}
				bw.flush();
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		File newBody = new File(mail, "Body.txt");
		try {
			Files.copy(Paths.get(body.getPath()), Paths.get(newBody.getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mail;
	}

	@Override
	public void inbox() {
		// TODO Auto-generated method stub
		String folder = searchFilters();
		LinkedBased r = new LinkedBased();
		while (!receivers.isEmpty()) {
			String temp = (String) receivers.dequeue();
			r.enqueue(temp);
		}
		String s;
		while (!r.isEmpty()) {
			s = (String) r.dequeue();
			File server = new File("Server");
			if (functions.findDir(server, s) != null) {
				receivers.enqueue(s);
				File x = newMail();
				File user = functions.findDir(server, s);
				File inbox = functions.findDir(user, folder);
				indexFile(inbox, sender, null);
				File mail = new File(inbox.getPath(), name);
				try {
					Files.move(Paths.get(x.getPath()), Paths.get(mail.getPath()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				errors.enqueue(s);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private String searchFilters() {
		SLinkedList names = new SLinkedList();
		SLinkedList filter = new SLinkedList();
		if (folders.length() != 0) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(folders.getPath()));
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
			try {
				Object obj = new JSONParser().parse(new FileReader(filters.getPath()));
				JSONObject j = (JSONObject) obj;
				for (int i = 0; i < names.size(); i++) {
					String s = (String) names.get(i);
					Map x = (Map) j.get(s);
					SearchFilter search = new SearchFilter();
					search.name = (String) x.get("Name");
					search.type = (String) x.get("Type");
					search.searchFor = (String) x.get("Filter");
					filter.add(search);
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
		for (int i = 0; i < filter.size(); i++) {
			SearchFilter x = new SearchFilter();
			x = (SearchFilter) filter.get(i);
			if (x.type.equals("Subject")) {
				if (subject.equals(x.searchFor)) {
					return x.name;
				}
			} else if (x.type.equals("Sender")) {
				if (sender.equals(x.searchFor)) {
					return x.name;
				}
			}
		}
		return "Inbox";
	}

	@Override
	public void sent() {
		// TODO Auto-generated method stub
		File x = newMail();
		File server = new File("Server");
		File user = functions.findDir(server, sender);
		File sent = functions.findDir(user, "Sent");
		indexFile(sent, null, receivers);
		File mail = new File(sent.getPath(), name);
		try {
			Files.move(Paths.get(x.getPath()), Paths.get(mail.getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		body.delete();
	}

	@Override
	public void draft() {
		// TODO Auto-generated method stub
		File x = newMail();
		File server = new File("Server");
		File contact = functions.findDir(server, sender);
		File draft = functions.findDir(contact, "Drafts");
		if (receivers == null) {
			receivers = new LinkedBased();
		}
		indexFile(draft, null, receivers);
		File mail = new File(draft.getPath(), name);
		try {
			Files.move(Paths.get(x.getPath()), Paths.get(mail.getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		body.delete();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void indexFile(File folder, String s, LinkedBased r) {
		// TODO Auto-generated method stub
		File index = functions.findFile(folder, "indexFile.json");
		SLinkedList mails = new SLinkedList();
		DLinkedList maps = new DLinkedList();
		File[] f = folder.listFiles();
		for (int i = 0; i < f.length; i++) {
			if (f[i].isDirectory()) {
				mails.add(f[i].getName());
			}
		}
		if (mails.size() != 0) {
			Object obj;
			try {
				obj = new JSONParser().parse(new FileReader(index.getPath()));
				JSONObject j = (JSONObject) obj;
				for (int i = 0; i < mails.size(); i++) {
					String name = (String) mails.get(i);
					Map x = (Map) j.get(name);
					maps.add(x);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JSONObject jo = new JSONObject();
		for (int i = 0; i < maps.size(); i++) {
			Map x = (Map) maps.get(i);
			String name = (String) x.get("Name");
			jo.put(name, x);
		}
		Map m = new LinkedHashMap();
		m.put("Subject", subject);
		m.put("Date", date);
		m.put("Name", name);
		m.put("Starred", "False");
		if (attachments == null) {
			m.put("Attachments", "0");
		} else {
			m.put("Attachments", Integer.toString(attachments.size()));
		}
		if (s != null) {
			m.put("Sender", s);
			m.put("Status", "Unread");
			m.put("Priority", priority);
		} else {
			m.put("Receivers", Integer.toString(r.size()));
			int i = 1;
			while (!r.isEmpty()) {
				m.put(Integer.toString(i), r.dequeue());
				i++;
			}
		}
		jo.put(name, m);
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
}
